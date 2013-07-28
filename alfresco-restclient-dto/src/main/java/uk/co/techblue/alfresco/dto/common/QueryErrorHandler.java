package uk.co.techblue.alfresco.dto.common;

public enum QueryErrorHandler {

    EXCEPTION("exception"), 
    NO_RESULTS("no-results");

    private String name;

    private QueryErrorHandler(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
