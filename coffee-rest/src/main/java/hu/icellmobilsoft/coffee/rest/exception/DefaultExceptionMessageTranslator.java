/*-
 * #%L
 * Coffee
 * %%
 * Copyright (C) 2020 i-Cell Mobilsoft Zrt.
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
package hu.icellmobilsoft.coffee.rest.exception;

import javax.inject.Inject;
import javax.xml.bind.JAXBException;

import org.apache.deltaspike.core.api.projectstage.ProjectStage;

import hu.icellmobilsoft.coffee.dto.common.commonservice.BaseExceptionResultType;
import hu.icellmobilsoft.coffee.dto.common.commonservice.FunctionCodeType;
import hu.icellmobilsoft.coffee.dto.exception.BaseException;
import hu.icellmobilsoft.coffee.dto.exception.RestClientResponseException;
import hu.icellmobilsoft.coffee.dto.exception.enums.CoffeeFaultType;
import hu.icellmobilsoft.coffee.rest.cdi.BaseApplicationContainer;
import hu.icellmobilsoft.coffee.rest.locale.LocalizedMessage;
import hu.icellmobilsoft.coffee.se.logging.Logger;

/**
 * Default exception translator implementation for exception throwing
 *
 * @author imre.scheffer
 * @since 1.0.0
 */
public class DefaultExceptionMessageTranslator implements IExceptionMessageTranslator {

    @Inject
    private BaseApplicationContainer baseApplicationContainer;

    /** Constant <code>HTTP_STATUS_I_AM_A_TEAPOT=418</code> */
    public static final int HTTP_STATUS_I_AM_A_TEAPOT = 418;

    @Inject
    private LocalizedMessage localizedMessage;

    @Inject
    private ProjectStage projectStage;

    /** {@inheritDoc} */
    @Override
    public void addCommonInfo(BaseExceptionResultType dto, BaseException e) {
        addCommonInfo(dto, e, e.getFaultTypeEnum());
    }

    /** {@inheritDoc} */
    @Override
    public void addCommonInfo(BaseExceptionResultType dto, Throwable t, Enum<?> faultType) {
        boolean putExceptionToResponse = !ProjectStage.Production.equals(projectStage);
        if (putExceptionToResponse) {
            if (t instanceof JAXBException) {
                dto.setMessage(getLinkedExceptionLocalizedMessage((JAXBException) t));
            } else {
                dto.setMessage(t.getLocalizedMessage());
            }

            if (t.getCause() != null) {
                var causedBy = new BaseExceptionResultType();
                if (t.getCause() instanceof BaseException) {
                    addCommonInfo(causedBy, (BaseException) t.getCause());
                } else {
                    addCommonInfo(causedBy, t.getCause(), faultType);
                }
                dto.setCausedBy(causedBy);
            }
        }
        dto.setFaultType(faultType.name());
        dto.setFuncCode(FunctionCodeType.ERROR);

        // nyelvesitett valasz kell a faultype szerint
        dto.setMessage(getLocalizedMessage(faultType));

        if (t instanceof RestClientResponseException) {
            var restClientResponseException = (RestClientResponseException) t;
            dto.setService(restClientResponseException.getService());
            if (putExceptionToResponse) {
                dto.setClassName(restClientResponseException.getClassName());
                dto.setException(restClientResponseException.getException());
            }
        } else {
            dto.setService(baseApplicationContainer.getCoffeeAppName());
            if (putExceptionToResponse) {
                dto.setClassName(t.getClass().getName());
                dto.setException(t.getMessage());
            }
        }
    }

    /** {@inheritDoc} */
    @Override
    public String getLocalizedMessage(Enum<?> faultType) {
        if (faultType == null) {
            Logger.getLogger(DefaultExceptionMessageTranslator.class)
                    .warn("FaultType is null, proceeding with faultType: [" + CoffeeFaultType.OPERATION_FAILED + "]");
            return localizedMessage.message(CoffeeFaultType.OPERATION_FAILED);
        }
        return localizedMessage.message(faultType);
    }

}
