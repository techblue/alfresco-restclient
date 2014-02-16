package uk.co.techblue.alfresco.dto.content;

import org.codehaus.jackson.annotate.JsonProperty;

import uk.co.techblue.alfresco.dto.BaseDto;

public class PermissionServiceResponse extends BaseDto {

    private static final long serialVersionUID = -654561625581877974L;

    @JsonProperty("permissionStatus")
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

}
