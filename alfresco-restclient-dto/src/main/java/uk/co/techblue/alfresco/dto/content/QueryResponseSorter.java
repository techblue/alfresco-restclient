package uk.co.techblue.alfresco.dto.content;

import org.codehaus.jackson.annotate.JsonProperty;

import uk.co.techblue.alfresco.dto.BaseDto;

public class QueryResponseSorter extends BaseDto {

    private static final long serialVersionUID = -5269615411978334553L;
    
    @JsonProperty("column")
    private String columnName;
    
    @JsonProperty("ascending")
    private boolean ascending;

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public boolean isAscending() {
        return ascending;
    }

    public void setAscending(boolean ascending) {
        this.ascending = ascending;
    }

}
