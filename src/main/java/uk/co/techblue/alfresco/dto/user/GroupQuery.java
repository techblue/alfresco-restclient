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

import javax.ws.rs.QueryParam;

/**
 * The Class GroupQuery.
 */
public class GroupQuery extends BaseQuery {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 4809842369740131482L;

    /** The short name filter. */
    @QueryParam("shortNameFilter")
    private String shortNameFilter;

    /** The zone. */
    @QueryParam("zone")
    private Boolean zone;

    /**
     * Gets the short name filter.
     * 
     * @return the short name filter
     */
    public String getShortNameFilter() {
        return shortNameFilter;
    }

    /**
     * Sets the short name filter.
     * 
     * @param shortNameFilter the new short name filter
     */
    public void setShortNameFilter(final String shortNameFilter) {
        this.shortNameFilter = shortNameFilter;
    }

    /**
     * Gets the zone.
     * 
     * @return the zone
     */
    public Boolean getZone() {
        return zone;
    }

    /**
     * Sets the zone.
     * 
     * @param zone the new zone
     */
    public void setZone(final Boolean zone) {
        this.zone = zone;
    }

}
