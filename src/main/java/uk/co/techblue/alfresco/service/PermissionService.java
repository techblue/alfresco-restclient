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
package uk.co.techblue.alfresco.service;

import org.jboss.resteasy.client.ClientResponse;

import uk.co.techblue.alfresco.commons.AlfrescoConstants;
import uk.co.techblue.alfresco.dto.content.PermissionRequest;
import uk.co.techblue.alfresco.exception.PermissionException;
import uk.co.techblue.alfresco.resource.PermissionResource;

// TODO: Auto-generated Javadoc
/**
 * The Class PermissionService.
 */
public class PermissionService extends AbstractService<PermissionResource> {

    /**
     * Instantiates a new permission service.
     * 
     * @param restBaseUri the rest base uri
     * @param authTicket the auth ticket
     */
    public PermissionService(final String restBaseUri, final String authTicket) {
        super(restBaseUri, authTicket);
    }

    /*
     * @see uk.co.techblue.alfresco.client.Service#getResourceClass()
     */
    @Override
    protected Class<PermissionResource> getResourceClass() {
        return PermissionResource.class;
    }

    /**
     * Sets the permissons.
     * 
     * @param nodeProperty the node property
     * @param storeType the store type
     * @param storeId the store id
     * @param nodeId the node id
     * @param permissionRequest the permission request
     * @return the string
     * @throws PermissionException the permission exception
     */
    public String setPermissons(final String nodeProperty, final String storeType, final String storeId, final String nodeId,
        final PermissionRequest permissionRequest) throws PermissionException {
        final ClientResponse<String> contentResponse = resourceProxy.setPermissions(authTicket, storeType, storeId, nodeId,
            permissionRequest);
        return parseEntityFromResponse(contentResponse, PermissionException.class);
    }

    /**
     * Sets the permissons.
     * 
     * @param nodeId the node id
     * @param permissionRequest the permission request
     * @return the string
     * @throws PermissionException the permission exception
     */
    public String setPermissons(final String nodeId, final PermissionRequest permissionRequest) throws PermissionException {
        final ClientResponse<String> contentResponse = resourceProxy.setPermissions(authTicket, AlfrescoConstants.DEFAULT_STORE_TYPE,
            AlfrescoConstants.DEFAULT_STORE_ID, nodeId, permissionRequest);
        return parseEntityFromResponse(contentResponse, PermissionException.class);
    }

}
