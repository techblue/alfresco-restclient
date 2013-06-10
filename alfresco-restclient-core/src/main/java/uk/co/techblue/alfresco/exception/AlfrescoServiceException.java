package uk.co.techblue.alfresco.exception;

import uk.co.techblue.alfresco.dto.error.ErrorResponse;

public class AlfrescoServiceException extends Exception {

	private static final long serialVersionUID = -6081873510684510L;

	private ErrorResponse errorResponse;

	public AlfrescoServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public AlfrescoServiceException(String message) {
		super(message);
	}

	public AlfrescoServiceException(Throwable cause) {
		super(cause);
	}

	public ErrorResponse getErrorResponse() {
		return errorResponse;
	}

	public void setErrorResponse(ErrorResponse errorResponse) {
		this.errorResponse = errorResponse;
	}

}
