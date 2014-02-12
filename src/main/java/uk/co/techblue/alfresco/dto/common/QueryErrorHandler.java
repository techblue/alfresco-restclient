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
package uk.co.techblue.alfresco.dto.common;

/**
 * The Enum QueryErrorHandler.
 */
public enum QueryErrorHandler {

    /** The exception. */
    EXCEPTION("exception"), 
    
    /** The no results. */
    NO_RESULTS("no-results");

    /** The name. */
    private String name;

    /**
     * Instantiates a new query error handler.
     *
     * @param name the name
     */
    private QueryErrorHandler(final String name) {
        this.name = name;
    }

    /* 
     * @see java.lang.Enum#toString()
     */
    @Override
    public String toString() {
        return name;
    }
}
