package uk.co.techblue.alfresco.dto.user;

import javax.ws.rs.QueryParam;

import uk.co.techblue.alfresco.dto.BaseDto;
import uk.co.techblue.alfresco.dto.common.GroupSorter;

public class BaseQuery extends BaseDto {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 4868432261009772095L;

    /** The max items. */
    @QueryParam("maxItems")
    protected Integer maxItems;

    /** The skip count. */
    @QueryParam("skipCount")
    protected Integer skipCount;

    /** The sort by. */
    @QueryParam("sortBy")
    protected GroupSorter sortBy;
    
    /**
     * Gets the max items.
     * 
     * @return the max items
     */
    public Integer getMaxItems() {
        return maxItems;
    }
 
    /**
     * Sets the max items.
     * 
     * @param maxItems the new max items
     */
    public void setMaxItems(final Integer maxItems) {
        this.maxItems = maxItems;
    }
 
    /**
     * Gets the skip count.
     * 
     * @return the skip count
     */
    public Integer getSkipCount() {
        return skipCount;
    }
 
    /**
     * Sets the skip count.
     * 
     * @param skipCount the new skip count
     */
    public void setSkipCount(final Integer skipCount) {
        this.skipCount = skipCount;
    }
 
    /**
     * Gets the sort by.
     * 
     * @return the sort by
     */
    public GroupSorter getSortBy() {
        return sortBy;
    }
 
    /**
     * Sets the sort by.
     * 
     * @param sortBy the new sort by
     */
    public void setSortBy(final GroupSorter sortBy) {
        this.sortBy = sortBy;
    }
}
