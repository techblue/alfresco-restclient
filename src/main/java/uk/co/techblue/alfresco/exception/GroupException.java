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
 * The Class GroupException.
 */
public class GroupException extends AlfrescoServiceException {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -1943453715951536242L;

    /**
     * Instantiates a new group exception.
     * 
     * @param message the message
     * @param cause the cause
     */
    public GroupException(final String message, final Throwable cause) {
        super(message, cause);
    }

    /**
     * Instantiates a new group exception.
     * 
     * @param message the message
     */
    public GroupException(final String message) {
        super(message);
    }

    /**
     * Instantiates a new group exception.
     * 
     * @param cause the cause
     */
    public GroupException(final Throwable cause) {
        super(cause);
    }

}
