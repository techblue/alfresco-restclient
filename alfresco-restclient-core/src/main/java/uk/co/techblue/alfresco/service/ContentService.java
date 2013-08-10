package uk.co.techblue.alfresco.service;

import java.util.List;

import org.jboss.resteasy.client.ClientResponse;

import uk.co.techblue.alfresco.commons.AlfrescoConstants;
import uk.co.techblue.alfresco.dto.content.ContentMetadata;
import uk.co.techblue.alfresco.dto.content.ContentNode;
import uk.co.techblue.alfresco.dto.content.ContentUploadForm;
import uk.co.techblue.alfresco.dto.content.DocumentContent;
import uk.co.techblue.alfresco.dto.content.SearchRequest;
import uk.co.techblue.alfresco.dto.content.UploadResponse;
import uk.co.techblue.alfresco.exception.ContentException;
import uk.co.techblue.alfresco.exception.SearchException;
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
                storeId, nodeId, true);
        return parseEntityFromResponse(contentResponse, ContentException.class);
    }

    public DocumentContent getNodeContent(String storeType, String storeId, String nodeId) throws ContentException {
        ClientResponse<DocumentContent> contentResponse = resourceProxy.getNodeContent(authTicket, "", storeType, storeId,
                nodeId, true);
        return parseEntityFromResponse(contentResponse, ContentException.class);
    }

    public DocumentContent getNodeContent(String nodeId) throws ContentException {
        ClientResponse<DocumentContent> contentResponse = resourceProxy.getNodeContent(authTicket, "",
                AlfrescoConstants.DEFAULT_STORE_TYPE, AlfrescoConstants.DEFAULT_STORE_ID, nodeId, true);
        return parseEntityFromResponse(contentResponse, ContentException.class);
    }

    public UploadResponse uploadDocument(ContentUploadForm uploadMetadata) throws ContentException {
        ClientResponse<UploadResponse> contentResponse = resourceProxy.uploadDocument(authTicket, uploadMetadata);
        return parseEntityFromResponse(contentResponse, ContentException.class);
    }

    public List<ContentNode> search(SearchRequest searchReuqest) throws SearchException {
        ClientResponse<List<ContentNode>> searchResponse = resourceProxy.advancedSearch(authTicket, searchReuqest);
        return parseEntityFromResponse(searchResponse, SearchException.class);
    }

    public String storeNodeMetadata(String storeType, String storeId, String nodeId, ContentMetadata contentMetadata)
            throws ContentException {
        ClientResponse<String> contentResponse = resourceProxy.storeNodeMetadata(authTicket, storeType, storeId, nodeId,
                contentMetadata);
        return parseEntityFromResponse(contentResponse, ContentException.class);
    }

    public String storeNodeMetadata(String nodeId, ContentMetadata contentMetadata) throws ContentException {
        ClientResponse<String> contentResponse = resourceProxy.storeNodeMetadata(authTicket,
                AlfrescoConstants.DEFAULT_STORE_TYPE, AlfrescoConstants.DEFAULT_STORE_ID, nodeId, contentMetadata);
        return parseEntityFromResponse(contentResponse, ContentException.class);
    }

}
