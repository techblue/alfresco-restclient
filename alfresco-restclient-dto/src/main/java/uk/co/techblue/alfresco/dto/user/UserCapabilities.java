package uk.co.techblue.alfresco.dto.user;

import org.codehaus.jackson.annotate.JsonProperty;

import uk.co.techblue.alfresco.dto.BaseDto;

public class UserCapabilities extends BaseDto {

	private static final long serialVersionUID = 1663942471397952257L;

	@JsonProperty
	private boolean isMutable;

	@JsonProperty
	private boolean isGuest;

	@JsonProperty
	private boolean isAdmin;

	public boolean isMutable() {
		return isMutable;
	}

	public void setMutable(boolean isMutable) {
		this.isMutable = isMutable;
	}

	public boolean isGuest() {
		return isGuest;
	}

	public void setGuest(boolean isGuest) {
		this.isGuest = isGuest;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

}
