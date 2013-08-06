package uk.co.techblue.alfresco.exception;

import uk.co.techblue.alfresco.dto.error.ServiceResponse;

public class AlfrescoServiceException extends Exception {

	private static final long serialVersionUID = -6081873510684510L;

	private ServiceResponse errorResponse;

	public AlfrescoServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public AlfrescoServiceException(String message) {
		super(message);
	}

	public AlfrescoServiceException(Throwable cause) {
		super(cause);
	}

	public ServiceResponse getErrorResponse() {
		return errorResponse;
	}

	public void setErrorResponse(ServiceResponse errorResponse) {
		this.errorResponse = errorResponse;
	}

}
