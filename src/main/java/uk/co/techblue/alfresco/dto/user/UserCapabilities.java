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
package uk.co.techblue.alfresco.dto.user;

import org.codehaus.jackson.annotate.JsonProperty;

import uk.co.techblue.alfresco.dto.BaseDto;

/**
 * The Class UserCapabilities.
 */
public class UserCapabilities extends BaseDto {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1663942471397952257L;

    /** The is mutable. */
    @JsonProperty
    private boolean isMutable;

    /** The is guest. */
    @JsonProperty
    private boolean isGuest;

    /** The is admin. */
    @JsonProperty
    private boolean isAdmin;

    /**
     * Checks if is mutable.
     * 
     * @return true, if is mutable
     */
    public boolean isMutable() {
        return isMutable;
    }

    /**
     * Sets the mutable.
     * 
     * @param isMutable the new mutable
     */
    public void setMutable(final boolean isMutable) {
        this.isMutable = isMutable;
    }

    /**
     * Checks if is guest.
     * 
     * @return true, if is guest
     */
    public boolean isGuest() {
        return isGuest;
    }

    /**
     * Sets the guest.
     * 
     * @param isGuest the new guest
     */
    public void setGuest(final boolean isGuest) {
        this.isGuest = isGuest;
    }

    /**
     * Checks if is admin.
     * 
     * @return true, if is admin
     */
    public boolean isAdmin() {
        return isAdmin;
    }

    /**
     * Sets the admin.
     * 
     * @param isAdmin the new admin
     */
    public void setAdmin(final boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

}
