/*******************************************************************************
 * Copyright 2012 Technology Blueprint Ltd
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package uk.co.techblue.alfresco.dto.content;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

import uk.co.techblue.alfresco.dto.BaseDto;

/**
 * The Class PermissionRequest.
 */
public class PermissionRequest extends BaseDto {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 22969590617777955L;

    /** The permissions. */
    @JsonProperty("permissions")
    private List<Permission> permissions;

    /** The inherit. */
    @JsonProperty("isInherited")
    private boolean inherit;

    /**
     * Gets the permissions.
     * 
     * @return the permissions
     */
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
    public void setPermissions(final List<Permission> permissions) {
        this.permissions = permissions;
    }

    /**
     * Checks if is inherit.
     * 
     * @return true, if is inherit
     */
    public boolean isInherit() {
        return inherit;
    }

    /**
     * Sets the inherit.
     * 
     * @param inherit the new inherit
     */
    public void setInherit(final boolean inherit) {
        this.inherit = inherit;
    }

    /**
     * Adds the permission. See {@link #setPermissions(List) setPermissions} for permission format.
     * 
     * @param permission the permission
     */
    public void addPermission(final Permission permission) {
        if (permissions == null) {
            permissions = new ArrayList<Permission>();
        }
        permissions.add(permission);
    }

}
