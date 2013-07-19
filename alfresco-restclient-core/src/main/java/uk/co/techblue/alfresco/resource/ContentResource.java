package uk.co.techblue.alfresco.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

import org.jboss.resteasy.client.ClientResponse;

import uk.co.techblue.alfresco.client.AlfrescoConstants;
import uk.co.techblue.alfresco.client.Resource;
import uk.co.techblue.alfresco.dto.DocumentContent;

@Path(AlfrescoConstants.RESOURCE_CONTEXT_BASE_PATH)
public interface ContentResource extends Resource {
	
	@GET
	@Path("node/content{nodeProperty}/{storeType}/{storeId}/{nodeId}")
	ClientResponse<DocumentContent> getNodeContent(
			@QueryParam(AlfrescoConstants.AUTH_TICKET_PARAM_NAME) String ticket,
			@PathParam("nodeProperty") String nodeProperty,
			@PathParam("storeType") String storeType,
			@PathParam("storeId") String storeId,
			@PathParam("nodeId") String nodeId);

}
