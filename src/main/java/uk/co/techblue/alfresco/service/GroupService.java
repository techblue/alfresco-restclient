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

import java.util.Map;

import org.jboss.resteasy.client.ClientResponse;

import uk.co.techblue.alfresco.dto.user.AuthorityQuery;
import uk.co.techblue.alfresco.dto.user.Group;
import uk.co.techblue.alfresco.dto.user.GroupQuery;
import uk.co.techblue.alfresco.dto.user.SearchGroupResponse;
import uk.co.techblue.alfresco.exception.GroupException;
import uk.co.techblue.alfresco.resource.GroupResource;

/**
 * The Class GroupService.
 */
public class GroupService extends AbstractService<GroupResource> {

    /**
     * Instantiates a new group service.
     * 
     * @param restBaseUri the rest base uri
     * @param authTicket the auth ticket
     */
    public GroupService(final String restBaseUri, final String authTicket) {
        super(restBaseUri, authTicket);
    }

    /*
     * @see uk.co.techblue.alfresco.client.Service#getResourceClass()
     */
    @Override
    protected Class<GroupResource> getResourceClass() {
        return GroupResource.class;
    }

    /**
     * Gets the groups.
     * 
     * @param groupQuery the group query
     * @return the groups
     * @throws GroupException the group exception
     */
    public SearchGroupResponse getGroups(final GroupQuery groupQuery)
        throws GroupException {
        final ClientResponse<SearchGroupResponse> groupResponse = resourceProxy
            .getGroups(authTicket, groupQuery);
        return parseEntityFromResponse(groupResponse, GroupException.class);
    }

    /**
     * Gets the group.
     * 
     * @param groupShortName the group short name
     * @return the group
     * @throws GroupException the group exception
     */
    public Group getGroup(final String groupShortName) throws GroupException {
        final ClientResponse<Map<String, Group>> groupResponse = resourceProxy
            .getGroup(authTicket, groupShortName);
        return parseEntityFromResponse(groupResponse, GroupException.class)
            .get("data");
    }

    /**
     * Gets the root groups.
     * 
     * @param groupQuery the group query
     * @return the root groups
     * @throws GroupException the group exception
     */
    public SearchGroupResponse getRootGroups(final GroupQuery groupQuery)
        throws GroupException {
        final ClientResponse<SearchGroupResponse> groupResponse = resourceProxy
            .getRootGroups(authTicket, groupQuery);
        return parseEntityFromResponse(groupResponse, GroupException.class);
    }

    /**
     * Gets the child authorities.
     * 
     * @param groupShortName the group short name
     * @param authorityQuery the authority query
     * @return the child authorities
     * @throws GroupException the group exception
     */
    public SearchGroupResponse getChildAuthorities(final String groupShortName,
        final AuthorityQuery authorityQuery) throws GroupException {
        final ClientResponse<SearchGroupResponse> groupResponse = resourceProxy
            .getChildAuthorities(authTicket, groupShortName, authorityQuery);
        return parseEntityFromResponse(groupResponse, GroupException.class);
    }

    /**
     * Gets the parent authorities.
     * 
     * @param groupShortName the group short name
     * @param authorityQuery the authority query
     * @return the parent authorities
     * @throws GroupException the group exception
     */
    public SearchGroupResponse getParentAuthorities(final String groupShortName,
        final AuthorityQuery authorityQuery) throws GroupException {
        final ClientResponse<SearchGroupResponse> groupResponse = resourceProxy
            .getParentAuthorities(authTicket, groupShortName,
                authorityQuery);
        return parseEntityFromResponse(groupResponse, GroupException.class);
    }

    /**
     * Delete group.
     * 
     * @param groupShortName the group short name
     * @throws GroupException the group exception
     */
    public void deleteGroup(final String groupShortName) throws GroupException {
        final ClientResponse<String> groupResponse = resourceProxy.deleteGroup(
            authTicket, groupShortName);
        try {
            validateResponseSuccess(groupResponse, GroupException.class);
        } finally {
            groupResponse.releaseConnection();
        }
    }
}
