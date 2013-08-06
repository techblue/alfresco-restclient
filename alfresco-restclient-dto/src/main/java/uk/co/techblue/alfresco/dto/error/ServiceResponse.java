package uk.co.techblue.alfresco.dto.error;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

import uk.co.techblue.alfresco.dto.BaseDto;

public class ServiceResponse extends BaseDto {

	private static final long serialVersionUID = -5904389506284205882L;

	@JsonProperty
	private ServiceResponseStatus status;

	@JsonProperty("message")
	private String message;

	@JsonProperty
	private String exception;

	@JsonProperty
	private List<String> callstack;

	@JsonProperty
	private String server;

	@JsonProperty
	private String time;

	public ServiceResponseStatus getStatus() {
		return status;
	}

	public void setStatus(ServiceResponseStatus status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getException() {
		return exception;
	}

	public void setException(String exception) {
		this.exception = exception;
	}

	public List<String> getCallstack() {
		return callstack;
	}

	public void setCallstack(List<String> callstack) {
		this.callstack = callstack;
	}

	public String getServer() {
		return server;
	}

	public void setServer(String server) {
		this.server = server;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

}