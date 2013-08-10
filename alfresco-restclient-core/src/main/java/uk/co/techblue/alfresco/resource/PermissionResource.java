package uk.co.techblue.alfresco.resource;

import javax.ws.rs.Consumes;
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

@Path("/alfresco/service/slingshot/doclib/")
public interface PermissionResource extends Resource {

    @POST
    @Path("permissions/{storeType}/{storeId}/{nodeId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    ClientResponse<String> setPermissions(@QueryParam(AlfrescoConstants.AUTH_TICKET_PARAM_NAME) String ticket,
            @PathParam("storeType") String storeType, @PathParam("storeId") String storeId, @PathParam("nodeId") String nodeId,
            PermissionRequest permissionRequest);

}
