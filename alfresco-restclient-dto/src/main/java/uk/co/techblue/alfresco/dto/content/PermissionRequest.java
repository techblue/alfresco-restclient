package uk.co.techblue.alfresco.dto.content;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

import uk.co.techblue.alfresco.dto.BaseDto;

public class PermissionRequest extends BaseDto {

    private static final long serialVersionUID = 22969590617777955L;

    @JsonProperty("permissions")
    private List<Permission> permissions;

    @JsonProperty("isInherited")
    private boolean inherit;

    public List<Permission> getPermissions() {
        return permissions;
    }

    /**
     * Sets the permissions. The permission must be in following format:
     * 
     * <pre>
     *       "REMOVE;user3;All",
     *       "REMOVE;user2;All",
     * "ADD;user4;Coordinator",
     * "ADD;GROUP_usergroup1;Consumer"
     * </pre>
     * 
     * 
     * The above example uses the following triplet to define a permission: </br>
     * <b>[ADD|REMOVE];[USERNAME|GROUPNAME];PERMISSION</b> </br></br> Where the values are defined as: </br></br>
     * <ul>
     * <li><b>ADD|REMOVE</b>: Do you want to add or remove the permission for this user/group? Any other value passed will
     * result in a 400 error.</li>
     * <li><b>USERNAME|GROUPNAME</b>: The user or group you want the permission to be added or removed for. Group names must be
     * prefixed by GROUP_. Unknown users or groups will result in a 400 error.</li>
     * <li>
     * <b>PERMISSION</b>: The supported permissions options are defined in org.alfresco.service.cmr.security.PermissionService
     * or through custom extension to the permission model. Unknown permissions will result in a 400 error.</li>
     * <ul>
     * </br></br> See more at: http://jared.ottleys.net/uncategorized/alfresco-permissions-web-scripts#sthash.OWdDe3hR.dpuf
     * 
     * @param permissions the new permissions
     */
    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }

    public boolean isInherit() {
        return inherit;
    }

    public void setInherit(boolean inherit) {
        this.inherit = inherit;
    }

    /**
     * Adds the permission. See {@link #setPermissions(List) setPermissions} for permission format.
     * 
     * @param permission the permission
     */
    public void addPermission(Permission permission) {
        if (permissions == null) {
            permissions = new ArrayList<Permission>();
        }
        permissions.add(permission);
    }

}
