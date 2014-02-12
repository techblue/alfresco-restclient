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
package uk.co.techblue.alfresco.dto.user;

import org.codehaus.jackson.annotate.JsonProperty;

import uk.co.techblue.alfresco.dto.BaseDto;

/**
 * The Class PagingInfo.
 */
public class PagingInfo extends BaseDto {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -8347548918201106386L;

    /** The max items. */
    @JsonProperty("maxItems")
    private int maxItems;

    /** The skip count. */
    @JsonProperty("skipCount")
    private int skipCount;

    /** The total items. */
    @JsonProperty("totalItems")
    private int totalItems;

    /** The total items range end. */
    @JsonProperty("totalItemsRangeEnd")
    private int totalItemsRangeEnd;

    /** The confidence. */
    @JsonProperty("confidence")
    private String confidence;

    /**
     * Gets the max items.
     * 
     * @return the max items
     */
    public int getMaxItems() {
        return maxItems;
    }

    /**
     * Sets the max items.
     * 
     * @param maxItems the new max items
     */
    public void setMaxItems(final int maxItems) {
        this.maxItems = maxItems;
    }

    /**
     * Gets the skip count.
     * 
     * @return the skip count
     */
    public int getSkipCount() {
        return skipCount;
    }

    /**
     * Sets the skip count.
     * 
     * @param skipCount the new skip count
     */
    public void setSkipCount(final int skipCount) {
        this.skipCount = skipCount;
    }

    /**
     * Gets the total items.
     * 
     * @return the total items
     */
    public int getTotalItems() {
        return totalItems;
    }

    /**
     * Sets the total items.
     * 
     * @param totalItems the new total items
     */
    public void setTotalItems(final int totalItems) {
        this.totalItems = totalItems;
    }

    /**
     * Gets the total items range end.
     * 
     * @return the total items range end
     */
    public int getTotalItemsRangeEnd() {
        return totalItemsRangeEnd;
    }

    /**
     * Sets the total items range end.
     * 
     * @param totalItemsRangeEnd the new total items range end
     */
    public void setTotalItemsRangeEnd(final int totalItemsRangeEnd) {
        this.totalItemsRangeEnd = totalItemsRangeEnd;
    }

    /**
     * Gets the confidence.
     * 
     * @return the confidence
     */
    public String getConfidence() {
        return confidence;
    }

    /**
     * Sets the confidence.
     * 
     * @param confidence the new confidence
     */
    public void setConfidence(final String confidence) {
        this.confidence = confidence;
    }

}
