package uk.co.techblue.alfresco.resource;

import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.annotations.Form;
import org.jboss.resteasy.client.ClientResponse;

import uk.co.techblue.alfresco.client.AlfrescoConstants;
import uk.co.techblue.alfresco.client.Resource;
import uk.co.techblue.alfresco.dto.user.Group;
import uk.co.techblue.alfresco.dto.user.GroupQuery;
import uk.co.techblue.alfresco.dto.user.SearchGroupResponse;

@Path(AlfrescoConstants.RESOURCE_CONTEXT_BASE_PATH)
public interface GroupResource extends Resource {

	@GET
	@Path("groups")
	@Produces(MediaType.APPLICATION_JSON)
	ClientResponse<SearchGroupResponse> getGroups(
			@QueryParam(AlfrescoConstants.AUTH_TICKET_PARAM_NAME) String ticket,
			@Form GroupQuery groupQuery);

	@GET
	@Path("groups/{shortName}")
	@Produces(MediaType.APPLICATION_JSON)
	ClientResponse<Map<String,Group>> getGroup(
			@QueryParam(AlfrescoConstants.AUTH_TICKET_PARAM_NAME) String ticket,
			@PathParam("shortName") String shortName);

}
