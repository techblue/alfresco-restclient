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

import java.io.Serializable;

import javax.activation.FileDataSource;
import javax.ws.rs.FormParam;
import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.annotations.providers.multipart.PartType;

// TODO: Auto-generated Javadoc
/**
 * The Class ContentUploadForm.
 */
public class ContentUploadForm implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -776494597401819448L;

    /** The file name. */
    @FormParam("filename")
    @PartType(MediaType.TEXT_PLAIN)
    private String fileName;

    /** The description. */
    @FormParam("description")
    @PartType(MediaType.TEXT_PLAIN)
    private String description;

    /** The destination. */
    @FormParam("destination")
    @PartType(MediaType.TEXT_PLAIN)
    private String destination;

    /** The site id. */
    @FormParam("siteid")
    @PartType(MediaType.TEXT_PLAIN)
    private String siteId;

    /** The container id. */
    @FormParam("containerid")
    @PartType(MediaType.TEXT_PLAIN)
    private String containerId;

    /** The upload directory. */
    @FormParam("uploaddirectory")
    @PartType(MediaType.TEXT_PLAIN)
    private String uploadDirectory;

    /** The update node ref. */
    @FormParam("updatenoderef")
    @PartType(MediaType.TEXT_PLAIN)
    private String updateNodeRef;

    /** The content type. */
    @FormParam("contenttype")
    @PartType(MediaType.TEXT_PLAIN)
    private String contentType;

    /** The major version. */
    @FormParam("majorversion")
    @PartType(MediaType.TEXT_PLAIN)
    private String majorVersion;

    /** The overwrite. */
    @FormParam("overwrite")
    @PartType(MediaType.TEXT_PLAIN)
    private boolean overwrite;

    /** The thumbnails. */
    @FormParam("thumbnails")
    @PartType(MediaType.TEXT_PLAIN)
    private boolean thumbnails;

    /** The file data. */
    @FormParam("filedata")
    @PartType(MediaType.APPLICATION_OCTET_STREAM)
    private FileDataSource fileData;

    /**
     * Gets the file name.
     *
     * @return the file name
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * Sets the file name.
     *
     * @param fileName the new file name
     */
    public void setFileName(final String fileName) {
        this.fileName = fileName;
    }

    /**
     * Gets the description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description.
     *
     * @param description the new description
     */
    public void setDescription(final String description) {
        this.description = description;
    }

    /**
     * Gets the destination.
     *
     * @return the destination
     */
    public String getDestination() {
        return destination;
    }

    /**
     * Sets the destination.
     *
     * @param destination the new destination
     */
    public void setDestination(final String destination) {
        this.destination = destination;
    }

    /**
     * Gets the site id.
     *
     * @return the site id
     */
    public String getSiteId() {
        return siteId;
    }

    /**
     * Sets the site id.
     *
     * @param siteId the new site id
     */
    public void setSiteId(final String siteId) {
        this.siteId = siteId;
    }

    /**
     * Gets the container id.
     *
     * @return the container id
     */
    public String getContainerId() {
        return containerId;
    }

    /**
     * Sets the container id.
     *
     * @param containerId the new container id
     */
    public void setContainerId(final String containerId) {
        this.containerId = containerId;
    }

    /**
     * Gets the upload directory.
     *
     * @return the upload directory
     */
    public String getUploadDirectory() {
        return uploadDirectory;
    }

    /**
     * Sets the upload directory.
     *
     * @param uploadDirectory the new upload directory
     */
    public void setUploadDirectory(final String uploadDirectory) {
        this.uploadDirectory = uploadDirectory;
    }

    /**
     * Gets the update node ref.
     *
     * @return the update node ref
     */
    public String getUpdateNodeRef() {
        return updateNodeRef;
    }

    /**
     * Sets the update node ref.
     *
     * @param updateNodeRef the new update node ref
     */
    public void setUpdateNodeRef(final String updateNodeRef) {
        this.updateNodeRef = updateNodeRef;
    }

    /**
     * Gets the content type.
     *
     * @return the content type
     */
    public String getContentType() {
        return contentType;
    }

    /**
     * Sets the content type.
     *
     * @param contentType the new content type
     */
    public void setContentType(final String contentType) {
        this.contentType = contentType;
    }

    /**
     * Gets the major version.
     *
     * @return the major version
     */
    public String getMajorVersion() {
        return majorVersion;
    }

    /**
     * Sets the major version.
     *
     * @param majorVersion the new major version
     */
    public void setMajorVersion(final String majorVersion) {
        this.majorVersion = majorVersion;
    }

    /**
     * Checks if is overwrite.
     *
     * @return true, if is overwrite
     */
    public boolean isOverwrite() {
        return overwrite;
    }

    /**
     * Sets the overwrite.
     *
     * @param overwrite the new overwrite
     */
    public void setOverwrite(final boolean overwrite) {
        this.overwrite = overwrite;
    }

    /**
     * Checks if is thumbnails.
     *
     * @return true, if is thumbnails
     */
    public boolean isThumbnails() {
        return thumbnails;
    }

    /**
     * Sets the thumbnails.
     *
     * @param thumbnails the new thumbnails
     */
    public void setThumbnails(final boolean thumbnails) {
        this.thumbnails = thumbnails;
    }

    /**
     * Gets the file data.
     *
     * @return the file data
     */
    public FileDataSource getFileData() {
        return fileData;
    }

    /**
     * Sets the file data.
     *
     * @param fileData the new file data
     */
    public void setFileData(final FileDataSource fileData) {
        this.fileData = fileData;
    }

}
