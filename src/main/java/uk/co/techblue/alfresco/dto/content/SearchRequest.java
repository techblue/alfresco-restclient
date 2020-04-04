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

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import uk.co.techblue.alfresco.commons.AlfrescoConstants;
import uk.co.techblue.alfresco.dto.BaseDto;
import uk.co.techblue.alfresco.dto.common.QueryErrorHandler;
import uk.co.techblue.alfresco.dto.common.QueryLanguage;

/**
 * The JSON entity to construct search request. See detail at <a
 * href="http://docs.alfresco.com/4.2/topic/com.alfresco.enterprise.doc/references/API-JS-query.html" >this</a> link.
 */
public class SearchRequest extends BaseDto {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -7085724112799555720L;

    /** The query. */
    @JsonProperty("query")
    private String query;

    /** The store. */
    @JsonProperty("store")
    private String store = AlfrescoConstants.DEFAULT_STORE;

    /** The query language. */
    @JsonProperty("language")
    private QueryLanguage queryLanguage;

    /** The query templates. */
    @JsonProperty("templates")
    private List<QueryTemplate> queryTemplates;

    /** The response sorters. */
    @JsonProperty("sort")
    private List<QueryResponseSorter> responseSorters;

    /** The paging config. */
    @JsonProperty("page")
    private PagingConfig pagingConfig;

    /** The properties namespace. */
    @JsonProperty("namespace")
    private String propertiesNamespace;

    /** The default response field. */
    @JsonProperty("defaultField")
    private String defaultResponseField;

    /** The errorhandler. */
    @JsonProperty("onerror")
    private QueryErrorHandler errorhandler;

    /**
     * Instantiates a new search request.
     * 
     * @param query the query
     */
    public SearchRequest(final String query) {
        this.query = query;
    }

    /**
     * Gets the query.
     * 
     * @return the query
     */
    public String getQuery() {
        return query;
    }

    /**
     * Sets the query.
     * 
     * @param query the new query
     */
    public void setQuery(final String query) {
        this.query = query;
    }

    /**
     * Gets the store.
     * 
     * @return the store
     */
    public String getStore() {
        return store;
    }

    /**
     * Sets the store.
     * 
     * @param store the new store
     */
    public void setStore(final String store) {
        this.store = store;
    }

    /**
     * Gets the query language.
     * 
     * @return the query language
     */
    public QueryLanguage getQueryLanguage() {
        return queryLanguage;
    }

    /**
     * Sets the query language.
     * 
     * @param queryLanguage the new query language
     */
    public void setQueryLanguage(final QueryLanguage queryLanguage) {
        this.queryLanguage = queryLanguage;
    }

    /**
     * Gets the query templates.
     * 
     * @return the query templates
     */
    public List<QueryTemplate> getQueryTemplates() {
        return queryTemplates;
    }

    /**
     * Sets the query templates.
     * 
     * @param queryTemplates the new query templates
     */
    public void setQueryTemplates(final List<QueryTemplate> queryTemplates) {
        this.queryTemplates = queryTemplates;
    }

    /**
     * Gets the response sorters.
     * 
     * @return the response sorters
     */
    public List<QueryResponseSorter> getResponseSorters() {
        return responseSorters;
    }

    /**
     * Sets the response sorters.
     * 
     * @param responseSorters the new response sorters
     */
    public void setResponseSorters(final List<QueryResponseSorter> responseSorters) {
        this.responseSorters = responseSorters;
    }

    /**
     * Gets the paging config.
     * 
     * @return the paging config
     */
    public PagingConfig getPagingConfig() {
        return pagingConfig;
    }

    /**
     * Sets the paging config.
     * 
     * @param pagingConfig the new paging config
     */
    public void setPagingConfig(final PagingConfig pagingConfig) {
        this.pagingConfig = pagingConfig;
    }

    /**
     * Gets the properties namespace.
     * 
     * @return the properties namespace
     */
    public String getPropertiesNamespace() {
        return propertiesNamespace;
    }

    /**
     * Sets the properties namespace.
     * 
     * @param propertiesNamespace the new properties namespace
     */
    public void setPropertiesNamespace(final String propertiesNamespace) {
        this.propertiesNamespace = propertiesNamespace;
    }

    /**
     * Gets the default response field.
     * 
     * @return the default response field
     */
    public String getDefaultResponseField() {
        return defaultResponseField;
    }

    /**
     * Sets the default response field.
     * 
     * @param defaultResponseField the new default response field
     */
    public void setDefaultResponseField(final String defaultResponseField) {
        this.defaultResponseField = defaultResponseField;
    }

    /**
     * Gets the errorhandler.
     * 
     * @return the errorhandler
     */
    public QueryErrorHandler getErrorhandler() {
        return errorhandler;
    }

    /**
     * Sets the errorhandler.
     * 
     * @param errorhandler the new errorhandler
     */
    public void setErrorhandler(final QueryErrorHandler errorhandler) {
        this.errorhandler = errorhandler;
    }

}
