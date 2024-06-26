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
package hu.icellmobilsoft.coffee.system.jpa.converter;

import hu.icellmobilsoft.coffee.model.base.AbstractEntity;
import hu.icellmobilsoft.coffee.se.api.exception.BaseException;

/**
 * Simple entity converter.
 *
 * @author imre.scheffer
 * @param <ENTITY>
 *            Entity class
 * @param <DTO>
 *            DTO class
 * @since 1.0.0
 */
public interface IEntityConverter<ENTITY extends AbstractEntity, DTO> {

    /**
     * Transform entity to new dto
     *
     * @param entity
     *            entity
     * @return new dto
     * @throws BaseException
     *             exception
     */
    public DTO convert(ENTITY entity) throws BaseException;

    /**
     * Transform dto to new entity
     *
     * @param dto
     *            data transfer object
     * @return new entity
     * @throws BaseException
     *             exception
     */
    public ENTITY convert(DTO dto) throws BaseException;

    /**
     * Transform entity to dto
     *
     * @param destinationDto
     *            dto
     * @param sourceEntity
     *            entity
     * @throws BaseException
     *             exception
     */
    public void convert(DTO destinationDto, ENTITY sourceEntity) throws BaseException;

    /**
     * Transform dto to entity
     *
     * @param destinationEntity
     *            entity
     * @param sourceDto
     *            dto
     * @throws BaseException
     *             exception
     */
    public void convert(ENTITY destinationEntity, DTO sourceDto) throws BaseException;
}
