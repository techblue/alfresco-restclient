package uk.co.techblue.alfresco.dto.content;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonProperty;

import uk.co.techblue.alfresco.dto.BaseDto;

public class ContentMetadata extends BaseDto {

    private static final long serialVersionUID = -824034451981584819L;

    @JsonProperty("properties")
    private Map<String, String> properties = new HashMap<String, String>();

    @JsonProperty("mimetype")
    private String mimetype;

    @JsonProperty("tags")
    private List<String> tags;

    public Map<String, String> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, String> properties) {
        this.properties = properties;
    }

    public String getMimetype() {
        return mimetype;
    }

    public void setMimetype(String mimetype) {
        this.mimetype = mimetype;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public void addTag(String value) {
        if(tags == null) {
            tags = new ArrayList<String>();
        }
        tags.add(value);
    }
    
    public void addProperty(String name, String value) {
        properties.put(name, value);
    }

}
