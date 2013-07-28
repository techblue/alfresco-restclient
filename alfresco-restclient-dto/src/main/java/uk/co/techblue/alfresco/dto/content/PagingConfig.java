package uk.co.techblue.alfresco.dto.content;

import org.codehaus.jackson.annotate.JsonProperty;

import uk.co.techblue.alfresco.dto.BaseDto;

public class PagingConfig extends BaseDto {

    private static final long serialVersionUID = -4814175523989306623L;

    @JsonProperty("maxItems")
    private int maxItems;

    @JsonProperty("skipCount")
    private int skipCount;

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

}
