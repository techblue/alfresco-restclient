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
package uk.co.techblue.alfresco.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class Credentials.
 */
public class Credentials extends BaseDto {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -6492209613647675748L;

	/** The username. */
	@JsonProperty(value = "username")
    private final String username;

	/** The password. */
	@JsonProperty(value = "password")
    private final String password;


    /**
     * Instantiates a new credentials.
     *
     * @param username the username
     * @param password the password
     */
    public Credentials(final String username,final String password) {
        this.username = username;
        this.password = password;
    }

	/**
	 * Gets the username.
	 *
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}


	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	
	
    
}
