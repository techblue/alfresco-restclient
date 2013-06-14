package uk.co.techblue.alfresco.dto.user;

import org.codehaus.jackson.annotate.JsonProperty;

import uk.co.techblue.alfresco.dto.BaseDto;

public class PagingInfo extends BaseDto{

	private static final long serialVersionUID = -8347548918201106386L;
	
	@JsonProperty("maxItems")
	private int maxItems;
	
	@JsonProperty("skipCount")
	private int skipCount;
	
	@JsonProperty("totalItems")
	private int totalItems;
	
	@JsonProperty("totalItemsRangeEnd")
	private int totalItemsRangeEnd;
	
	@JsonProperty("confidence")
	private String confidence;

	public int getMaxItems() {
		return maxItems;
	}

	public void setMaxItems(int maxItems) {
		this.maxItems = maxItems;
	}

	public int getSkipCount() {
		return skipCount;
	}

	public void setSkipCount(int skipCount) {
		this.skipCount = skipCount;
	}

	public int getTotalItems() {
		return totalItems;
	}

	public void setTotalItems(int totalItems) {
		this.totalItems = totalItems;
	}

	public int getTotalItemsRangeEnd() {
		return totalItemsRangeEnd;
	}

	public void setTotalItemsRangeEnd(int totalItemsRangeEnd) {
		this.totalItemsRangeEnd = totalItemsRangeEnd;
	}

	public String getConfidence() {
		return confidence;
	}

	public void setConfidence(String confidence) {
		this.confidence = confidence;
	}

}
