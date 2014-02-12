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

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;
import org.jboss.resteasy.client.ClientResponse;

import uk.co.techblue.alfresco.client.Resource;
import uk.co.techblue.alfresco.commons.AlfrescoConstants;
import uk.co.techblue.alfresco.dto.content.ContentMetadata;
import uk.co.techblue.alfresco.dto.content.ContentNode;
import uk.co.techblue.alfresco.dto.content.ContentUploadForm;
import uk.co.techblue.alfresco.dto.content.DocumentContent;
import uk.co.techblue.alfresco.dto.content.NodeUpdateStatus;
import uk.co.techblue.alfresco.dto.content.SearchRequest;
import uk.co.techblue.alfresco.dto.content.UploadResponse;

/**
 * The Interface ContentResource.
 */
@Path(AlfrescoConstants.RESOURCE_CONTEXT_BASE_PATH)
public interface ContentResource extends Resource {

    /**
     * Gets the node content.
     * 
     * @param ticket the ticket
     * @param nodeProperty the node property
     * @param storeType the store type
     * @param storeId the store id
     * @param nodeId the node id
     * @param attach the attach
     * @return the node content
     */
    @GET
    @Path("node/content{nodeProperty}/{storeType}/{storeId}/{nodeId}")
    ClientResponse<DocumentContent> getNodeContent(@QueryParam(AlfrescoConstants.AUTH_TICKET_PARAM_NAME) String ticket,
        @PathParam("nodeProperty") String nodeProperty, @PathParam("storeType") String storeType,
        @PathParam("storeId") String storeId, @PathParam("nodeId") String nodeId, @QueryParam("a") boolean attach);

    /**
     * Upload document.
     * 
     * @param ticket the ticket
     * @param contentUploadMetadata the content upload metadata
     * @return the client response
     */
    @POST
    @Path("upload")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    ClientResponse<UploadResponse> uploadDocument(@QueryParam(AlfrescoConstants.AUTH_TICKET_PARAM_NAME) String ticket,
        @MultipartForm ContentUploadForm contentUploadMetadata);

    /**
     * Gets the node metadata.
     * 
     * @param ticket the ticket
     * @param nodeId the node id
     * @return the node metadata
     */
    @GET
    @Path("metadata")
    ClientResponse<DocumentContent> getNodeMetadata(@QueryParam(AlfrescoConstants.AUTH_TICKET_PARAM_NAME) String ticket,
        @PathParam("nodeId") String nodeId);

    /**
     * Store node metadata.
     * 
     * @param ticket the ticket
     * @param storeType the store type
     * @param storeId the store id
     * @param nodeId the node id
     * @param contentMetadata the content metadata
     * @return the client response
     */
    @POST
    @Path("metadata/node/{storeType}/{storeId}/{nodeId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    ClientResponse<NodeUpdateStatus> storeNodeMetadata(@QueryParam(AlfrescoConstants.AUTH_TICKET_PARAM_NAME) String ticket,
        @PathParam("storeType") String storeType, @PathParam("storeId") String storeId, @PathParam("nodeId") String nodeId,
        ContentMetadata contentMetadata);

    /**
     * Advanced search.
     * 
     * @param ticket the ticket
     * @param searchReuqest the search reuqest
     * @return the client response
     */
    @POST
    @Path("search/advanced")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    ClientResponse<List<ContentNode>> advancedSearch(@QueryParam(AlfrescoConstants.AUTH_TICKET_PARAM_NAME) String ticket,
        SearchRequest searchReuqest);

    /**
     * Delete document.
     *
     * @param ticket the ticket
     * @param storeType the store type
     * @param storeId the store id
     * @param nodeId the node id
     * @param includeChildNodes the include child nodes
     * @return the client response
     */
    @DELETE
    @Path("node/{storeType}/{storeId}/{nodeId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    ClientResponse<String> deleteDocument(@QueryParam(AlfrescoConstants.AUTH_TICKET_PARAM_NAME) String ticket,
        @PathParam("storeType") String storeType, @PathParam("storeId") String storeId, @PathParam("nodeId") String nodeId, @QueryParam("includeChildren") boolean includeChildNodes);

}
