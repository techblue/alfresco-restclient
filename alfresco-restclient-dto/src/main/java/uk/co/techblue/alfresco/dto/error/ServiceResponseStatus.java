package uk.co.techblue.alfresco.dto.error;

import org.codehaus.jackson.annotate.JsonProperty;

import uk.co.techblue.alfresco.dto.BaseDto;

public class ServiceResponseStatus extends BaseDto {

	private static final long serialVersionUID = 3517541718333984366L;

	@JsonProperty
	private int code;

	@JsonProperty
	private String name;

	@JsonProperty
	private String description;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
