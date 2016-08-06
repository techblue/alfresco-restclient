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
import uk.co.techblue.alfresco.dto.content.FolderCreationResponse;
import uk.co.techblue.alfresco.dto.content.FolderRequest;
import uk.co.techblue.alfresco.exception.ContentException;
import uk.co.techblue.alfresco.resource.FolderResource;

public class FolderService extends AbstractService<FolderResource> {

    /**
     * Instantiates a new folder service.
     *
     * @param restBaseUri the rest base uri
     * @param authTicket the auth ticket
     */
    public FolderService(final String restBaseUri, final String authTicket) {
        super(restBaseUri, authTicket);
    }

    /*
     * @see uk.co.techblue.alfresco.client.Service#getResourceClass()
     */
    @Override
    protected Class<FolderResource> getResourceClass() {
        return FolderResource.class;
    }

    /**
     * this method only creates a folder,for which you need to add your custom web scripts to alfresco.
     *
     * @param nodeId the node id
     * @param folderName the folder name
     * @return the string
     * @throws ContentException the content exception
     */
    public String createFolder(final String nodeId, final String folderName) throws ContentException {
        final ClientResponse<String> contentResponse = resourceProxy.createFolder(authTicket,
            AlfrescoConstants.DEFAULT_STORE_TYPE, AlfrescoConstants.DEFAULT_STORE_ID, nodeId, folderName);
        return parseEntityFromResponse(contentResponse, ContentException.class);
    }

    /**
     * this method accepts a json input where you can specify whether you want to create a folder or a new file.
     *
     * @param nodeId the node id
     * @param folderCreationRequest the folder creation request
     * @return the string
     * @throws ContentException the content exception
     */
    public FolderCreationResponse createFolder(final String nodeId, final FolderRequest folderCreationRequest) throws ContentException {
        final ClientResponse<FolderCreationResponse> contentResponse = resourceProxy.createFolder(authTicket,
            AlfrescoConstants.DEFAULT_STORE_TYPE, AlfrescoConstants.DEFAULT_STORE_ID, nodeId, folderCreationRequest);
        return parseEntityFromResponse(contentResponse, ContentException.class);
    }

    /**
     * this method is now deprecated in the alfresco.. =>it accepts cmis atom entry as the default input for it
     *
     * @param nodeId the node id
     * @param fileFolderRequestXml the folder creation request
     * @return the string
     * @throws ContentException the content exception
     */
    public String createFileFolderByCmisAtomEntry(final String nodeId, final String fileFolderRequestXml) throws ContentException {
        final ClientResponse<String> contentResponse = resourceProxy.createFolderByCmisAtomEntry(authTicket,
            AlfrescoConstants.DEFAULT_STORE_TYPE, AlfrescoConstants.DEFAULT_STORE_ID, nodeId, fileFolderRequestXml);
        return parseEntityFromResponse(contentResponse, ContentException.class);
    }

    /**
     * Search folder.
     *
     * @param nodeId the node id
     * @param folderSearchCmisQuery the folder search cmis query
     * @return the string
     * @throws ContentException the content exception
     */
    public String searchFolder(final String nodeId, final String folderSearchCmisQuery) throws ContentException {
        String cmisQuery = "SELECT cmis:name, cmis:objectId FROM cmis:folder WHERE cmis:parentId='" + nodeId + "' AND ";
        cmisQuery += folderSearchCmisQuery;
        final ClientResponse<String> contentResponse = resourceProxy.searchFolder(authTicket,
            AlfrescoConstants.DEFAULT_STORE_TYPE, AlfrescoConstants.DEFAULT_STORE_ID, nodeId, cmisQuery);
        return parseEntityFromResponse(contentResponse, ContentException.class);
    }
}
