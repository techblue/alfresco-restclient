package uk.co.techblue.alfresco.service;

import java.util.Map;

import org.jboss.resteasy.client.ClientResponse;

import uk.co.techblue.alfresco.dto.user.AuthorityQuery;
import uk.co.techblue.alfresco.dto.user.Group;
import uk.co.techblue.alfresco.dto.user.GroupQuery;
import uk.co.techblue.alfresco.dto.user.SearchGroupResponse;
import uk.co.techblue.alfresco.exception.GroupException;
import uk.co.techblue.alfresco.resource.AbstractService;
import uk.co.techblue.alfresco.resource.GroupResource;

public class GroupService extends AbstractService<GroupResource> {

	public GroupService(String restBaseUri, String authTicket) {
		super(restBaseUri, authTicket);
	}

	@Override
	protected Class<GroupResource> getResourceClass() {
		return GroupResource.class;
	}

	public SearchGroupResponse getGroups(GroupQuery groupQuery)
			throws GroupException {
		ClientResponse<SearchGroupResponse> groupResponse = resourceProxy
				.getGroups(authTicket, groupQuery);
		return parseEntityFromResponse(groupResponse, GroupException.class);
	}

	public Group getGroup(String groupShortName) throws GroupException {
		ClientResponse<Map<String, Group>> groupResponse = resourceProxy
				.getGroup(authTicket, groupShortName);
		return parseEntityFromResponse(groupResponse, GroupException.class)
				.get("data");
	}

	public SearchGroupResponse getRootGroups(GroupQuery groupQuery)
			throws GroupException {
		ClientResponse<SearchGroupResponse> groupResponse = resourceProxy
				.getRootGroups(authTicket, groupQuery);
		return parseEntityFromResponse(groupResponse, GroupException.class);
	}

	public SearchGroupResponse getChildAuthorities(String groupShortName,
			AuthorityQuery authorityQuery) throws GroupException {
		ClientResponse<SearchGroupResponse> groupResponse = resourceProxy
				.getChildAuthorities(authTicket, groupShortName, authorityQuery);
		return parseEntityFromResponse(groupResponse, GroupException.class);
	}

	public SearchGroupResponse getParentAuthorities(String groupShortName,
			AuthorityQuery authorityQuery) throws GroupException {
		ClientResponse<SearchGroupResponse> groupResponse = resourceProxy
				.getParentAuthorities(authTicket, groupShortName,
						authorityQuery);
		return parseEntityFromResponse(groupResponse, GroupException.class);
	}

	public void deleteGroup(String groupShortName) throws GroupException {
		ClientResponse<String> groupResponse = resourceProxy.deleteGroup(
				authTicket, groupShortName);
		try {
			validateResponseSuccess(groupResponse, GroupException.class);
		} finally {
			groupResponse.releaseConnection();
		}
	}
}
