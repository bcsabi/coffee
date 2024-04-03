/*-
 * #%L
 * Coffee
 * %%
 * Copyright (C) 2020 - 2022 i-Cell Mobilsoft Zrt.
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
package hu.icellmobilsoft.coffee.module.configdoc.data;

import hu.icellmobilsoft.coffee.module.configdoc.ConfigDoc;

/**
 * Data class for the collected {@link ConfigDoc} annotation data.
 *
 * @author martin.nagy
 * @since 1.9.0
 */
public class DocData {
    private final String key;
    private final String source;
    private final String description;
    private final String defaultValue;
    private final String since;
    private final String title;

    /**
     * Creates a {@code DocData} instance with the given arguments
     * 
     * @param key
     *            the configuration key
     * @param source
     *            the source class where the configuration key can be found
     * @param description
     *            the description of the configuration key
     * @param defaultValue
     *            the default value of the configuration key
     * @param since
     *            the version since the configuration key available
     * @param title
     *            the title for overwriting the default
     */
    public DocData(String key, String source, String description, String defaultValue, String since, String title) {
        this.key = key;
        this.source = source;
        this.description = description;
        this.defaultValue = defaultValue;
        this.since = since;
        this.title = title;
    }

    /**
     * Returns the configuration key
     * 
     * @return the configuration key
     */
    public String getKey() {
        return key;
    }

    /**
     * Returns the source class where the configuration key can be found
     * 
     * @return the source class where the configuration key can be found
     */
    public String getSource() {
        return source;
    }

    /**
     * Returns the description of the configuration key
     * 
     * @return the description of the configuration key
     */
    public String getDescription() {
        return description;
    }

    /**
     * Returns the default value of the configuration key
     * 
     * @return the default value of the configuration key
     */
    public String getDefaultValue() {
        return defaultValue;
    }

    /**
     * Returns the version since the configuration key available
     *
     * @return the version since the configuration key available
     * @since 1.10.0
     */
    public String getSince() {
        return since;
    }

    /**
     * Returns the title for the table
     *
     * @return the title for the table
     * @since 2.7.0
     */
    public String getTitle() {
        return title;
    }

}
