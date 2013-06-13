package uk.co.techblue.alfresco.client;

import java.lang.reflect.InvocationTargetException;

import javax.ws.rs.core.Response.Status.Family;

import org.jboss.resteasy.client.ClientResponse;
import org.jboss.resteasy.client.ClientResponseFailure;
import org.jboss.resteasy.client.ProxyFactory;
import org.jboss.resteasy.logging.Logger;

import uk.co.techblue.alfresco.dto.error.ErrorResponse;
import uk.co.techblue.alfresco.exception.AlfrescoServiceException;

public abstract class Service<RT extends Resource> {

	private final Logger logger = Logger.getLogger(getClass());

	/** The rest base uri. */
	protected final String restBaseUri;

	/** The resource proxy. */
	protected final RT resourceProxy;

	public Service(final String restBaseUri) {
		this.restBaseUri = restBaseUri;
		this.resourceProxy = getResourceProxy(getResourceClass(), restBaseUri);
	}

	/**
	 * Gets the resource class.
	 * 
	 * @return the resource class
	 */
	protected abstract Class<RT> getResourceClass();

	/**
	 * Gets the resource proxy.
	 * 
	 * @param <T>
	 *            the generic resource type
	 * @param clazz
	 *            the resource class
	 * @param serverUri
	 *            the server uri
	 * @return the resource proxy
	 */
	protected <T> T getResourceProxy(final Class<T> clazz,
			final String serverUri) {
		return getClientService(clazz, serverUri);
	}

	private final <T> T getClientService(final Class<T> clazz,
			final String serverUri) {
		logger.info("Generating REST resource proxy for: " + clazz.getName());
		return ProxyFactory.create(clazz, serverUri);
	}

	/**
	 * Gets the entity from response.
	 * 
	 * @param <T>
	 *            the Entity type
	 * @param <EX>
	 *            the Exception type to throw if parsing fails
	 * @param clientResponse
	 *            the client response
	 * @param exceptionClazz
	 *            the exception class to throw if parsing fails
	 * @return the entity
	 * @throws EX
	 *             a subclass of AlfrescoServiceException
	 */
	protected <T, EX extends AlfrescoServiceException> T parseEntityFromResponse(
			ClientResponse<T> clientResponse, Class<EX> exceptionClazz)
			throws EX {
		T entity = null;
		try {
			validateResponseSuccess(clientResponse, exceptionClazz);
			entity = clientResponse.getEntity();
		} finally {
			clientResponse.releaseConnection();
		}
		return entity;
	}

	/**
	 * Validate response success.
	 * 
	 * @param <EX>
	 *            the generic type
	 * @param clientResponse
	 *            the client response
	 * @param exceptionClazz
	 *            the exception clazz
	 * @throws EX
	 *             the eX
	 */
	protected <EX extends AlfrescoServiceException> void validateResponseSuccess(
			ClientResponse<?> clientResponse, Class<EX> exceptionClazz)
			throws EX {
		Family statusFamily = getStatusFamily(clientResponse);
		if (statusFamily != Family.SUCCESSFUL) {
			Object errorResponse = null;
			Exception cause = null;
			try {
//				String error = clientResponse.getEntity(String.class);
				errorResponse = clientResponse.getEntity(ErrorResponse.class);
				if (errorResponse == null) {
					errorResponse = clientResponse.getEntity(String.class);
				}
			} catch (ClientResponseFailure responseFailure) {
				cause = responseFailure;
			}
			EX exception = null;
			String genericErrorMsg = "Error occurred while creating new instance of exception class of type "
					+ exceptionClazz.getCanonicalName()
					+ " to throw the following error:\n" + errorResponse;
			try {
				if (cause != null) {
					exception = exceptionClazz.getConstructor(String.class,
							Throwable.class).newInstance(cause.getMessage(),
							cause);
				} else {
					exception = exceptionClazz.getConstructor(String.class)
							.newInstance(
									"Request processing failed.\n HTTP Status: "
											+ clientResponse
													.getResponseStatus()
											+ "\n HTTP Status Code:"
											+ clientResponse.getStatus()
											+ " \n Error:" + errorResponse);
				}
				if (exception != null && errorResponse instanceof ErrorResponse) {
					exception.setErrorResponse((ErrorResponse) errorResponse);
				}
			} catch (IllegalArgumentException iae) {
				throw new IllegalStateException(genericErrorMsg, iae);
			} catch (SecurityException se) {
				throw new IllegalStateException(genericErrorMsg, se);
			} catch (InstantiationException ie) {
				throw new IllegalStateException(genericErrorMsg, ie);
			} catch (IllegalAccessException iacce) {
				throw new IllegalStateException(genericErrorMsg, iacce);
			} catch (InvocationTargetException ite) {
				throw new IllegalStateException(genericErrorMsg, ite);
			} catch (NoSuchMethodException nsme) {
				throw new IllegalStateException(genericErrorMsg, nsme);
			}
			throw exception;
		}
	}

	private Family getStatusFamily(ClientResponse<?> clientResponse) {
		Family statusFamily = null;
		if (clientResponse.getResponseStatus() == null) {
			int statusCode = clientResponse.getStatus();
			statusFamily = getStatusFamily(statusCode);
		} else {
			statusFamily = clientResponse.getResponseStatus().getFamily();
		}
		return statusFamily;
	}

	private Family getStatusFamily(int statusCode) {
		Family statusFamily;
		switch (statusCode / 100) {
		case 1:
			statusFamily = Family.INFORMATIONAL;
			break;
		case 2:
			statusFamily = Family.SUCCESSFUL;
			break;
		case 3:
			statusFamily = Family.REDIRECTION;
			break;
		case 4:
			statusFamily = Family.CLIENT_ERROR;
			break;
		case 5:
			statusFamily = Family.SERVER_ERROR;
			break;
		default:
			statusFamily = Family.OTHER;
			break;
		}
		return statusFamily;
	}

}
