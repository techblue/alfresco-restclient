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
 * The Class UnquoteCharacterEscapeDeserializer.
 * 
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
