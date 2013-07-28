package uk.co.techblue.alfresco.dto.common;

public enum QueryLanguage {
    LUCENE("lucene"), 
    XPATH("xpath"), 
    JCR_XPATH("jcr-xpath"), 
    FTS_ALFRESCO("fts-alfresco");

    private String name;

    private QueryLanguage(String name) {
        this.name = name;
    }
    
    @Override
    public String toString() {
        return name;
    }

}
