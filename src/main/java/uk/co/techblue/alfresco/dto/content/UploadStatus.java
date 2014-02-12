/*******************************************************************************
 * Copyright 2012 Technology Blueprint Ltd
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package uk.co.techblue.alfresco.dto.content;

import org.codehaus.jackson.annotate.JsonProperty;

import uk.co.techblue.alfresco.dto.BaseDto;

/**
 * The Class UploadStatus.
 */
public class UploadStatus extends BaseDto {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -3478133165362156920L;

    /** The code. */
    @JsonProperty
    private int code;

    /** The name. */
    @JsonProperty
    private String name;

    /** The description. */
    @JsonProperty
    private String description;

    /**
     * Gets the code.
     * 
     * @return the code
     */
    public int getCode() {
        return code;
    }

    /**
     * Sets the code.
     * 
     * @param code the new code
     */
    public void setCode(final int code) {
        this.code = code;
    }

    /**
     * Gets the name.
     * 
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name.
     * 
     * @param name the new name
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * Gets the description.
     * 
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description.
     * 
     * @param description the new description
     */
    public void setDescription(final String description) {
        this.description = description;
    }

}
