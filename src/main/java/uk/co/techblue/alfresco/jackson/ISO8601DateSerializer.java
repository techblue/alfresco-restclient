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

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import uk.co.techblue.alfresco.dto.util.AlfrescoDtoUtil;

/**
 * The Class ISO8601DateSerializer.
 */
public class ISO8601DateSerializer extends JsonSerializer<Date> {

    /*
     * @see org.codehaus.jackson.map.JsonSerializer#serialize(java.lang.Object, org.codehaus.jackson.JsonGenerator,
     * org.codehaus.jackson.map.SerializerProvider)
     */
    @Override
    public void serialize(final Date value, final JsonGenerator jgen,
        final SerializerProvider provider) throws IOException {
        try {
            final String dateString = AlfrescoDtoUtil.formatISO8601Date(value);
            jgen.writeString(dateString);
        } catch (final ParseException pe) {
            throw new IOException(
                "Error occurred while formatting date to ISO8601 format",
                pe);
        }
    }

}
