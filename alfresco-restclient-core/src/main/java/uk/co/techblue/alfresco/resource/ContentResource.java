package uk.co.techblue.alfresco.resource;

import javax.ws.rs.Consumes;
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
import uk.co.techblue.alfresco.dto.content.ContentUploadForm;
import uk.co.techblue.alfresco.dto.content.DocumentContent;
import uk.co.techblue.alfresco.dto.content.SearchRequest;
import uk.co.techblue.alfresco.dto.content.UploadResponse;

@Path(AlfrescoConstants.RESOURCE_CONTEXT_BASE_PATH)
public interface ContentResource extends Resource {

    @GET
    @Path("node/content{nodeProperty}/{storeType}/{storeId}/{nodeId}")
    ClientResponse<DocumentContent> getNodeContent(@QueryParam(AlfrescoConstants.AUTH_TICKET_PARAM_NAME) String ticket,
            @PathParam("nodeProperty") String nodeProperty, @PathParam("storeType") String storeType,
            @PathParam("storeId") String storeId, @PathParam("nodeId") String nodeId, @QueryParam("a") boolean attach);

    @POST
    @Path("upload")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    ClientResponse<UploadResponse> uploadDocument(@QueryParam(AlfrescoConstants.AUTH_TICKET_PARAM_NAME) String ticket,
            @MultipartForm ContentUploadForm contentUploadMetadata);

    @GET
    @Path("metadata")
    ClientResponse<DocumentContent> getNodeMetadata(@QueryParam(AlfrescoConstants.AUTH_TICKET_PARAM_NAME) String ticket,
            @PathParam("nodeId") String nodeId);

    @POST
    @Path("search/advanced")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    ClientResponse<String> advancedSearch(@QueryParam(AlfrescoConstants.AUTH_TICKET_PARAM_NAME) String ticket,
            SearchRequest searchReuqest);

}
