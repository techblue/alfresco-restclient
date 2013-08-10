package uk.co.techblue.alfresco.service;

import org.jboss.resteasy.client.ClientResponse;

import uk.co.techblue.alfresco.commons.AlfrescoConstants;
import uk.co.techblue.alfresco.dto.content.PermissionRequest;
import uk.co.techblue.alfresco.exception.PermissionException;
import uk.co.techblue.alfresco.resource.PermissionResource;

public class PermissionService extends AbstractService<PermissionResource> {

    public PermissionService(String restBaseUri, String authTicket) {
        super(restBaseUri, authTicket);
    }

    @Override
    protected Class<PermissionResource> getResourceClass() {
        return PermissionResource.class;
    }

    public String setPermissons(String nodeProperty, String storeType, String storeId, String nodeId,
            PermissionRequest permissionRequest) throws PermissionException {
        ClientResponse<String> contentResponse = resourceProxy.setPermissions(authTicket, storeType, storeId, nodeId,
                permissionRequest);
        return parseEntityFromResponse(contentResponse, PermissionException.class);
    }

    public String setPermissons(String nodeId, PermissionRequest permissionRequest) throws PermissionException {
        ClientResponse<String> contentResponse = resourceProxy.setPermissions(authTicket, AlfrescoConstants.DEFAULT_STORE_TYPE,
                AlfrescoConstants.DEFAULT_STORE_ID, nodeId, permissionRequest);
        return parseEntityFromResponse(contentResponse, PermissionException.class);
    }

}
