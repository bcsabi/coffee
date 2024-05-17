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
package hu.icellmobilsoft.coffee.jpa.sql.batch;

/**
 * Batch mentessekkel foglalkozo osztaly
 *
 * @deprecated A könnyebb átállás érdekében az osztályból interface lett és kiterjeszti az {@link IJpaBatchService}-t, melynek implementációja a
 *             Frapp:EE projektben található. Helyette az {@link IJpaBatchService} használandó.
 *
 * @author imre.scheffer
 * @author robert.kaplar
 * @author csaba.balogh
 * @since 1.0.0
 */
@Deprecated(since = "2.8.0", forRemoval = true)
public interface BatchService extends IJpaBatchService {

}
