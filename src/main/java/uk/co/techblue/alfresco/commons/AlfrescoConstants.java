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
package uk.co.techblue.alfresco.commons;

/**
 * The Interface AlfrescoConstants.
 */
public interface AlfrescoConstants {

    /** The resource context base path. */
    String RESOURCE_CONTEXT_BASE_PATH = "/alfresco/service/api/";

    /** The auth ticket param name. */
    String AUTH_TICKET_PARAM_NAME = "alf_ticket";

    /** The default store type. */
    String DEFAULT_STORE_TYPE = "workspace";

    /** The default store id. */
    String DEFAULT_STORE_ID = "SpacesStore";

    /** The default store. */
    String DEFAULT_STORE = DEFAULT_STORE_TYPE + "://" + DEFAULT_STORE_ID;
}
