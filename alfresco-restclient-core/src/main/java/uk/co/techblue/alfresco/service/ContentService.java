package uk.co.techblue.alfresco.service;

import org.jboss.resteasy.client.ClientResponse;

import uk.co.techblue.alfresco.client.AlfrescoConstants;
import uk.co.techblue.alfresco.dto.content.ContentUploadMetadata;
import uk.co.techblue.alfresco.dto.content.DocumentContent;
import uk.co.techblue.alfresco.exception.ContentException;
import uk.co.techblue.alfresco.resource.AbstractService;
import uk.co.techblue.alfresco.resource.ContentResource;

public class ContentService extends AbstractService<ContentResource> {

    public ContentService(String restBaseUri, String authTicket) {
        super(restBaseUri, authTicket);
    }

    @Override
    protected Class<ContentResource> getResourceClass() {
        return ContentResource.class;
    }

    public DocumentContent getNodeContent(String nodeProperty, String storeType, String storeId, String nodeId)
            throws ContentException {
        ClientResponse<DocumentContent> contentResponse = resourceProxy.getNodeContent(authTicket, nodeProperty, storeType,
                storeId, nodeId);
        return parseEntityFromResponse(contentResponse, ContentException.class);
    }

    public DocumentContent getNodeContent(String storeType, String storeId, String nodeId) throws ContentException {
        ClientResponse<DocumentContent> contentResponse = resourceProxy.getNodeContent(authTicket, "", storeType, storeId,
                nodeId);
        return parseEntityFromResponse(contentResponse, ContentException.class);
    }

    public DocumentContent getNodeContent(String nodeId) throws ContentException {
        ClientResponse<DocumentContent> contentResponse = resourceProxy.getNodeContent(authTicket, "",
                AlfrescoConstants.DEFAULT_STORE_TYPE, AlfrescoConstants.DEFAULT_STORE_ID, nodeId);
        return parseEntityFromResponse(contentResponse, ContentException.class);
    }

    public String uploadDocument(ContentUploadMetadata uploadMetadata) throws ContentException {
        ClientResponse<String> contentResponse = resourceProxy.uploadDocument(authTicket, uploadMetadata);
        return parseEntityFromResponse(contentResponse, ContentException.class);
    }

}
