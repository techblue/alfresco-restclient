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
import org.jboss.resteasy.logging.Logger;
import org.jboss.resteasy.plugins.providers.ProviderHelper;

import uk.co.techblue.alfresco.dto.DocumentContent;

@Provider
@Produces("*/*")
@Consumes("*/*")
public class DocumentContentProvider implements MessageBodyReader<DocumentContent> {

	private static final String PREFIX = "pfx";

	private static final String SUFFIX = "sfx";

	private static final String PARAM_FILENAME = "filename";

	private String downloadDirectory = null; // by default temp dir, consider allowing it to be defined at runtime

	private final static Logger logger = Logger.getLogger(DocumentContentProvider.class);

	public boolean isReadable(Class<?> type, Type genericType,
			Annotation[] annotations, MediaType mediaType) {
		return DocumentContent.class == type;
	}

	public DocumentContent readFrom(Class<DocumentContent> type, Type genericType,
			Annotation[] annotations, MediaType mediaType,
			MultivaluedMap<String, String> httpHeaders, InputStream entityStream)
			throws IOException {
		File downloadedFile = null;
		String dispositionHeader = httpHeaders
				.getFirst(FieldName.CONTENT_DISPOSITION);
		ContentDisposition contentDisposition = null;
		try {
			contentDisposition = getContentDisposition(dispositionHeader);
		} catch (ParseException pe) {
			throw new IOException(
					"Error occurred while parsing header. "
							+ FieldName.CONTENT_DISPOSITION + " : "
							+ dispositionHeader, pe);
		}
		DocumentContent DocumentContent = new DocumentContent();
		String prefix = null;
		String suffix = null;
		if (contentDisposition != null) {
			setDocumentAttributes(contentDisposition, DocumentContent);
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
			suffix = SUFFIX;
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

		OutputStream output = new BufferedOutputStream(new FileOutputStream(
				downloadedFile));

		try {
			ProviderHelper.writeTo(entityStream, output);
		} finally {
			output.close();
		}
		DocumentContent.setDocFile(downloadedFile);

		return DocumentContent;
	}

	private String getFilePrefix(ContentDisposition contentDisposition) {
		String fileName = contentDisposition.getParameter(PARAM_FILENAME);
		return StringUtils.substringBeforeLast(fileName, ".");
	}

	private void setDocumentAttributes(ContentDisposition contentDisposition,
			DocumentContent DocumentContent) {
//		DocumentContent.setDocumentId(contentDisposition
//				.getParameter(PARAM_DOCUMENT_ID));
//		DocumentContent.setName(contentDisposition.getParameter(PARAM_FILENAME));
	}

	private String getFileSuffix(ContentDisposition contentDisposition,
			MediaType mediaType) {
		String fileName = contentDisposition.getParameter(PARAM_FILENAME);
		return getFileSuffix(mediaType, fileName);
	}
	
	private String getFileSuffix(MediaType mediaType) {
		return getFileSuffix(mediaType, null);
	}

	private String getFileSuffix(MediaType mediaType, String fileName) {
		String suffix = StringUtils.substringAfterLast(fileName, ".");
		String mediaSubtype = StringUtils.defaultString(mediaType.getSubtype());
		boolean suffixBlank = StringUtils.isBlank(suffix);
		boolean mediaSubtypeBlank = StringUtils.isBlank(mediaSubtype);
		if (!suffixBlank && mediaSubtype.equalsIgnoreCase(suffix)) {
			suffix = "." + suffix;
		} else if (!suffixBlank && mediaSubtypeBlank) {
			suffix = "." + suffix;
		} else if (suffixBlank && !mediaSubtypeBlank) {
			suffix = "." + mediaSubtype;
		} else if (!suffixBlank && !mediaSubtypeBlank) {
			suffix = "." + suffix + "." + mediaSubtype;
		} else {
			suffix = ".pdf";
		}
		return suffix;
	}

	private ContentDisposition getContentDisposition(String dispositionHeader)
			throws ParseException {
		if (StringUtils.isBlank(dispositionHeader)) {
			return null;
		}
		return new ContentDisposition(dispositionHeader);
	}

	public boolean isWriteable(Class<?> type, Type genericType,
			Annotation[] annotations, MediaType mediaType) {
		return File.class.isAssignableFrom(type); // catch subtypes
	}

	public long getSize(File o, Class<?> type, Type genericType,
			Annotation[] annotations, MediaType mediaType) {
		return o.length();
	}

	public void writeTo(File uploadFile, Class<?> type, Type genericType,
			Annotation[] annotations, MediaType mediaType,
			MultivaluedMap<String, Object> httpHeaders,
			OutputStream entityStream) throws IOException {
		InputStream inputStream = new BufferedInputStream(new FileInputStream(
				uploadFile));

		try {
			ProviderHelper.writeTo(inputStream, entityStream);
		} finally {
			inputStream.close();
		}
	}

}
