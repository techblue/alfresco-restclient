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
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.client.ClientResponse;

import uk.co.techblue.alfresco.client.Resource;
import uk.co.techblue.alfresco.commons.AlfrescoConstants;
import uk.co.techblue.alfresco.dto.content.ContentNode;
import uk.co.techblue.alfresco.dto.user.AddUser;
import uk.co.techblue.alfresco.dto.user.ChangePassword;
import uk.co.techblue.alfresco.dto.user.SearchUserResponse;
import uk.co.techblue.alfresco.dto.user.User;

/**
 * The Interface UserResource.
 */
@Path(AlfrescoConstants.RESOURCE_CONTEXT_BASE_PATH)
public interface UserResource extends Resource {

    /**
     * Gets the users.
     * 
     * @param ticket the ticket
     * @param filter the filter
     * @param maxResults the max results
     * @return the users
     */
    @GET
    @Path("people")
    @Produces(MediaType.APPLICATION_JSON)
    ClientResponse<SearchUserResponse> getUsers(
        @QueryParam(AlfrescoConstants.AUTH_TICKET_PARAM_NAME) String ticket,
        @QueryParam("filter") String filter,
        @QueryParam("maxResults") int maxResults);

    /**
     * Gets the user.
     * 
     * @param ticket the ticket
     * @param username the username
     * @return the user
     */
    @GET
    @Path("people/{username}")
    @Produces(MediaType.APPLICATION_JSON)
    ClientResponse<User> getUser(
        @QueryParam(AlfrescoConstants.AUTH_TICKET_PARAM_NAME) String ticket,
        @PathParam("username") String username);

    /**
     * Creates the user.
     * 
     * @param ticket the ticket
     * @param user the user
     * @return the client response
     */
    @POST
    @Path("people")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    ClientResponse<User> createUser(
        @QueryParam(AlfrescoConstants.AUTH_TICKET_PARAM_NAME) String ticket,
        AddUser user);

    /**
     * Change password.
     * 
     * @param ticket the ticket
     * @param username the username
     * @param changePassword the change password
     * @return the client response
     */
    @POST
    @Path("person/changepassword/{username}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    ClientResponse<String> changePassword(
        @QueryParam(AlfrescoConstants.AUTH_TICKET_PARAM_NAME) String ticket,
        @PathParam("username") String username,
        ChangePassword changePassword);

    /**
     * Delete user.
     * 
     * @param ticket the ticket
     * @param username the username
     * @return the client response
     */
    @DELETE
    @Path("people/{username}")
    @Produces(MediaType.APPLICATION_JSON)
    ClientResponse<String> deleteUser(
        @QueryParam(AlfrescoConstants.AUTH_TICKET_PARAM_NAME) String ticket,
        @PathParam("username") String username);

    /**
     * Update user.
     * 
     * @param ticket the ticket
     * @param username the username
     * @param user the user
     * @return the client response
     */
    @PUT
    @Path("people/{username}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    ClientResponse<String> updateUser(
        @QueryParam(AlfrescoConstants.AUTH_TICKET_PARAM_NAME) String ticket,
        @PathParam("username") String username, User user);

    /**
     * Gets the user home.
     * 
     * @param ticket the ticket
     * @param username the username
     * @return the user home
     */
    @GET
    @Path("people/{username}/home")
    @Produces(MediaType.APPLICATION_JSON)
    ClientResponse<ContentNode> getUserHome(
        @QueryParam(AlfrescoConstants.AUTH_TICKET_PARAM_NAME) String ticket,
        @PathParam("username") String username);

}
