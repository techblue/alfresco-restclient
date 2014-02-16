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
import uk.co.techblue.alfresco.dto.content.PermissionRequest;
import uk.co.techblue.alfresco.dto.content.PermissionServiceResponse;

/**
 * The Interface PermissionResource.
 */
// @Path("/alfresco/service/slingshot/doclib/")
@Path(AlfrescoConstants.RESOURCE_CONTEXT_BASE_PATH)
public interface PermissionResource extends Resource {

    /**
     * Sets the permissions.
     * 
     * @param ticket the ticket
     * @param storeType the store type
     * @param storeId the store id
     * @param nodeId the node id
     * @param permissionRequest the permission request
     * @return the client response
     */
    @POST
    @Path("permissions/{storeType}/{storeId}/{nodeId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    ClientResponse<String> setPermissions(@QueryParam(AlfrescoConstants.AUTH_TICKET_PARAM_NAME) String ticket,
        @PathParam("storeType") String storeType, @PathParam("storeId") String storeId, @PathParam("nodeId") String nodeId,
        PermissionRequest permissionRequest);

    @GET
    @Path("/alfresco/service/permissions/{store_type}/{store_id}/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    ClientResponse<String> readPermissions(@QueryParam(AlfrescoConstants.AUTH_TICKET_PARAM_NAME) String ticket,
        @PathParam("store_type") String storeType, @PathParam("store_id") String storeId, @PathParam("id") String nodeId);

    @GET
    @Path("/set/folder/permission")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    ClientResponse<PermissionServiceResponse> setPermissions(@QueryParam(AlfrescoConstants.AUTH_TICKET_PARAM_NAME) String ticket, @QueryParam("nodeId") String nodeId,
        @QueryParam("authorityType") final String authorityType,
        @QueryParam("userGroupType") final String userGroupType);

}
