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
import uk.co.techblue.alfresco.dto.content.FileFolderRequest;

@Path(AlfrescoConstants.RESOURCE_CONTEXT_BASE_PATH)
public interface FolderResource extends Resource {

    @GET
    @Path("/create/folder/{store_type}/{store_id}/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    ClientResponse<String> createFolder(@QueryParam(AlfrescoConstants.AUTH_TICKET_PARAM_NAME) final String ticket,
        @PathParam("store_type") final String storeType, @PathParam("store_id") final String storeId, @PathParam("id") String nodeId, @QueryParam("folderName") String folderName);

    @GET
    @Path("/search/folder/{store_type}/{store_id}/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    ClientResponse<String> searchFolder(@QueryParam(AlfrescoConstants.AUTH_TICKET_PARAM_NAME) final String ticket,
        @PathParam("store_type") final String storeType, @PathParam("store_id") final String storeId, @PathParam("id") String nodeId, @QueryParam("query") String query);

    @POST
    @Path("node/folder/{storeType}/{storeId}/{nodeId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    ClientResponse<String> createFileOrFolder(@QueryParam(AlfrescoConstants.AUTH_TICKET_PARAM_NAME) String ticket,
        @PathParam("storeType") String storeType, @PathParam("storeId") String storeId, @PathParam("nodeId") String nodeId, FileFolderRequest folderCreationRequest);

    @POST
    @Path("node/{storeType}/{storeId}/{nodeId}/children")
    @Consumes("application/atom+xml;type=entry")
    @Produces(MediaType.APPLICATION_JSON)
    ClientResponse<String> createFolderByCmisAtomEntry(@QueryParam(AlfrescoConstants.AUTH_TICKET_PARAM_NAME) String ticket,
        @PathParam("storeType") String storeType, @PathParam("storeId") String storeId, @PathParam("nodeId") String nodeId, String folderCreationXml);

}
