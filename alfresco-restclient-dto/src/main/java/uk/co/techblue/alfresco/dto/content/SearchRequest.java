package uk.co.techblue.alfresco.dto.content;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

import uk.co.techblue.alfresco.commons.AlfrescoConstants;
import uk.co.techblue.alfresco.dto.BaseDto;
import uk.co.techblue.alfresco.dto.common.QueryErrorHandler;
import uk.co.techblue.alfresco.dto.common.QueryLanguage;

/**
 * The JSON entity to construct search request. See detail at <a
 * href="http://docs.alfresco.com/4.2/topic/com.alfresco.enterprise.doc/references/API-JS-query.html" >this</a> link.
 */
public class SearchRequest extends BaseDto {

    private static final long serialVersionUID = -7085724112799555720L;

    @JsonProperty("query")
    private String query;

    @JsonProperty("store")
    private String store = AlfrescoConstants.DEFAULT_STORE;

    @JsonProperty("language")
    private QueryLanguage queryLanguage;

    @JsonProperty("templates")
    private List<QueryTemplate> queryTemplates;

    @JsonProperty("sort")
    private List<QueryResponseSorter> responseSorters;

    @JsonProperty("page")
    private PagingConfig pagingConfig;

    @JsonProperty("namespace")
    private String propertiesNamespace;

    @JsonProperty("defaultField")
    private String defaultResponseField;

    @JsonProperty("onerror")
    private QueryErrorHandler errorhandler;

    public SearchRequest(String query) {
        /*if (StringUtils.isBlank(query)) {
            throw new IllegalArgumentException("Query String cannot be blank.");
        }*/
        this.query = query;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public QueryLanguage getQueryLanguage() {
        return queryLanguage;
    }

    public void setQueryLanguage(QueryLanguage queryLanguage) {
        this.queryLanguage = queryLanguage;
    }

    public List<QueryTemplate> getQueryTemplates() {
        return queryTemplates;
    }

    public void setQueryTemplates(List<QueryTemplate> queryTemplates) {
        this.queryTemplates = queryTemplates;
    }

    public List<QueryResponseSorter> getResponseSorters() {
        return responseSorters;
    }

    public void setResponseSorters(List<QueryResponseSorter> responseSorters) {
        this.responseSorters = responseSorters;
    }

    public PagingConfig getPagingConfig() {
        return pagingConfig;
    }

    public void setPagingConfig(PagingConfig pagingConfig) {
        this.pagingConfig = pagingConfig;
    }

    public String getPropertiesNamespace() {
        return propertiesNamespace;
    }

    public void setPropertiesNamespace(String propertiesNamespace) {
        this.propertiesNamespace = propertiesNamespace;
    }

    public String getDefaultResponseField() {
        return defaultResponseField;
    }

    public void setDefaultResponseField(String defaultResponseField) {
        this.defaultResponseField = defaultResponseField;
    }

    public QueryErrorHandler getErrorhandler() {
        return errorhandler;
    }

    public void setErrorhandler(QueryErrorHandler errorhandler) {
        this.errorhandler = errorhandler;
    }

}
