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

import java.util.Map;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.annotations.Form;
import org.jboss.resteasy.client.ClientResponse;

import uk.co.techblue.alfresco.client.Resource;
import uk.co.techblue.alfresco.commons.AlfrescoConstants;
import uk.co.techblue.alfresco.dto.user.AuthorityQuery;
import uk.co.techblue.alfresco.dto.user.Group;
import uk.co.techblue.alfresco.dto.user.GroupQuery;
import uk.co.techblue.alfresco.dto.user.SearchGroupResponse;

/**
 * The Interface GroupResource.
 */
@Path(AlfrescoConstants.RESOURCE_CONTEXT_BASE_PATH)
public interface GroupResource extends Resource {

    /**
     * Gets the groups.
     * 
     * @param ticket the ticket
     * @param groupQuery the group query
     * @return the groups
     */
    @GET
    @Path("groups")
    @Produces(MediaType.APPLICATION_JSON)
    ClientResponse<SearchGroupResponse> getGroups(
        @QueryParam(AlfrescoConstants.AUTH_TICKET_PARAM_NAME) String ticket,
        @Form GroupQuery groupQuery);

    /**
     * Gets the group.
     * 
     * @param ticket the ticket
     * @param shortName the short name
     * @return the group
     */
    @GET
    @Path("groups/{shortName}")
    @Produces(MediaType.APPLICATION_JSON)
    ClientResponse<Map<String, Group>> getGroup(
        @QueryParam(AlfrescoConstants.AUTH_TICKET_PARAM_NAME) String ticket,
        @PathParam("shortName") String shortName);

    /**
     * Gets the root groups.
     * 
     * @param ticket the ticket
     * @param groupQuery the group query
     * @return the root groups
     */
    @GET
    @Path("rootgroups")
    @Produces(MediaType.APPLICATION_JSON)
    ClientResponse<SearchGroupResponse> getRootGroups(
        @QueryParam(AlfrescoConstants.AUTH_TICKET_PARAM_NAME) String ticket,
        @Form GroupQuery groupQuery);

    /**
     * Gets the child authorities.
     * 
     * @param ticket the ticket
     * @param shortName the short name
     * @param authorityQuery the authority query
     * @return the child authorities
     */
    @GET
    @Path("groups/{shortName}/children")
    @Produces(MediaType.APPLICATION_JSON)
    ClientResponse<SearchGroupResponse> getChildAuthorities(
        @QueryParam(AlfrescoConstants.AUTH_TICKET_PARAM_NAME) String ticket,
        @PathParam("shortName") String shortName,
        @Form AuthorityQuery authorityQuery);

    /**
     * Gets the parent authorities.
     * 
     * @param ticket the ticket
     * @param shortName the short name
     * @param authorityQuery the authority query
     * @return the parent authorities
     */
    @GET
    @Path("groups/{shortName}/parents")
    @Produces(MediaType.APPLICATION_JSON)
    ClientResponse<SearchGroupResponse> getParentAuthorities(
        @QueryParam(AlfrescoConstants.AUTH_TICKET_PARAM_NAME) String ticket,
        @PathParam("shortName") String shortName,
        @Form AuthorityQuery authorityQuery);

    /**
     * Delete group.
     * 
     * @param ticket the ticket
     * @param shortName the short name
     * @return the client response
     */
    @DELETE
    @Path("groups/{shortName}")
    @Produces(MediaType.APPLICATION_JSON)
    ClientResponse<String> deleteGroup(
        @QueryParam(AlfrescoConstants.AUTH_TICKET_PARAM_NAME) String ticket,
        @PathParam("shortName") String shortName);

}
