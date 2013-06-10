package uk.co.techblue.alfresco.exception;

public class AuthenticationException extends AlfrescoServiceException {

	private static final long serialVersionUID = -3096312307287591027L;

	public AuthenticationException(String message, Throwable cause) {
		super(message, cause);
	}

	public AuthenticationException(String message) {
		super(message);
	}

	public AuthenticationException(Throwable cause) {
		super(cause);
	}

}
