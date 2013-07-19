package uk.co.techblue.alfresco.exception;

public class ContentException extends AlfrescoServiceException {

	private static final long serialVersionUID = 3640290970017128491L;

	public ContentException(String message, Throwable cause) {
		super(message, cause);
	}

	public ContentException(String message) {
		super(message);
	}

	public ContentException(Throwable cause) {
		super(cause);
	}

}
