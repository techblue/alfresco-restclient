package uk.co.techblue.alfresco.service;

import org.jboss.resteasy.client.ClientResponse;

import uk.co.techblue.alfresco.dto.user.SearchUserResponse;
import uk.co.techblue.alfresco.dto.user.User;
import uk.co.techblue.alfresco.exception.UserException;
import uk.co.techblue.alfresco.resource.AbstractService;
import uk.co.techblue.alfresco.resource.UserResource;

public class UserService extends AbstractService<UserResource> {

	public UserService(String restBaseUri, String authTicket) {
		super(restBaseUri, authTicket);
	}

	@Override
	protected Class<UserResource> getResourceClass() {
		return UserResource.class;
	}

	public SearchUserResponse getUsers(String filter, int maxResults)
			throws UserException {
		ClientResponse<SearchUserResponse> userResponse = resourceProxy.getUsers(
				authTicket, filter, maxResults);
		return parseEntityFromResponse(userResponse, UserException.class);
	}
	
	public User getUser(String username)
			throws UserException {
		ClientResponse<User> userResponse = resourceProxy.getUser(
				authTicket, username);
		return parseEntityFromResponse(userResponse, UserException.class);
	}


}