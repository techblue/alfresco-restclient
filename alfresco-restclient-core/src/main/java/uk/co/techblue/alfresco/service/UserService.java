package uk.co.techblue.alfresco.service;

import org.jboss.resteasy.client.ClientResponse;

import uk.co.techblue.alfresco.dto.user.AddUser;
import uk.co.techblue.alfresco.dto.user.ChangePassword;
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
		ClientResponse<SearchUserResponse> userResponse = resourceProxy
				.getUsers(authTicket, filter, maxResults);
		return parseEntityFromResponse(userResponse, UserException.class);
	}

	public User getUser(String username) throws UserException {
		ClientResponse<User> userResponse = resourceProxy.getUser(authTicket,
				username);
		return parseEntityFromResponse(userResponse, UserException.class);
	}

	public User createUser(AddUser userDetails) throws UserException {
		ClientResponse<User> userResponse = resourceProxy.createUser(
				authTicket, userDetails);
		return parseEntityFromResponse(userResponse, UserException.class);
	}

	public void deleteUser(String userName) throws UserException {
		ClientResponse<String> userResponse = resourceProxy.deleteUser(
				authTicket, userName);
		try {
			validateResponseSuccess(userResponse, UserException.class);
		} finally {
			userResponse.releaseConnection();
		}
	}

	public void changePassword(String userName, String oldPassword,
			String newPassword) throws UserException {
		ChangePassword changePassword = new ChangePassword();
		changePassword.setOldPassword(oldPassword);
		changePassword.setNewPassword(newPassword);
		ClientResponse<String> userResponse = resourceProxy.changePassword(
				authTicket, userName, changePassword);
		try {
			validateResponseSuccess(userResponse, UserException.class);
		} finally {
			userResponse.releaseConnection();
		}
	}

	public String updateUser(String username, User userDetails)
			throws UserException {
		ClientResponse<String> userResponse = resourceProxy.updateUser(
				authTicket, username, userDetails);
		return parseEntityFromResponse(userResponse, UserException.class);
	}

}