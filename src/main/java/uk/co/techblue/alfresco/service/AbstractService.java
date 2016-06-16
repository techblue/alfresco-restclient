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
package uk.co.techblue.alfresco.service;

import uk.co.techblue.alfresco.client.Resource;
import uk.co.techblue.alfresco.client.Service;

/**
 * The Class AbstractService.
 * 
 * @param <R> the generic type
 */
public abstract class AbstractService<R extends Resource> extends Service<R> {

    /** The auth ticket. */
    protected final String authTicket;

    /**
     * Instantiates a new abstract service.
     * 
     * @param restBaseUri the rest base uri
     * @param authTicket the auth ticket
     */
    public AbstractService(final String restBaseUri, final String authTicket) {
        super(restBaseUri);
        this.authTicket = authTicket;
    }

}
