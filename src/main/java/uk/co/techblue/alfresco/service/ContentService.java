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

import java.util.List;

import org.jboss.resteasy.client.ClientResponse;

import uk.co.techblue.alfresco.commons.AlfrescoConstants;
import uk.co.techblue.alfresco.dto.content.ContentMetadata;
import uk.co.techblue.alfresco.dto.content.ContentNode;
import uk.co.techblue.alfresco.dto.content.ContentUploadForm;
import uk.co.techblue.alfresco.dto.content.DocumentContent;
import uk.co.techblue.alfresco.dto.content.NodeUpdateStatus;
import uk.co.techblue.alfresco.dto.content.SearchRequest;
import uk.co.techblue.alfresco.dto.content.UploadResponse;
import uk.co.techblue.alfresco.exception.ContentException;
import uk.co.techblue.alfresco.exception.SearchException;
import uk.co.techblue.alfresco.resource.ContentResource;

/**
 * The Class ContentService.
 */
public class ContentService extends AbstractService<ContentResource> {

    /**
     * Instantiates a new content service.
     * 
     * @param restBaseUri the rest base uri
     * @param authTicket the auth ticket
     */
    public ContentService(final String restBaseUri, final String authTicket) {
        super(restBaseUri, authTicket);
    }

    /*
     * @see uk.co.techblue.alfresco.client.Service#getResourceClass()
     */
    @Override
    protected Class<ContentResource> getResourceClass() {
        return ContentResource.class;
    }

    /**
     * Gets the node content.
     * 
     * @param nodeProperty the node property
     * @param storeType the store type
     * @param storeId the store id
     * @param nodeId the node id
     * @return the node content
     * @throws ContentException the content exception
     */
    public DocumentContent getNodeContent(final String nodeProperty, final String storeType, final String storeId, final String nodeId)
        throws ContentException {
        final ClientResponse<DocumentContent> contentResponse = resourceProxy.getNodeContent(authTicket, nodeProperty, storeType,
            storeId, nodeId, true);
        return parseEntityFromResponse(contentResponse, ContentException.class);
    }

    /**
     * Gets the node content.
     * 
     * @param storeType the store type
     * @param storeId the store id
     * @param nodeId the node id
     * @return the node content
     * @throws ContentException the content exception
     */
    public DocumentContent getNodeContent(final String storeType, final String storeId, final String nodeId) throws ContentException {
        final ClientResponse<DocumentContent> contentResponse = resourceProxy.getNodeContent(authTicket, "", storeType, storeId,
            nodeId, true);
        return parseEntityFromResponse(contentResponse, ContentException.class);
    }

    /**
     * Gets the node content.
     * 
     * @param nodeId the node id
     * @return the node content
     * @throws ContentException the content exception
     */
    public DocumentContent getNodeContent(final String nodeId) throws ContentException {
        final ClientResponse<DocumentContent> contentResponse = resourceProxy.getNodeContent(authTicket, "",
            AlfrescoConstants.DEFAULT_STORE_TYPE, AlfrescoConstants.DEFAULT_STORE_ID, nodeId, true);
        return parseEntityFromResponse(contentResponse, ContentException.class);
    }

    /**
     * Upload document.
     * 
     * @param uploadMetadata the upload metadata
     * @return the upload response
     * @throws ContentException the content exception
     */
    public UploadResponse uploadDocument(final ContentUploadForm uploadMetadata) throws ContentException {
        final ClientResponse<UploadResponse> contentResponse = resourceProxy.uploadDocument(authTicket, uploadMetadata);
        return parseEntityFromResponse(contentResponse, ContentException.class);
    }

    /**
     * Search.
     * 
     * @param searchReuqest the search reuqest
     * @return the list
     * @throws SearchException the search exception
     */
    public List<ContentNode> search(final SearchRequest searchReuqest) throws SearchException {
        final ClientResponse<List<ContentNode>> searchResponse = resourceProxy.advancedSearch(authTicket, searchReuqest);
        return parseEntityFromResponse(searchResponse, SearchException.class);
    }

    /**
     * Store node metadata.
     * 
     * @param storeType the store type
     * @param storeId the store id
     * @param nodeId the node id
     * @param contentMetadata the content metadata
     * @return the node update status
     * @throws ContentException the content exception
     */
    public NodeUpdateStatus storeNodeMetadata(final String storeType, final String storeId, final String nodeId, final ContentMetadata contentMetadata)
        throws ContentException {
        final ClientResponse<NodeUpdateStatus> contentResponse = resourceProxy.storeNodeMetadata(authTicket, storeType, storeId, nodeId,
            contentMetadata);
        return parseEntityFromResponse(contentResponse, ContentException.class);
    }

    /**
     * Store node metadata.
     * 
     * @param nodeId the node id
     * @param contentMetadata the content metadata
     * @return the node update status
     * @throws ContentException the content exception
     */
    public NodeUpdateStatus storeNodeMetadata(final String nodeId, final ContentMetadata contentMetadata) throws ContentException {
        final ClientResponse<NodeUpdateStatus> contentResponse = resourceProxy.storeNodeMetadata(authTicket,
            AlfrescoConstants.DEFAULT_STORE_TYPE, AlfrescoConstants.DEFAULT_STORE_ID, nodeId, contentMetadata);
        return parseEntityFromResponse(contentResponse, ContentException.class);
    }

    /**
     * Delete document.
     * 
     * @param nodeId the node id
     * @param includeChildren the include children
     * @return the string
     * @throws ContentException the content exception
     */
    public String deleteDocument(final String nodeId, final boolean includeChildren) throws ContentException {
        final ClientResponse<String> contentResponse = resourceProxy.deleteDocument(authTicket,
            AlfrescoConstants.DEFAULT_STORE_TYPE, AlfrescoConstants.DEFAULT_STORE_ID, nodeId, includeChildren);
        return parseEntityFromResponse(contentResponse, ContentException.class);
    }

}
