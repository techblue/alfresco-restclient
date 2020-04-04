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

import com.fasterxml.jackson.annotation.JsonProperty;

import uk.co.techblue.alfresco.dto.BaseDto;

/**
 * The Class QueryResponseSorter.
 */
public class QueryResponseSorter extends BaseDto {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -5269615411978334553L;

    /** The column name. */
    @JsonProperty("column")
    private String columnName;

    /** The ascending. */
    @JsonProperty("ascending")
    private boolean ascending;

    /**
     * Gets the column name.
     * 
     * @return the column name
     */
    public String getColumnName() {
        return columnName;
    }

    /**
     * Sets the column name.
     * 
     * @param columnName the new column name
     */
    public void setColumnName(final String columnName) {
        this.columnName = columnName;
    }

    /**
     * Checks if is ascending.
     * 
     * @return true, if is ascending
     */
    public boolean isAscending() {
        return ascending;
    }

    /**
     * Sets the ascending.
     * 
     * @param ascending the new ascending
     */
    public void setAscending(final boolean ascending) {
        this.ascending = ascending;
    }

}
