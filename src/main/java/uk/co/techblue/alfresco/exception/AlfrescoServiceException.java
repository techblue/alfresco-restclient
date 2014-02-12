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

import uk.co.techblue.alfresco.dto.error.ServiceResponse;

/**
 * The Class AlfrescoServiceException.
 */
public class AlfrescoServiceException extends Exception {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -6081873510684510L;

    /** The error response. */
    private ServiceResponse errorResponse;

    /**
     * Instantiates a new alfresco service exception.
     * 
     * @param message the message
     * @param cause the cause
     */
    public AlfrescoServiceException(final String message, final Throwable cause) {
        super(message, cause);
    }

    /**
     * Instantiates a new alfresco service exception.
     * 
     * @param message the message
     */
    public AlfrescoServiceException(final String message) {
        super(message);
    }

    /**
     * Instantiates a new alfresco service exception.
     * 
     * @param cause the cause
     */
    public AlfrescoServiceException(final Throwable cause) {
        super(cause);
    }

    /**
     * Gets the error response.
     * 
     * @return the error response
     */
    public ServiceResponse getErrorResponse() {
        return errorResponse;
    }

    /**
     * Sets the error response.
     * 
     * @param errorResponse the new error response
     */
    public void setErrorResponse(final ServiceResponse errorResponse) {
        this.errorResponse = errorResponse;
    }

}
