package uk.co.techblue.alfresco.exception;

public class GroupException extends AlfrescoServiceException {

	private static final long serialVersionUID = -1943453715951536242L;

	public GroupException(String message, Throwable cause) {
		super(message, cause);
	}

	public GroupException(String message) {
		super(message);
	}

	public GroupException(Throwable cause) {
		super(cause);
	}

}
