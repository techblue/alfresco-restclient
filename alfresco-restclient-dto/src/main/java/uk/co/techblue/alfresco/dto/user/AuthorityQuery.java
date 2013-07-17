package uk.co.techblue.alfresco.dto.user;

import javax.ws.rs.QueryParam;

import uk.co.techblue.alfresco.dto.BaseDto;
import uk.co.techblue.alfresco.dto.common.AuthorityType;
import uk.co.techblue.alfresco.dto.common.GroupSorter;

public class AuthorityQuery extends BaseDto {

	private static final long serialVersionUID = -3979600916433012399L;

	@QueryParam("authorityType")
	private AuthorityType authorityType;
	
	@QueryParam("maxItems")
	private Integer maxItems;
	
	@QueryParam("skipCount")
	private Integer skipCount;
	
	@QueryParam("sortBy")
	private GroupSorter sortBy;

	public AuthorityType getAuthorityType() {
		return authorityType;
	}

	public void setAuthorityType(AuthorityType authorityType) {
		this.authorityType = authorityType;
	}

	public Integer getMaxItems() {
		return maxItems;
	}

	public void setMaxItems(Integer maxItems) {
		this.maxItems = maxItems;
	}

	public Integer getSkipCount() {
		return skipCount;
	}

	public void setSkipCount(Integer skipCount) {
		this.skipCount = skipCount;
	}

	public GroupSorter getSortBy() {
		return sortBy;
	}

	public void setSortBy(GroupSorter sortBy) {
		this.sortBy = sortBy;
	}


}
