package uk.co.techblue.alfresco.dto.content;

import org.codehaus.jackson.annotate.JsonProperty;

import uk.co.techblue.alfresco.dto.BaseDto;
import uk.co.techblue.alfresco.dto.common.UserRole;

public class Permission extends BaseDto {

    private static final long serialVersionUID = 1L;

    @JsonProperty("role")
    private UserRole role;

    @JsonProperty("authority")
    private String authority;

    @JsonProperty("remove")
    private boolean remove;

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    /**
     * Gets the authority (User or Group).Group names are prefixed by GROUP_
     * 
     * @return the authority
     */
    public String getAuthority() {
        return authority;
    }

    /**
     * Sets the authority (User or Group). Group names must be prefixed by GROUP_
     * 
     * @param authority the new authority
     */
    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public boolean isRemove() {
        return remove;
    }

    public void setRemove(boolean remove) {
        this.remove = remove;
    }

}
