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
 * FolderCreationResponse.java
 * 
 * @author <a href="mailto:dishant.anand@techblue.co.uk">Dishant Anand</a>
 */
public class FolderCreationResponse extends BaseDto {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 4774217252641874172L;

    /** The name. */
    private String name;

    /** The object id. */
    private String objectId;

    /** The node reference. */
    @JsonProperty("nodeRef")
    private String nodeReference;

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
     * Gets the object id.
     * 
     * @return the object id
     */
    public String getObjectId() {
        return objectId;
    }

    /**
     * Sets the object id.
     * 
     * @param objectId the new object id
     */
    public void setObjectId(final String objectId) {
        this.objectId = objectId;
    }

    /**
     * Gets the node reference.
     * 
     * @return the node reference
     */
    public String getNodeReference() {
        return nodeReference;
    }

    /**
     * Sets the node reference.
     * 
     * @param nodeReference the new node reference
     */
    public void setNodeReference(final String nodeReference) {
        this.nodeReference = nodeReference;
    }

}
