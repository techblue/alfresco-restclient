package uk.co.techblue.alfresco.dto.user;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

import uk.co.techblue.alfresco.dto.BaseDto;

public class SearchUserResponse extends BaseDto {

	private static final long serialVersionUID = -7759949462365660224L;

	@JsonProperty("people")
	private List<User> users;

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
}
