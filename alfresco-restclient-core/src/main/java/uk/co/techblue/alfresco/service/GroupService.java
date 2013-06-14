package uk.co.techblue.alfresco.service;

import java.util.Map;

import org.jboss.resteasy.client.ClientResponse;

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

	public SearchGroupResponse getGroups(GroupQuery groupQuery) throws GroupException {
		ClientResponse<SearchGroupResponse> userResponse = resourceProxy.getGroups(
				authTicket, groupQuery);
		return parseEntityFromResponse(userResponse, GroupException.class);
	}

	public Group getGroup(String shortName) throws GroupException {
		ClientResponse<Map<String,Group>> userResponse = resourceProxy.getGroup(
				authTicket, shortName);
		return parseEntityFromResponse(userResponse, GroupException.class).get("data");
	}

}
