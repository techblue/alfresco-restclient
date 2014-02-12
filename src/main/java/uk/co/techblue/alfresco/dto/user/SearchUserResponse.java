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

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

import uk.co.techblue.alfresco.dto.BaseDto;

/**
 * The Class SearchUserResponse.
 */
public class SearchUserResponse extends BaseDto {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -7759949462365660224L;

    /** The users. */
    @JsonProperty("people")
    private List<User> users;

    /**
     * Gets the users.
     * 
     * @return the users
     */
    public List<User> getUsers() {
        return users;
    }

    /**
     * Sets the users.
     * 
     * @param users the new users
     */
    public void setUsers(final List<User> users) {
        this.users = users;
    }

}
