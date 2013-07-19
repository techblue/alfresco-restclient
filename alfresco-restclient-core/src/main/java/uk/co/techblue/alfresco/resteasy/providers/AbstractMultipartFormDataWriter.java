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

public class AbstractMultipartFormDataWriter extends AbstractMultipartWriter {
	
	@Override
	protected void writeParts(MultipartOutput multipartOutput,
			OutputStream entityStream, byte[] boundaryBytes) throws IOException {
		if (!(multipartOutput instanceof MultipartFormDataOutput))
			throw new IllegalArgumentException(
					"Had to write out multipartoutput = " + multipartOutput
							+ " with writer = " + this
							+ " but this writer can only handle "
							+ MultipartFormDataOutput.class);
		MultipartFormDataOutput form = (MultipartFormDataOutput) multipartOutput;
		for (Map.Entry<String, OutputPart> entry : form.getFormData()
				.entrySet()) {
			if (entry.getValue().getEntity() == null)
				continue;
			MultivaluedMap<String, Object> headers = new MultivaluedMapImpl<String, Object>();
			String contentHeader = "form-data; name=\""
					+ entry.getKey() + "\"" ;
			if(entry.getValue().getType().isAssignableFrom(FileDataSource.class)) {
				contentHeader += getFilename(form.getFormData().get("filename"));
			}
			headers.putSingle("Content-Disposition",  contentHeader);
			writePart(entityStream, boundaryBytes, entry.getValue(), headers);
		}

	}

	private String getFilename(OutputPart fileNamePart) {
		if (fileNamePart == null){
			return "";
		}
		String filename = (String) fileNamePart.getEntity();
		if (filename == null) {
			return "";
		} else {
			return "; filename=\"" + filename + "\"";
		}
	}
}
