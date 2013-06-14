package uk.co.techblue.alfresco.dto.user;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

import uk.co.techblue.alfresco.dto.BaseDto;

public class SearchGroupResponse extends BaseDto {

	private static final long serialVersionUID = 4206673779660189991L;

	@JsonProperty("data")
	private List<Group> groups;
	
	@JsonProperty("paging")
	private PagingInfo pagingInfo;

	public List<Group> getGroups() {
		return groups;
	}

	public void setGroups(List<Group> groups) {
		this.groups = groups;
	}

	public PagingInfo getPagingInfo() {
		return pagingInfo;
	}

	public void setPagingInfo(PagingInfo pagingInfo) {
		this.pagingInfo = pagingInfo;
	}
	
}
