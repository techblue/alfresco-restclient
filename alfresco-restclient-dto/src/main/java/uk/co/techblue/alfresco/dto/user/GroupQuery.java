package uk.co.techblue.alfresco.dto.user;

import javax.ws.rs.QueryParam;

import uk.co.techblue.alfresco.dto.BaseDto;

public class GroupQuery extends BaseDto {

	public enum GroupSorter {
		authorityName,
		shortName,
		displayName
	}
	
	private static final long serialVersionUID = 4809842369740131482L;
	
	@QueryParam("shortNameFilter")
	private String shortNameFilter;
	
	@QueryParam("zone")
	private String zone;
	
	@QueryParam("maxItems")
	private Integer maxItems;
	
	@QueryParam("skipCount")
	private Integer skipCount;
	
	@QueryParam("sortBy")
	private GroupSorter sortBy;

	public String getShortNameFilter() {
		return shortNameFilter;
	}

	public void setShortNameFilter(String shortNameFilter) {
		this.shortNameFilter = shortNameFilter;
	}

	public String getZone() {
		return zone;
	}

	public void setZone(String zone) {
		this.zone = zone;
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
