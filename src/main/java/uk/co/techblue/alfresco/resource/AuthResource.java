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
package uk.co.techblue.alfresco.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.client.ClientResponse;

import uk.co.techblue.alfresco.client.Resource;
import uk.co.techblue.alfresco.commons.AlfrescoConstants;
import uk.co.techblue.alfresco.dto.AuthResponse;
import uk.co.techblue.alfresco.dto.Credentials;
import uk.co.techblue.alfresco.dto.error.ServiceResponse;

/**
 * The Interface AuthResource.
 */
@Path(AlfrescoConstants.RESOURCE_CONTEXT_BASE_PATH)
public interface AuthResource extends Resource {

    /**
     * Login.
     * 
     * @param credentials the credentials
     * @return the client response
     */
    @POST
    @Path("login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    ClientResponse<AuthResponse> login(Credentials credentials);

    /**
     * Logout.
     * 
     * @param ticket the ticket
     * @param authTicket the auth ticket
     * @param responseFormat the response format
     * @return the client response
     */
    @DELETE
    @Path("login/ticket/{ticket}")
    @Produces(MediaType.APPLICATION_JSON)
    ClientResponse<ServiceResponse> logout(
        @PathParam("ticket") String ticket,
        @QueryParam(AlfrescoConstants.AUTH_TICKET_PARAM_NAME) String authTicket,
        @QueryParam("format") String responseFormat);

    /**
     * Validate ticket.
     *
     * @param ticket the ticket
     * @return the client response
     */
    @GET
    @Path("login/ticket/{ticket}")
    ClientResponse<String> validateTicket(@PathParam("ticket") String ticket, @QueryParam(AlfrescoConstants.AUTH_TICKET_PARAM_NAME) String authTicket,
        @QueryParam("format") String responseFormat);

}
