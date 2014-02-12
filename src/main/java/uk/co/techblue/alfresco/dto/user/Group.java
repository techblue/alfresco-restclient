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
import uk.co.techblue.alfresco.dto.common.AuthorityType;

/**
 * The Class Group.
 */
public class Group extends BaseDto {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -1471777693101162262L;

    /** The authority type. */
    @JsonProperty("authorityType")
    private AuthorityType authorityType;

    /** The short name. */
    @JsonProperty("shortName")
    private String shortName;

    /** The full name. */
    @JsonProperty("fullName")
    private String fullName;

    /** The display name. */
    @JsonProperty("displayName")
    private String displayName;

    /** The url. */
    @JsonProperty("url")
    private String url;

    /**
     * Gets the authority type.
     * 
     * @return the authority type
     */
    public AuthorityType getAuthorityType() {
        return authorityType;
    }

    /**
     * Sets the authority type.
     * 
     * @param authorityType the new authority type
     */
    public void setAuthorityType(final AuthorityType authorityType) {
        this.authorityType = authorityType;
    }

    /**
     * Gets the short name.
     * 
     * @return the short name
     */
    public String getShortName() {
        return shortName;
    }

    /**
     * Sets the short name.
     * 
     * @param shortName the new short name
     */
    public void setShortName(final String shortName) {
        this.shortName = shortName;
    }

    /**
     * Gets the full name.
     * 
     * @return the full name
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * Sets the full name.
     * 
     * @param fullName the new full name
     */
    public void setFullName(final String fullName) {
        this.fullName = fullName;
    }

    /**
     * Gets the display name.
     * 
     * @return the display name
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     * Sets the display name.
     * 
     * @param displayName the new display name
     */
    public void setDisplayName(final String displayName) {
        this.displayName = displayName;
    }

    /**
     * Gets the url.
     * 
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * Sets the url.
     * 
     * @param url the new url
     */
    public void setUrl(final String url) {
        this.url = url;
    }

}
