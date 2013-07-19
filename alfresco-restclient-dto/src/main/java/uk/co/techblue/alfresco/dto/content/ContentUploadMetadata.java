package uk.co.techblue.alfresco.dto.content;

import javax.activation.FileDataSource;
import javax.ws.rs.FormParam;
import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.annotations.providers.multipart.PartType;

import uk.co.techblue.alfresco.dto.BaseDto;

public class ContentUploadMetadata extends BaseDto {

    private static final long serialVersionUID = -776494597401819448L;

    @FormParam("filename")
    private String fileName;

    @FormParam("description")
    private String description;

    @FormParam("destination")
    private String destination;

    @FormParam("siteid")
    private String siteId;

    @FormParam("containerid")
    private String containerId;

    @FormParam("uploaddirectory")
    private String uploadDirectory;

    @FormParam("updatenoderef")
    private String updateNodeRef;

    @FormParam("contenttype")
    private String contentType;

    @FormParam("majorversion")
    private String majorVersion;

    @FormParam("overwrite")
    private boolean overwrite;

    @FormParam("thumbnails")
    private boolean thumbnails;

    @FormParam("filedata")
    @PartType(MediaType.APPLICATION_OCTET_STREAM)
    private FileDataSource fileData;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    public String getContainerId() {
        return containerId;
    }

    public void setContainerId(String containerId) {
        this.containerId = containerId;
    }

    public String getUploadDirectory() {
        return uploadDirectory;
    }

    public void setUploadDirectory(String uploadDirectory) {
        this.uploadDirectory = uploadDirectory;
    }

    public String getUpdateNodeRef() {
        return updateNodeRef;
    }

    public void setUpdateNodeRef(String updateNodeRef) {
        this.updateNodeRef = updateNodeRef;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getMajorVersion() {
        return majorVersion;
    }

    public void setMajorVersion(String majorVersion) {
        this.majorVersion = majorVersion;
    }

    public boolean isOverwrite() {
        return overwrite;
    }

    public void setOverwrite(boolean overwrite) {
        this.overwrite = overwrite;
    }

    public boolean isThumbnails() {
        return thumbnails;
    }

    public void setThumbnails(boolean thumbnails) {
        this.thumbnails = thumbnails;
    }

    public FileDataSource getFileData() {
        return fileData;
    }

    public void setFileData(FileDataSource fileData) {
        this.fileData = fileData;
    }

}
