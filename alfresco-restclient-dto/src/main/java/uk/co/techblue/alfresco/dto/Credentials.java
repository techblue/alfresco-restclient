package uk.co.techblue.alfresco.dto;

import org.codehaus.jackson.annotate.JsonProperty;

public class Credentials extends BaseDto {

	private static final long serialVersionUID = -6492209613647675748L;

	@JsonProperty(value = "username")
    private final String username;

	@JsonProperty(value = "password")
    private final String password;


    public Credentials(String username, String password) {
        this.username = username;
        this.password = password;
    }

	public String getUsername() {
		return username;
	}


	public String getPassword() {
		return password;
	}
    
}
