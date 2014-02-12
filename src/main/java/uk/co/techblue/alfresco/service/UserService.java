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
package uk.co.techblue.alfresco.service;

import org.apache.commons.lang3.StringUtils;
import org.jboss.resteasy.client.ClientResponse;

import uk.co.techblue.alfresco.dto.content.ContentNode;
import uk.co.techblue.alfresco.dto.user.AddUser;
import uk.co.techblue.alfresco.dto.user.ChangePassword;
import uk.co.techblue.alfresco.dto.user.SearchUserResponse;
import uk.co.techblue.alfresco.dto.user.User;
import uk.co.techblue.alfresco.exception.UserException;
import uk.co.techblue.alfresco.resource.UserResource;

/**
 * The Class UserService.
 */
public class UserService extends AbstractService<UserResource> {

    /**
     * Instantiates a new user service.
     * 
     * @param restBaseUri the rest base uri
     * @param authTicket the auth ticket
     */
    public UserService(final String restBaseUri, final String authTicket) {
        super(restBaseUri, authTicket);
    }

    /*
     * @see uk.co.techblue.alfresco.client.Service#getResourceClass()
     */
    @Override
    protected Class<UserResource> getResourceClass() {
        return UserResource.class;
    }

    /**
     * Gets the users.
     * 
     * @param filter the filter
     * @param maxResults the max results
     * @return the users
     * @throws UserException the user exception
     */
    public SearchUserResponse getUsers(final String filter, final int maxResults)
        throws UserException {
        final ClientResponse<SearchUserResponse> userResponse = resourceProxy
            .getUsers(authTicket, filter, maxResults);
        return parseEntityFromResponse(userResponse, UserException.class);
    }

    /**
     * Gets the user.
     * 
     * @param username the username
     * @return the user
     * @throws UserException the user exception
     */
    public User getUser(final String username) throws UserException {
        final ClientResponse<User> userResponse = resourceProxy.getUser(authTicket,
            username);
        return parseEntityFromResponse(userResponse, UserException.class);
    }

    /**
     * Creates the user.
     * 
     * @param userDetails the user details
     * @return the user
     * @throws UserException the user exception
     */
    public User createUser(final AddUser userDetails) throws UserException {
        final ClientResponse<User> userResponse = resourceProxy.createUser(
            authTicket, userDetails);
        return parseEntityFromResponse(userResponse, UserException.class);
    }

    /**
     * Delete user.
     * 
     * @param userName the user name
     * @throws UserException the user exception
     */
    public void deleteUser(final String userName) throws UserException {
        final ClientResponse<String> userResponse = resourceProxy.deleteUser(
            authTicket, userName);
        try {
            validateResponseSuccess(userResponse, UserException.class);
        } finally {
            userResponse.releaseConnection();
        }
    }

    /**
     * Change password.
     * 
     * @param userName the user name
     * @param oldPassword the old password
     * @param newPassword the new password
     * @throws UserException the user exception
     */
    public void changePassword(final String userName, final String oldPassword,
        final String newPassword) throws UserException {
        final ChangePassword changePassword = new ChangePassword();
        changePassword.setOldPassword(oldPassword);
        changePassword.setNewPassword(newPassword);
        final ClientResponse<String> userResponse = resourceProxy.changePassword(
            authTicket, userName, changePassword);
        try {
            validateResponseSuccess(userResponse, UserException.class);
        } finally {
            userResponse.releaseConnection();
        }
    }

    /**
     * Update user.
     * 
     * @param username the username
     * @param userDetails the user details
     * @return the string
     * @throws UserException the user exception
     */
    public String updateUser(final String username, final User userDetails)
        throws UserException {
        final ClientResponse<String> userResponse = resourceProxy.updateUser(
            authTicket, username, userDetails);
        return parseEntityFromResponse(userResponse, UserException.class);
    }

    /**
     * Gets the user home.
     * 
     * @param username the username
     * @return the user home
     * @throws UserException the user exception
     */
    public ContentNode getUserHome(final String username)
        throws UserException {
        final ClientResponse<ContentNode> userResponse = resourceProxy.getUserHome(
            authTicket, username);
        final ContentNode homeFolder = parseEntityFromResponse(userResponse, UserException.class);
        if (StringUtils.isNotBlank(homeFolder.getNodeId())) {
            return homeFolder;
        }
        return null;
    }

}