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

/**
 * The Class NodeUpdateStatus.
 */
public class NodeUpdateStatus {

    /** The status. */
    @JsonProperty("success")
    private boolean status;

    /**
     * Checks if is status.
     * 
     * @return true, if is status
     */
    public boolean isStatus() {
        return status;
    }

    /**
     * Sets the status.
     * 
     * @param status the new status
     */
    public void setStatus(final boolean status) {
        this.status = status;
    }

}
