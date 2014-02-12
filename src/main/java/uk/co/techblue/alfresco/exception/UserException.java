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
package uk.co.techblue.alfresco.exception;

/**
 * The Class UserException.
 */
public class UserException extends AlfrescoServiceException {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 3595946830238681190L;

    /**
     * Instantiates a new user exception.
     * 
     * @param message the message
     * @param cause the cause
     */
    public UserException(final String message,final  Throwable cause) {
        super(message, cause);
    }

    /**
     * Instantiates a new user exception.
     * 
     * @param message the message
     */
    public UserException(final String message) {
        super(message);
    }

    /**
     * Instantiates a new user exception.
     * 
     * @param cause the cause
     */
    public UserException(final Throwable cause) {
        super(cause);
    }

}
