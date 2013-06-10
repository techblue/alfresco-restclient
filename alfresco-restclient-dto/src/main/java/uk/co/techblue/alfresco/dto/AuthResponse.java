package uk.co.techblue.alfresco.dto;

import org.codehaus.jackson.annotate.JsonProperty;

public class AuthResponse extends BaseDto {

	private static final long serialVersionUID = -7068550765006421642L;

	@JsonProperty
	private String ticket;

	@JsonProperty
	public void setData(AuthData data) {
		// STUB METHOD JUST FOR POPULATING TOKEN INTO AUTH DATA
	}

	public String getTicket() {
		return ticket;
	}

	public class AuthData {

		public String getTicket() {
			return ticket;
		}

		public void setTicket(String newTicket) {
			ticket = newTicket;
		}

	}

}
