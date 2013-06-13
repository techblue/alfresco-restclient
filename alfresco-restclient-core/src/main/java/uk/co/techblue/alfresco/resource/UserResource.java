package uk.co.techblue.alfresco.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.client.ClientResponse;

import uk.co.techblue.alfresco.client.AlfrescoConstants;
import uk.co.techblue.alfresco.client.Resource;
import uk.co.techblue.alfresco.dto.user.SearchUserResponse;
import uk.co.techblue.alfresco.dto.user.User;

@Path(AlfrescoConstants.RESOURCE_CONTEXT_BASE_PATH)
public interface UserResource extends Resource {

	@GET
	@Path("people")
	@Produces(MediaType.APPLICATION_JSON)
	ClientResponse<SearchUserResponse> getUsers(
			@QueryParam(AlfrescoConstants.AUTH_TICKET_PARAM_NAME) String ticket,
			@QueryParam("filter") String filter,
			@QueryParam("maxResults") int maxResults);

	@GET
	@Path("people/{username}")
	@Produces(MediaType.APPLICATION_JSON)
	ClientResponse<User> getUser(
			@QueryParam(AlfrescoConstants.AUTH_TICKET_PARAM_NAME) String ticket,
			@PathParam("username") String username);

}
