package uk.co.techblue.alfresco.dto.content;

import org.codehaus.jackson.annotate.JsonProperty;

import uk.co.techblue.alfresco.dto.BaseDto;

public class QueryTemplate extends BaseDto {

    private static final long serialVersionUID = -1213291462198257552L;

    @JsonProperty("field")
    private String fieldName;

    @JsonProperty("template")
    private String template;

    public String getFieldName() {
        return fieldName;
    }

    /**
     * Sets the field name. See <a href=
     * "http://docs.alfresco.com/4.0/index.jsp?topic=%2Fcom.alfresco.enterprise.doc%2Fconcepts%2Frm-searchsyntax-querytemplates.html"
     * >this</a> link for details.
     * 
     * @param fieldName the new field name
     */
    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getTemplate() {
        return template;
    }

    /**
     * Sets the query template. See <a href=
     * "http://docs.alfresco.com/4.0/index.jsp?topic=%2Fcom.alfresco.enterprise.doc%2Fconcepts%2Frm-searchsyntax-querytemplates.html"
     * >this</a> link for details.
     * 
     * @param template the new template
     */
    public void setTemplate(String template) {
        this.template = template;
    }

}
