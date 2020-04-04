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

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import uk.co.techblue.alfresco.dto.BaseDto;
import uk.co.techblue.alfresco.jackson.UnquoteCharacterEscapeDeserializer;

/**
 * The Class ContentNode.
 */
public class ContentNode extends BaseDto {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 5464075545403664477L;

    /** The node id. */
    @JsonProperty("nodeId")
    private String nodeId;

    /** The node ref. */
    @JsonProperty("nodeRef")
    private String nodeRef;

    /** The store type. */
    @JsonProperty("storeType")
    private String storeType;

    /** The store id. */
    @JsonProperty("storeId")
    private String storeId;

    /** The type. */
    @JsonProperty("type")
    private String type;

    /** The type short. */
    @JsonProperty("typeShort")
    private String typeShort;

    /** The name. */
    @JsonProperty("name")
    private String name;

    /** The size. */
    @JsonProperty("size")
    private String size;

    /** The display path. */
    @JsonProperty("displayPath")
    private String displayPath;

    /** The is container. */
    @JsonProperty("isContainer")
    private boolean isContainer;

    /** The is document. */
    @JsonProperty("isDocument")
    private boolean isDocument;

    /** The is category. */
    @JsonProperty("isCategory")
    private boolean isCategory;

    /** The has children. */
    @JsonProperty("hasChildren")
    private boolean hasChildren;

    /** The parent node id. */
    @JsonProperty("parentNodeId")
    private String parentNodeId;

    /** The parent node ref. */
    @JsonProperty("parentNodeRef")
    private String parentNodeRef;

    /** The parent node name. */
    @JsonProperty("parentNodeName")
    private String parentNodeName;

    /** The metadata. */
    @JsonProperty("metadata")
    @JsonDeserialize(using = UnquoteCharacterEscapeDeserializer.class)
    private Map<String, String> metadata;

    /**
     * Gets the node id.
     * 
     * @return the node id
     */
    public String getNodeId() {
        return nodeId;
    }

    /**
     * Sets the node id.
     * 
     * @param nodeId the new node id
     */
    public void setNodeId(final String nodeId) {
        this.nodeId = nodeId;
    }

    /**
     * Gets the node ref.
     * 
     * @return the node ref
     */
    public String getNodeRef() {
        return nodeRef;
    }

    /**
     * Sets the node ref.
     * 
     * @param nodeRef the new node ref
     */
    public void setNodeRef(final String nodeRef) {
        this.nodeRef = nodeRef;
    }

    /**
     * Gets the store type.
     * 
     * @return the store type
     */
    public String getStoreType() {
        return storeType;
    }

    /**
     * Sets the store type.
     * 
     * @param storeType the new store type
     */
    public void setStoreType(final String storeType) {
        this.storeType = storeType;
    }

    /**
     * Gets the store id.
     * 
     * @return the store id
     */
    public String getStoreId() {
        return storeId;
    }

    /**
     * Sets the store id.
     * 
     * @param storeId the new store id
     */
    public void setStoreId(final String storeId) {
        this.storeId = storeId;
    }

    /**
     * Gets the type.
     * 
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the type.
     * 
     * @param type the new type
     */
    public void setType(final String type) {
        this.type = type;
    }

    /**
     * Gets the type short.
     * 
     * @return the type short
     */
    public String getTypeShort() {
        return typeShort;
    }

    /**
     * Sets the type short.
     * 
     * @param typeShort the new type short
     */
    public void setTypeShort(final String typeShort) {
        this.typeShort = typeShort;
    }

    /**
     * Gets the name.
     * 
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name.
     * 
     * @param name the new name
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * Gets the display path.
     * 
     * @return the display path
     */
    public String getDisplayPath() {
        return displayPath;
    }

    /**
     * Sets the display path.
     * 
     * @param displayPath the new display path
     */
    public void setDisplayPath(final String displayPath) {
        this.displayPath = displayPath;
    }

    /**
     * Checks if is container.
     * 
     * @return true, if is container
     */
    public boolean isContainer() {
        return isContainer;
    }

    /**
     * Sets the container.
     * 
     * @param isContainer the new container
     */
    public void setContainer(final boolean isContainer) {
        this.isContainer = isContainer;
    }

    /**
     * Checks if is document.
     * 
     * @return true, if is document
     */
    public boolean isDocument() {
        return isDocument;
    }

    /**
     * Sets the document.
     * 
     * @param isDocument the new document
     */
    public void setDocument(final boolean isDocument) {
        this.isDocument = isDocument;
    }

    /**
     * Checks if is category.
     * 
     * @return true, if is category
     */
    public boolean isCategory() {
        return isCategory;
    }

    /**
     * Sets the category.
     * 
     * @param isCategory the new category
     */
    public void setCategory(final boolean isCategory) {
        this.isCategory = isCategory;
    }

    /**
     * Checks if is checks for children.
     * 
     * @return true, if is checks for children
     */
    public boolean isHasChildren() {
        return hasChildren;
    }

    /**
     * Sets the checks for children.
     * 
     * @param hasChildren the new checks for children
     */
    public void setHasChildren(final boolean hasChildren) {
        this.hasChildren = hasChildren;
    }

    /**
     * Gets the parent node id.
     * 
     * @return the parent node id
     */
    public String getParentNodeId() {
        return parentNodeId;
    }

    /**
     * Sets the parent node id.
     * 
     * @param parentNodeId the new parent node id
     */
    public void setParentNodeId(final String parentNodeId) {
        this.parentNodeId = parentNodeId;
    }

    /**
     * Gets the parent node ref.
     * 
     * @return the parent node ref
     */
    public String getParentNodeRef() {
        return parentNodeRef;
    }

    /**
     * Sets the parent node ref.
     * 
     * @param parentNodeRef the new parent node ref
     */
    public void setParentNodeRef(final String parentNodeRef) {
        this.parentNodeRef = parentNodeRef;
    }

    /**
     * Gets the parent node name.
     * 
     * @return the parent node name
     */
    public String getParentNodeName() {
        return parentNodeName;
    }

    /**
     * Sets the parent node name.
     * 
     * @param parentNodeName the new parent node name
     */
    public void setParentNodeName(final String parentNodeName) {
        this.parentNodeName = parentNodeName;
    }

    /**
     * Gets the metadata.
     * 
     * @return the metadata
     */
    public Map<String, String> getMetadata() {
        return metadata;
    }

    /**
     * Sets the metadata.
     * 
     * @param metadata the metadata
     */
    public void setMetadata(final Map<String, String> metadata) {
        this.metadata = metadata;
    }

    /**
     * Gets the property.
     * 
     * @param name the name
     * @return the property
     */
    public String getProperty(final String name) {
        if (metadata != null) {
            return metadata.get(name);
        }
        return null;
    }

    /**
     * Gets the size.
     * 
     * @return the size
     */
    public String getSize() {
        return size;
    }

    /**
     * Sets the size.
     * 
     * @param size the new size
     */
    public void setSize(final String size) {
        this.size = size;
    }

}