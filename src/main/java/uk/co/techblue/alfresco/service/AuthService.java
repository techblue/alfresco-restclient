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

import org.jboss.resteasy.client.ClientResponse;

import uk.co.techblue.alfresco.client.Service;
import uk.co.techblue.alfresco.dto.AuthResponse;
import uk.co.techblue.alfresco.dto.Credentials;
import uk.co.techblue.alfresco.dto.error.ServiceResponse;
import uk.co.techblue.alfresco.exception.AuthenticationException;
import uk.co.techblue.alfresco.resource.AuthResource;

/**
 * The Class AuthService.
 */
public class AuthService extends Service<AuthResource> {

    /** The credentials. */
    protected final Credentials credentials;

    /**
     * Instantiates a new auth service.
     * 
     * @param restBaseUri the rest base uri
     * @param credentials the credentials
     */
    public AuthService(final String restBaseUri, final Credentials credentials) {
        super(restBaseUri);
        this.credentials = credentials;
    }

    /**
     * Instantiates a new auth service.
     * 
     * @param restBaseUri the rest base uri
     */
    public AuthService(final String restBaseUri) {
        super(restBaseUri);
        this.credentials = null;
    }

    /*
     * @see uk.co.techblue.alfresco.client.Service#getResourceClass()
     */
    @Override
    protected Class<AuthResource> getResourceClass() {
        return AuthResource.class;
    }

    /**
     * Login.
     * 
     * @return the auth response
     * @throws AuthenticationException the authentication exception
     */
    public AuthResponse login() throws AuthenticationException {
        final ClientResponse<AuthResponse> authResponse = resourceProxy.login(credentials);
        return parseEntityFromResponse(authResponse, AuthenticationException.class);
    }

    /**
     * Logout.
     * 
     * @param authTicket the auth ticket
     * @return the service response
     * @throws AuthenticationException the authentication exception
     */
    public ServiceResponse logout(final String authTicket) throws AuthenticationException {
        final ClientResponse<ServiceResponse> authResponse = resourceProxy.logout(authTicket, authTicket, "json");
        return parseEntityFromResponse(authResponse, AuthenticationException.class);
    }

}
