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
import uk.co.techblue.alfresco.dto.common.UserRole;

/**
 * The Class Permission.
 */
public class Permission extends BaseDto {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The role. */
    @JsonProperty("role")
    private UserRole role;

    /** The authority. */
    @JsonProperty("authority")
    private String authority;

    /** The remove. */
    @JsonProperty("remove")
    private boolean remove;

    /**
     * Gets the role.
     * 
     * @return the role
     */
    public UserRole getRole() {
        return role;
    }

    /**
     * Sets the role.
     * 
     * @param role the new role
     */
    public void setRole(final UserRole role) {
        this.role = role;
    }

    /**
     * Gets the authority (User or Group).Group names are prefixed by GROUP_
     * 
     * @return the authority
     */
    public String getAuthority() {
        return authority;
    }

    /**
     * Sets the authority (User or Group). Group names must be prefixed by GROUP_
     * 
     * @param authority the new authority
     */
    public void setAuthority(final String authority) {
        this.authority = authority;
    }

    /**
     * Checks if is removes the.
     * 
     * @return true, if is removes the
     */
    public boolean isRemove() {
        return remove;
    }

    /**
     * Sets the removes the.
     * 
     * @param remove the new removes the
     */
    public void setRemove(final boolean remove) {
        this.remove = remove;
    }

}
