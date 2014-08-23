/*******************************************************************************
 * Copyright 2013, Barbon. All Rights Reserved. 
 * No part of this content may be used without Barbon's express consent.
 ******************************************************************************/
package uk.co.techblue.alfresco.jackson;

import java.io.IOException;
import java.util.Map;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonParser.Feature;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;
import org.codehaus.jackson.type.TypeReference;

/**
 * The Class StringEscapeDeserializer.
 * 
 * @author <a href="mailto:dishant.anand@techblue.co.uk">Dishant anand</a>
 */
public class UnquoteCharacterEscapeDeserializer extends JsonDeserializer<Map<String, String>> {

    /*
     * (non-Javadoc)
     * 
     * @see org.codehaus.jackson.map.JsonDeserializer#deserialize(org.codehaus.jackson.JsonParser,
     * org.codehaus.jackson.map.DeserializationContext)
     */
    @Override
    public Map<String, String> deserialize(final JsonParser jsonparser, final DeserializationContext ctxt) throws IOException, JsonProcessingException {
        return jsonparser.configure(Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true).readValueAs(new TypeReference<Map<String, String>>() {
        });
    }

}
