/*-
 * #%L
 * Coffee
 * %%
 * Copyright (C) 2020 - 2024 i-Cell Mobilsoft Zrt.
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
package hu.icellmobilsoft.quarkus.extension.greeting.deployment;

import java.util.List;

import io.quarkus.builder.item.SimpleBuildItem;

/**
 * Build item which contains faultType's classes
 *
 * @since 2.6.0
 * @author speter555
 */
public final class FaultTypeClassesBuildItem extends SimpleBuildItem {

    private final List<Class<? extends Enum>> faultTypeClasses;

    /**
     * Constructor
     *
     * @param faultTypeClasses
     *            list of enum classNames
     */
    public FaultTypeClassesBuildItem(List<Class<? extends Enum>> faultTypeClasses) {
        this.faultTypeClasses = faultTypeClasses;
    }

    /**
     * Getter of FaultTypeClasses
     * 
     * @return asdf
     */
    public List<Class<? extends Enum>> getFaultTypeClasses() {
        return faultTypeClasses;
    }
}
