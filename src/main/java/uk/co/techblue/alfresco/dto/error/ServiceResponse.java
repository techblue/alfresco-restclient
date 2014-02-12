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
package uk.co.techblue.alfresco.dto.error;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

import uk.co.techblue.alfresco.dto.BaseDto;

/**
 * The Class ServiceResponse.
 */
public class ServiceResponse extends BaseDto {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -5904389506284205882L;

    /** The status. */
    @JsonProperty
    private ServiceResponseStatus status;

    /** The message. */
    @JsonProperty("message")
    private String message;

    /** The exception. */
    @JsonProperty
    private String exception;

    /** The callstack. */
    @JsonProperty
    private List<String> callstack;

    /** The server. */
    @JsonProperty
    private String server;

    /** The time. */
    @JsonProperty
    private String time;

    /**
     * Gets the status.
     * 
     * @return the status
     */
    public ServiceResponseStatus getStatus() {
        return status;
    }

    /**
     * Sets the status.
     * 
     * @param status the new status
     */
    public void setStatus(final ServiceResponseStatus status) {
        this.status = status;
    }

    /**
     * Gets the message.
     * 
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the message.
     * 
     * @param message the new message
     */
    public void setMessage(final String message) {
        this.message = message;
    }

    /**
     * Gets the exception.
     * 
     * @return the exception
     */
    public String getException() {
        return exception;
    }

    /**
     * Sets the exception.
     * 
     * @param exception the new exception
     */
    public void setException(final String exception) {
        this.exception = exception;
    }

    /**
     * Gets the callstack.
     * 
     * @return the callstack
     */
    public List<String> getCallstack() {
        return callstack;
    }

    /**
     * Sets the callstack.
     * 
     * @param callstack the new callstack
     */
    public void setCallstack(final List<String> callstack) {
        this.callstack = callstack;
    }

    /**
     * Gets the server.
     * 
     * @return the server
     */
    public String getServer() {
        return server;
    }

    /**
     * Sets the server.
     * 
     * @param server the new server
     */
    public void setServer(final String server) {
        this.server = server;
    }

    /**
     * Gets the time.
     * 
     * @return the time
     */
    public String getTime() {
        return time;
    }

    /**
     * Sets the time.
     * 
     * @param time the new time
     */
    public void setTime(final String time) {
        this.time = time;
    }

}