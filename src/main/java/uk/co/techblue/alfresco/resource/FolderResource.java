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
import uk.co.techblue.alfresco.dto.content.FolderCreationResponse;
import uk.co.techblue.alfresco.dto.content.FolderRequest;

/**
 * FolderResource.java
 *
 * @author <a href="mailto:dishant.anand@techblue.co.uk">Dishant Anand</a>
 */
@Path(AlfrescoConstants.RESOURCE_CONTEXT_BASE_PATH)
public interface FolderResource extends Resource {

    /**
     * Creates the folder.
     *
     * @param ticket the ticket
     * @param storeType the store type
     * @param storeId the store id
     * @param nodeId the node id
     * @param folderName the folder name
     * @return the client response
     */
    @GET
    @Path("/folder/create/{store_type}/{store_id}/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    ClientResponse<String> createFolder(@QueryParam(AlfrescoConstants.AUTH_TICKET_PARAM_NAME) final String ticket,
        @PathParam("store_type") final String storeType, @PathParam("store_id") final String storeId, @PathParam("id") String nodeId, @QueryParam("folderName") String folderName);

    /**
     * Search folder.
     *
     * @param ticket the ticket
     * @param storeType the store type
     * @param storeId the store id
     * @param nodeId the node id
     * @param query the query
     * @return the client response
     */
    @GET
    @Path("/search/folder/{store_type}/{store_id}/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    ClientResponse<String> searchFolder(@QueryParam(AlfrescoConstants.AUTH_TICKET_PARAM_NAME) final String ticket,
        @PathParam("store_type") final String storeType, @PathParam("store_id") final String storeId, @PathParam("id") final String nodeId, @QueryParam("query") String query);

    /**
     * Creates the folder.
     *
     * @param ticket the ticket
     * @param storeType the store type
     * @param storeId the store id
     * @param nodeId the node id
     * @param folderCreationRequest the folder creation request
     * @return the client response
     */
    @POST
    @Path("node/folder/{storeType}/{storeId}/{nodeId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    ClientResponse<FolderCreationResponse> createFolder(@QueryParam(AlfrescoConstants.AUTH_TICKET_PARAM_NAME) String ticket,
        @PathParam("storeType") String storeType, @PathParam("storeId") String storeId, @PathParam("nodeId") String nodeId, FolderRequest folderCreationRequest);

    /**
     * Creates the folder by cmis atom entry.
     *
     * @param ticket the ticket
     * @param storeType the store type
     * @param storeId the store id
     * @param nodeId the node id
     * @param folderCreationXml the folder creation xml
     * @return the client response
     */
    @POST
    @Path("node/{storeType}/{storeId}/{nodeId}/children")
    @Consumes("application/atom+xml;type=entry")
    @Produces(MediaType.APPLICATION_JSON)
    ClientResponse<String> createFolderByCmisAtomEntry(@QueryParam(AlfrescoConstants.AUTH_TICKET_PARAM_NAME) String ticket,
        @PathParam("storeType") String storeType, @PathParam("storeId") String storeId, @PathParam("nodeId") String nodeId, String folderCreationXml);

}
