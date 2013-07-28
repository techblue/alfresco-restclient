package uk.co.techblue.alfresco.exception;

public class SearchException extends AlfrescoServiceException {

    private static final long serialVersionUID = -286710296075135967L;

    public SearchException(String message, Throwable cause) {
        super(message, cause);
    }

    public SearchException(String message) {
        super(message);
    }

    public SearchException(Throwable cause) {
        super(cause);
    }

}
