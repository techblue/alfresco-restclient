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

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import uk.co.techblue.alfresco.dto.BaseDto;

/**
 * The Class SearchGroupResponse.
 */
public class SearchGroupResponse extends BaseDto {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 4206673779660189991L;

    /** The groups. */
    @JsonProperty("data")
    private List<Group> groups;

    /** The paging info. */
    @JsonProperty("paging")
    private PagingInfo pagingInfo;

    /**
     * Gets the groups.
     * 
     * @return the groups
     */
    public List<Group> getGroups() {
        return groups;
    }

    /**
     * Sets the groups.
     * 
     * @param groups the new groups
     */
    public void setGroups(final List<Group> groups) {
        this.groups = groups;
    }

    /**
     * Gets the paging info.
     * 
     * @return the paging info
     */
    public PagingInfo getPagingInfo() {
        return pagingInfo;
    }

    /**
     * Sets the paging info.
     * 
     * @param pagingInfo the new paging info
     */
    public void setPagingInfo(final PagingInfo pagingInfo) {
        this.pagingInfo = pagingInfo;
    }

}
