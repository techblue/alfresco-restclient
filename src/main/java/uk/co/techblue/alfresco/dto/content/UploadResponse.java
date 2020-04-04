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

import com.fasterxml.jackson.annotation.JsonProperty;

import uk.co.techblue.alfresco.dto.BaseDto;

/**
 * The Class UploadResponse.
 */
public class UploadResponse extends BaseDto {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 929614332679783487L;

    /** The node ref. */
    @JsonProperty
    private String nodeRef;

    /** The file name. */
    @JsonProperty
    private String fileName;

    /** The status. */
    @JsonProperty
    private UploadStatus status;

    /**
     * Gets the node ref.
     * 
     * @return the node ref
     */
    public String getNodeRef() {
        return nodeRef;
    }

    /**
     * Sets the node ref.
     * 
     * @param nodeRef the new node ref
     */
    public void setNodeRef(final String nodeRef) {
        this.nodeRef = nodeRef;
    }

    /**
     * Gets the file name.
     * 
     * @return the file name
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * Sets the file name.
     * 
     * @param fileName the new file name
     */
    public void setFileName(final String fileName) {
        this.fileName = fileName;
    }

    /**
     * Gets the status.
     * 
     * @return the status
     */
    public UploadStatus getStatus() {
        return status;
    }

    /**
     * Sets the status.
     * 
     * @param status the new status
     */
    public void setStatus(final UploadStatus status) {
        this.status = status;
    }

}
