package uk.co.techblue.alfresco.exception;

public class UserException extends AlfrescoServiceException {

	private static final long serialVersionUID = 3595946830238681190L;

	public UserException(String message, Throwable cause) {
		super(message, cause);
	}

	public UserException(String message) {
		super(message);
	}

	public UserException(Throwable cause) {
		super(cause);
	}

}
