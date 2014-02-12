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
 * The Class ChangePassword.
 */
public class ChangePassword extends BaseDto {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -1117653125171397058L;

    /** The old password. */
    @JsonProperty("oldpw")
    private String oldPassword;

    /** The new password. */
    @JsonProperty("newpw")
    private String newPassword;

    /**
     * Gets the old password.
     * 
     * @return the old password
     */
    public String getOldPassword() {
        return oldPassword;
    }

    /**
     * Sets the old password.
     * 
     * @param oldPassword the new old password
     */
    public void setOldPassword(final String oldPassword) {
        this.oldPassword = oldPassword;
    }

    /**
     * Gets the new password.
     * 
     * @return the new password
     */
    public String getNewPassword() {
        return newPassword;
    }

    /**
     * Sets the new password.
     * 
     * @param newPassword the new new password
     */
    public void setNewPassword(final String newPassword) {
        this.newPassword = newPassword;
    }

}
