package uk.co.techblue.alfresco.dto.user;

import org.codehaus.jackson.annotate.JsonProperty;

import uk.co.techblue.alfresco.dto.BaseDto;
import uk.co.techblue.alfresco.dto.common.AuthorityType;

public class Group extends BaseDto {

	private static final long serialVersionUID = -1471777693101162262L;
	
	@JsonProperty("authorityType")
	private AuthorityType authorityType;

	@JsonProperty("shortName")
	private String shortName;
	
	@JsonProperty("fullName")
	private String fullName;
	
	@JsonProperty("displayName")
	private String displayName;
	
	@JsonProperty("url")
	private String url;

	public AuthorityType getAuthorityType() {
		return authorityType;
	}

	public void setAuthorityType(AuthorityType authorityType) {
		this.authorityType = authorityType;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
}
