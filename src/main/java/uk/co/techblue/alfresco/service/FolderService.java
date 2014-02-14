package uk.co.techblue.alfresco.service;

import org.jboss.resteasy.client.ClientResponse;

import uk.co.techblue.alfresco.commons.AlfrescoConstants;
import uk.co.techblue.alfresco.dto.content.FileFolderRequest;
import uk.co.techblue.alfresco.exception.ContentException;
import uk.co.techblue.alfresco.resource.FolderResource;

public class FolderService extends AbstractService<FolderResource> {

    public FolderService(final String restBaseUri, final String authTicket) {
        super(restBaseUri, authTicket);
    }

    @Override
    protected Class<FolderResource> getResourceClass() {
        return FolderResource.class;
    }

    /**
     * this method only creates a folder,for which you need to add your custom web scripts to alfresco
     * */
    public String createFolder(final String nodeId, final String folderName) throws ContentException {
        final ClientResponse<String> contentResponse = resourceProxy.createFolder(authTicket,
            AlfrescoConstants.DEFAULT_STORE_TYPE, AlfrescoConstants.DEFAULT_STORE_ID, nodeId, folderName);
        return parseEntityFromResponse(contentResponse, ContentException.class);
    }

    /**
     * this method accepts a json input where you can specify whether you want to create a folder or a new file
     * */
    public String createFolder(final String nodeId, final FileFolderRequest folderCreationRequest) throws ContentException {
        final ClientResponse<String> contentResponse = resourceProxy.createFileOrFolder(authTicket,
            AlfrescoConstants.DEFAULT_STORE_TYPE, AlfrescoConstants.DEFAULT_STORE_ID, nodeId, folderCreationRequest);
        return parseEntityFromResponse(contentResponse, ContentException.class);
    }

    /**
     * this method is now deprecated in the alfresco.. =>it accepts cmis atom entry as the default input for it
     * 
     * */
    public String createFolderByCmisAtomEntry(final String nodeId, final String folderCreationRequest) throws ContentException {
        final ClientResponse<String> contentResponse = resourceProxy.createFolder(authTicket,
            AlfrescoConstants.DEFAULT_STORE_TYPE, AlfrescoConstants.DEFAULT_STORE_ID, nodeId, folderCreationRequest);
        return parseEntityFromResponse(contentResponse, ContentException.class);
    }

}
