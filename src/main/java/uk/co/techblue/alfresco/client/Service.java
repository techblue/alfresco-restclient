/*******************************************************************************
 * Copyright 2012 Technology Blueprint Ltd
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package uk.co.techblue.alfresco.client;

import java.lang.reflect.InvocationTargetException;

import javax.ws.rs.core.Response.Status.Family;

import org.jboss.resteasy.client.ClientResponse;
import org.jboss.resteasy.client.ClientResponseFailure;
import org.jboss.resteasy.client.ProxyFactory;
import org.jboss.resteasy.logging.Logger;
import org.jboss.resteasy.plugins.providers.RegisterBuiltin;
import org.jboss.resteasy.spi.ResteasyProviderFactory;

import uk.co.techblue.alfresco.dto.error.ServiceResponse;
import uk.co.techblue.alfresco.exception.AlfrescoServiceException;
import uk.co.techblue.alfresco.resteasy.providers.DocumentContentProvider;
import uk.co.techblue.alfresco.resteasy.providers.HtmlBodyReader;
import uk.co.techblue.alfresco.resteasy.providers.MultipartFormAnnotationWriter;

/**
 * The Class Service.
 * 
 * @param <RT> the generic type
 */
public abstract class Service<RT extends Resource> {

    /** The logger. */
    private static final Logger logger = Logger.getLogger(Service.class);

    /** The rest base uri. */
    protected final String restBaseUri;

    /** The resource proxy. */
    protected final RT resourceProxy;

    static {
        initializeProviderFactory();
    }

    private static void initializeProviderFactory() {
        try {
            final ResteasyProviderFactory providerFactory = ResteasyProviderFactory.getInstance();
            registerResteasyProvider(providerFactory, DocumentContentProvider.class);
            registerResteasyProvider(providerFactory, HtmlBodyReader.class);
            registerResteasyProvider(providerFactory, MultipartFormAnnotationWriter.class);
            RegisterBuiltin.register(providerFactory);
        } catch (final Exception e) {
            logger.error("Error occurred while registering custom resteasy providers", e);
        }
    }

    private static void registerResteasyProvider(final ResteasyProviderFactory providerFactory, final Class<?> providerClass) {
        logger.info("Registering custom Provider with Resteasy:" + providerClass.getName() + " ...");
        providerFactory.registerProvider(providerClass);
        logger.info("Registered custom Provider with Resteasy:" + providerClass.getName());
    }

    /**
     * Instantiates a new service.
     * 
     * @param restBaseUri the rest base uri
     */
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
     * @param <T> the generic resource type
     * @param clazz the resource class
     * @param serverUri the server uri
     * @return the resource proxy
     */
    protected <T> T getResourceProxy(final Class<T> clazz,
        final String serverUri) {
        return getClientService(clazz, serverUri);
    }

    /**
     * Gets the client service.
     * 
     * @param <T> the generic type
     * @param clazz the clazz
     * @param serverUri the server uri
     * @return the client service
     */
    private final <T> T getClientService(final Class<T> clazz,
        final String serverUri) {
        logger.info("Generating REST resource proxy for: " + clazz.getName());
        return ProxyFactory.create(clazz, serverUri);
    }

    /**
     * Gets the entity from response.
     * 
     * @param <T> the Entity type
     * @param <EX> the Exception type to throw if parsing fails
     * @param clientResponse the client response
     * @param exceptionClazz the exception class to throw if parsing fails
     * @return the entity
     * @throws EX a subclass of AlfrescoServiceException
     */
    protected <T, EX extends AlfrescoServiceException> T parseEntityFromResponse(
        final ClientResponse<T> clientResponse, final Class<EX> exceptionClazz)
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
     * @param <EX> the generic type
     * @param clientResponse the client response
     * @param exceptionClazz the exception clazz
     * @throws EX the eX
     */
    protected <EX extends AlfrescoServiceException> void validateResponseSuccess(
        final ClientResponse<?> clientResponse, final Class<EX> exceptionClazz)
        throws EX {
        final Family statusFamily = getStatusFamily(clientResponse);
        if (statusFamily != Family.SUCCESSFUL) {
            Object errorResponse = null;
            Exception cause = null;
            try {
                // String error = clientResponse.getEntity(String.class);
                errorResponse = clientResponse.getEntity(ServiceResponse.class);
                if (errorResponse == null) {
                    errorResponse = clientResponse.getEntity(String.class);
                }
            } catch (final ClientResponseFailure clientResponseFailure) {
                cause = clientResponseFailure;
            }
            EX exception = null;
            final String genericErrorMsg = "Error occurred while creating new instance of exception class of type "
                + exceptionClazz.getCanonicalName()
                + " to throw the following error:\n" + errorResponse;
            try {
                if (cause != null) {
                    exception = exceptionClazz.getConstructor(String.class,
                        Throwable.class).newInstance("An error occurred while fetching entity from HTTP response:\n" + errorResponse,
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
                if (exception != null && errorResponse instanceof ServiceResponse) {
                    exception.setErrorResponse((ServiceResponse) errorResponse);
                }
            } catch (final IllegalArgumentException illegalArgumentException) {
                throw new IllegalStateException(genericErrorMsg, illegalArgumentException);
            } catch (final SecurityException securityException) {
                throw new IllegalStateException(genericErrorMsg, securityException);
            } catch (final InstantiationException instantiationException) {
                throw new IllegalStateException(genericErrorMsg, instantiationException);
            } catch (final IllegalAccessException illegalAccessException) {
                throw new IllegalStateException(genericErrorMsg, illegalAccessException);
            } catch (final InvocationTargetException invocationTargetException) {
                throw new IllegalStateException(genericErrorMsg, invocationTargetException);
            } catch (final NoSuchMethodException noSuchMethodException) {
                throw new IllegalStateException(genericErrorMsg, noSuchMethodException);
            }
            throw exception;
        }
    }

    /**
     * Gets the status family.
     * 
     * @param clientResponse the client response
     * @return the status family
     */
    private Family getStatusFamily(final ClientResponse<?> clientResponse) {
        Family statusFamily = null;
        if (clientResponse.getResponseStatus() == null) {
            final int statusCode = clientResponse.getStatus();
            statusFamily = getStatusFamily(statusCode);
        } else {
            statusFamily = clientResponse.getResponseStatus().getFamily();
        }
        return statusFamily;
    }

    /**
     * Gets the status family.
     * 
     * @param statusCode the status code
     * @return the status family
     */
    private Family getStatusFamily(final int statusCode) {
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
