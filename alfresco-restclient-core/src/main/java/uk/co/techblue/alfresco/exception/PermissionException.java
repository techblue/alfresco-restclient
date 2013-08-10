package uk.co.techblue.alfresco.exception;

public class PermissionException extends AlfrescoServiceException {

    private static final long serialVersionUID = 2845061589650300820L;

    public PermissionException(String message, Throwable cause) {
        super(message, cause);
    }

    public PermissionException(String message) {
        super(message);
    }

    public PermissionException(Throwable cause) {
        super(cause);
    }

}
