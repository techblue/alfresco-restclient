package uk.co.techblue.alfresco.dto.content;

import java.util.Map;

import org.codehaus.jackson.annotate.JsonProperty;

import uk.co.techblue.alfresco.dto.BaseDto;

public class ContentNode extends BaseDto {

	private static final long serialVersionUID = 5464075545403664477L;

	@JsonProperty("nodeId")
	private String nodeId;

	@JsonProperty("nodeRef")
	private String nodeRef;

	@JsonProperty("storeType")
	private String storeType;

	@JsonProperty("storeId")
	private String storeId;

	@JsonProperty("type")
	private String type;

	@JsonProperty("typeShort")
	private String typeShort;

	@JsonProperty("name")
	private String name;

	@JsonProperty("displayPath")
	private String displayPath;

	@JsonProperty("isContainer")
	private boolean isContainer;

	@JsonProperty("isDocument")
	private boolean isDocument;

	@JsonProperty("isCategory")
	private boolean isCategory;

	@JsonProperty("hasChildren")
	private boolean hasChildren;

	@JsonProperty("parentNodeId")
	private String parentNodeId;

	@JsonProperty("parentNodeRef")
	private String parentNodeRef;

	@JsonProperty("parentNodeName")
	private String parentNodeName;

	@JsonProperty("metadata")
	private Map<String, String> metadata;

	public String getNodeId() {
		return nodeId;
	}

	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
	}

	public String getNodeRef() {
		return nodeRef;
	}

	public void setNodeRef(String nodeRef) {
		this.nodeRef = nodeRef;
	}

	public String getStoreType() {
		return storeType;
	}

	public void setStoreType(String storeType) {
		this.storeType = storeType;
	}

	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTypeShort() {
		return typeShort;
	}

	public void setTypeShort(String typeShort) {
		this.typeShort = typeShort;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDisplayPath() {
		return displayPath;
	}

	public void setDisplayPath(String displayPath) {
		this.displayPath = displayPath;
	}

	public boolean isContainer() {
		return isContainer;
	}

	public void setContainer(boolean isContainer) {
		this.isContainer = isContainer;
	}

	public boolean isDocument() {
		return isDocument;
	}

	public void setDocument(boolean isDocument) {
		this.isDocument = isDocument;
	}

	public boolean isCategory() {
		return isCategory;
	}

	public void setCategory(boolean isCategory) {
		this.isCategory = isCategory;
	}

	public boolean isHasChildren() {
		return hasChildren;
	}

	public void setHasChildren(boolean hasChildren) {
		this.hasChildren = hasChildren;
	}

	public String getParentNodeId() {
		return parentNodeId;
	}

	public void setParentNodeId(String parentNodeId) {
		this.parentNodeId = parentNodeId;
	}

	public String getParentNodeRef() {
		return parentNodeRef;
	}

	public void setParentNodeRef(String parentNodeRef) {
		this.parentNodeRef = parentNodeRef;
	}

	public String getParentNodeName() {
		return parentNodeName;
	}

	public void setParentNodeName(String parentNodeName) {
		this.parentNodeName = parentNodeName;
	}

	public Map<String, String> getMetadata() {
		return metadata;
	}

	public void setMetadata(Map<String, String> metadata) {
		this.metadata = metadata;
	}

	public String getProperty(String name) {
		if (this.metadata != null) {
			return metadata.get(name);
		}
		return null;
	}

}