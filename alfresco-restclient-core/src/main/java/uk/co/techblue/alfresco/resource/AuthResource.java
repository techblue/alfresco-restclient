package uk.co.techblue.alfresco.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.client.ClientResponse;

import uk.co.techblue.alfresco.client.Resource;
import uk.co.techblue.alfresco.commons.AlfrescoConstants;
import uk.co.techblue.alfresco.dto.AuthResponse;
import uk.co.techblue.alfresco.dto.Credentials;
import uk.co.techblue.alfresco.dto.error.ServiceResponse;

@Path(AlfrescoConstants.RESOURCE_CONTEXT_BASE_PATH)
public interface AuthResource extends Resource {

	@POST
	@Path("login")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	ClientResponse<AuthResponse> login(Credentials credentials);

	@DELETE
	@Path("login/ticket/{ticket}")
	@Produces(MediaType.APPLICATION_JSON)
	ClientResponse<ServiceResponse> logout(
			@PathParam("ticket") String ticket,
			@QueryParam(AlfrescoConstants.AUTH_TICKET_PARAM_NAME) String authTicket,
			@QueryParam("format") String responseFormat);

}
