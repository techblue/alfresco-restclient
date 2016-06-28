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
import java.text.ParseException;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;

import uk.co.techblue.alfresco.dto.Timestamp;
import uk.co.techblue.alfresco.dto.util.AlfrescoDtoUtil;

/**
 * The Class ISO8601DateDeserializer.
 */
public class ISO8601DateDeserializer extends JsonDeserializer<Date> {

    /*
     * @see org.codehaus.jackson.map.JsonDeserializer#deserialize(org.codehaus.jackson.JsonParser,
     * org.codehaus.jackson.map.DeserializationContext)
     */
    @Override
    public Date deserialize(final JsonParser jsonparser,
        final DeserializationContext deserializationcontext) throws IOException {
        final Timestamp timestamp = jsonparser.readValueAs(Timestamp.class);
        if (timestamp == null || StringUtils.isBlank(timestamp.getIso8601())) {
            return null;
        }
        final String dateString = timestamp.getIso8601();
        try {
            return AlfrescoDtoUtil.parseISO8601Date(dateString);
        } catch (final ParseException parseException) {
            throw new IOException("Error occurred while parsing date '"
                + dateString + "'", parseException);
        }
    }

}
