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

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.mail.internet.ContentDisposition;
import javax.mail.internet.ParseException;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.Provider;

import org.apache.commons.lang3.StringUtils;
import org.apache.james.mime4j.field.FieldName;
import org.apache.tika.config.TikaConfig;
import org.apache.tika.mime.MimeType;
import org.apache.tika.mime.MimeTypeException;
import org.apache.tika.mime.MimeTypes;
import org.jboss.resteasy.logging.Logger;
import org.jboss.resteasy.plugins.providers.ProviderHelper;

import uk.co.techblue.alfresco.dto.content.DocumentContent;

/**
 * The Class DocumentContentProvider.
 */
@Provider
@Produces("*/*")
@Consumes("*/*")
public class DocumentContentProvider implements MessageBodyReader<DocumentContent> {

    /** The Constant PREFIX. */
    private static final String PREFIX = "dms";

    /** The Constant SUFFIX. */
    private static final String SUFFIX = "file";

    /** The Constant PARAM_FILENAME. */
    private static final String PARAM_FILENAME = "filename";

    /** The download directory. */
    private final String downloadDirectory = null; // by default temp dir, consider allowing it to be defined at runtime

    /** The Constant logger. */
    private final static Logger logger = Logger.getLogger(DocumentContentProvider.class);

    /*
     * @see javax.ws.rs.ext.MessageBodyReader#isReadable(java.lang.Class, java.lang.reflect.Type,
     * java.lang.annotation.Annotation[], javax.ws.rs.core.MediaType)
     */
    @Override
    public boolean isReadable(final Class<?> type, final Type genericType,
        final Annotation[] annotations, final MediaType mediaType) {
        return DocumentContent.class == type;
    }

    /*
     * @see javax.ws.rs.ext.MessageBodyReader#readFrom(java.lang.Class, java.lang.reflect.Type,
     * java.lang.annotation.Annotation[], javax.ws.rs.core.MediaType, javax.ws.rs.core.MultivaluedMap, java.io.InputStream)
     */
    @Override
    public DocumentContent readFrom(final Class<DocumentContent> type, final Type genericType,
        final Annotation[] annotations, final MediaType mediaType,
        final MultivaluedMap<String, String> httpHeaders, final InputStream entityStream)
        throws IOException {
        File downloadedFile = null;
        final String dispositionHeader = httpHeaders
            .getFirst(FieldName.CONTENT_DISPOSITION);
        ContentDisposition contentDisposition = null;
        try {
            contentDisposition = getContentDisposition(dispositionHeader);
        } catch (final ParseException pe) {
            throw new IOException(
                "Error occurred while parsing header. "
                    + FieldName.CONTENT_DISPOSITION + " : "
                    + dispositionHeader, pe);
        }
        final DocumentContent documentContent = new DocumentContent();
        String prefix = null;
        String suffix = null;
        if (contentDisposition != null) {
            setDocumentAttributes(contentDisposition, documentContent);
            suffix = getFileSuffix(contentDisposition, mediaType);
            prefix = getFilePrefix(contentDisposition);
        } else {
            logger.warn("Content Disposition header not found in response. All the attributes DocumentContent instance won't be populated.");
            suffix = getFileSuffix(mediaType);
        }
        if (StringUtils.isBlank(prefix)) {
            prefix = PREFIX;
        }
        if (StringUtils.isBlank(suffix)) {
            suffix = "." + SUFFIX;
        }
        if (downloadDirectory != null) {
            try {
                downloadedFile = File.createTempFile(prefix, suffix, new File(
                    downloadDirectory));
            } catch (final IOException ex) {
                // could make this configurable, so we fail on fault rather than
                // default.
                logger.error("Could not bind to specified download directory "
                    + downloadDirectory + " so will use temp dir.");
            }
        }

        if (downloadedFile == null)
            downloadedFile = File.createTempFile(prefix, suffix);

        final OutputStream output = new BufferedOutputStream(new FileOutputStream(
            downloadedFile));

        try {
            ProviderHelper.writeTo(entityStream, output);
        } finally {
            output.close();
        }
        documentContent.setDocFile(downloadedFile);

        return documentContent;
    }

    /**
     * Gets the file prefix.
     * 
     * @param contentDisposition the content disposition
     * @return the file prefix
     */
    private String getFilePrefix(final ContentDisposition contentDisposition) {
        final String fileName = contentDisposition.getParameter(PARAM_FILENAME);
        return StringUtils.substringBeforeLast(fileName, ".");
    }

    /**
     * Sets the document attributes.
     * 
     * @param contentDisposition the content disposition
     * @param DocumentContent the document content
     */
    private void setDocumentAttributes(final ContentDisposition contentDisposition,
        final DocumentContent DocumentContent) {
        // DocumentContent.setDocumentId(contentDisposition
        // .getParameter(PARAM_DOCUMENT_ID));
        // DocumentContent.setName(contentDisposition.getParameter(PARAM_FILENAME));
    }

    /**
     * Gets the file suffix.
     * 
     * @param contentDisposition the content disposition
     * @param mediaType the media type
     * @return the file suffix
     */
    private String getFileSuffix(final ContentDisposition contentDisposition,
        final MediaType mediaType) {
        final String fileName = contentDisposition.getParameter(PARAM_FILENAME);
        return getFileSuffix(mediaType, fileName);
    }

    /**
     * Gets the file suffix.
     * 
     * @param mediaType the media type
     * @return the file suffix
     */
    private String getFileSuffix(final MediaType mediaType) {
        return getFileSuffix(mediaType, null);
    }

    /**
     * Gets the file suffix.
     * 
     * @param mediaType the media type
     * @param fileName the file name
     * @return the file suffix
     */
    private String getFileSuffix(final MediaType mediaType, final String fileName) {
        String suffix = StringUtils.substringAfterLast(fileName, ".");
        if (StringUtils.isNotBlank(suffix)) {
            suffix = "." + suffix;
        } else {
            final String mediaSubtype = StringUtils.defaultString(mediaType.getSubtype());
            suffix = getFileExtension(getHttpMimeType(mediaType), mediaSubtype);
        }
        return suffix;
    }

    /**
     * Gets the http mime type.
     * 
     * @param mediaType the media type
     * @return the http mime type
     */
    private String getHttpMimeType(final MediaType mediaType) {
        return mediaType.getType() + "/" + mediaType.getSubtype();
    }

    /**
     * Gets the file extension.
     * 
     * @param mimeType the mime type
     * @param defaultExtension the default extension
     * @return the file extension
     */
    private String getFileExtension(final String mimeType, final String defaultExtension) {
        final TikaConfig config = TikaConfig.getDefaultConfig();
        final MimeTypes allTypes = config.getMimeRepository();
        MimeType contentType = null;
        try {
            contentType = allTypes.forName(mimeType);
        } catch (final MimeTypeException mte) {
            logger.error("An error occurred while getting extension mapping against mime: " + mimeType, mte);
        }
        if (contentType != null) {
            return contentType.getExtension();
        }
        logger.error("UNABLE TO GET EXTENSION AGAINST MIMETYPE '" + mimeType + "'. RETURNING EXTENSION VALUE SAME AS MIMETYPE.");
        return "." + defaultExtension;
    }

    /**
     * Gets the content disposition.
     * 
     * @param dispositionHeader the disposition header
     * @return the content disposition
     * @throws ParseException the parse exception
     */
    private ContentDisposition getContentDisposition(final String dispositionHeader)
        throws ParseException {
        if (StringUtils.isBlank(dispositionHeader)) {
            return null;
        }
        return new ContentDisposition(dispositionHeader);
    }

    /**
     * Checks if is writeable.
     * 
     * @param type the type
     * @param genericType the generic type
     * @param annotations the annotations
     * @param mediaType the media type
     * @return true, if is writeable
     */
    public boolean isWriteable(final Class<?> type, final Type genericType,
        final Annotation[] annotations, final MediaType mediaType) {
        return File.class.isAssignableFrom(type); // catch subtypes
    }

    /**
     * Gets the size.
     * 
     * @param o the o
     * @param type the type
     * @param genericType the generic type
     * @param annotations the annotations
     * @param mediaType the media type
     * @return the size
     */
    public long getSize(final File o, final Class<?> type, final Type genericType,
        final Annotation[] annotations, final MediaType mediaType) {
        return o.length();
    }

    /**
     * Write to.
     * 
     * @param uploadFile the upload file
     * @param type the type
     * @param genericType the generic type
     * @param annotations the annotations
     * @param mediaType the media type
     * @param httpHeaders the http headers
     * @param entityStream the entity stream
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public void writeTo(final File uploadFile, final Class<?> type, final Type genericType,
        final Annotation[] annotations, final MediaType mediaType,
        final MultivaluedMap<String, Object> httpHeaders,
        final OutputStream entityStream) throws IOException {
        final InputStream inputStream = new BufferedInputStream(new FileInputStream(
            uploadFile));

        try {
            ProviderHelper.writeTo(inputStream, entityStream);
        } finally {
            inputStream.close();
        }
    }

}
