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
package uk.co.techblue.alfresco.resteasy.providers;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

import javax.activation.FileDataSource;
import javax.ws.rs.core.MultivaluedMap;

import org.jboss.resteasy.plugins.providers.multipart.AbstractMultipartWriter;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataOutput;
import org.jboss.resteasy.plugins.providers.multipart.MultipartOutput;
import org.jboss.resteasy.plugins.providers.multipart.OutputPart;
import org.jboss.resteasy.specimpl.MultivaluedMapImpl;

/**
 * The Class AbstractMultipartFormDataWriter.
 */
public class AbstractMultipartFormDataWriter extends AbstractMultipartWriter {

    /*
     * @see
     * org.jboss.resteasy.plugins.providers.multipart.AbstractMultipartWriter#writeParts(org.jboss.resteasy.plugins.providers
     * .multipart.MultipartOutput, java.io.OutputStream, byte[])
     */
    @Override
    protected void writeParts(final MultipartOutput multipartOutput,
        final OutputStream entityStream, final byte[] boundaryBytes) throws IOException {
        if (!(multipartOutput instanceof MultipartFormDataOutput))
            throw new IllegalArgumentException(
                "Had to write out multipartoutput = " + multipartOutput
                    + " with writer = " + this
                    + " but this writer can only handle "
                    + MultipartFormDataOutput.class);
        final MultipartFormDataOutput form = (MultipartFormDataOutput) multipartOutput;
        for (final Map.Entry<String, OutputPart> entry : form.getFormData()
            .entrySet()) {
            if (entry.getValue().getEntity() == null)
                continue;
            final MultivaluedMap<String, Object> headers = new MultivaluedMapImpl<String, Object>();
            String contentHeader = "form-data; name=\""
                + entry.getKey() + "\"";
            if (entry.getValue().getType().isAssignableFrom(FileDataSource.class)) {
                contentHeader += getFilename(form.getFormData().get("filename"));
            }
            headers.putSingle("Content-Disposition", contentHeader);
            writePart(entityStream, boundaryBytes, entry.getValue(), headers);
        }

    }

    /**
     * Gets the filename.
     * 
     * @param fileNamePart the file name part
     * @return the filename
     */
    private String getFilename(final OutputPart fileNamePart) {
        if (fileNamePart == null) {
            return "";
        }
        final String filename = (String) fileNamePart.getEntity();
        if (filename == null) {
            return "";
        } else {
            return "; filename=\"" + filename + "\"";
        }
    }
}
