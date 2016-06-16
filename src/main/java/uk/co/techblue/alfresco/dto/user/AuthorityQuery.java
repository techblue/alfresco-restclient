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

import uk.co.techblue.alfresco.dto.common.AuthorityType;

/**
 * The Class AuthorityQuery.
 */
public class AuthorityQuery extends BaseQuery {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -3979600916433012399L;

    /** The authority type. */
    @QueryParam("authorityType")
    private AuthorityType authorityType;

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

}
