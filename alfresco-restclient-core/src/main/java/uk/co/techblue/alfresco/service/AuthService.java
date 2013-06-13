package uk.co.techblue.alfresco.service;

import org.jboss.resteasy.client.ClientResponse;

import uk.co.techblue.alfresco.client.Service;
import uk.co.techblue.alfresco.dto.AuthResponse;
import uk.co.techblue.alfresco.dto.Credentials;
import uk.co.techblue.alfresco.exception.AuthenticationException;
import uk.co.techblue.alfresco.resource.AuthResource;


public class AuthService extends Service<AuthResource> {

	protected final Credentials credentials;
	
	public AuthService(String restBaseUri, Credentials credentials) {
		super(restBaseUri);
		this.credentials = credentials;
	}

	@Override
	protected Class<AuthResource> getResourceClass() {
		return AuthResource.class;
	}
	
	public AuthResponse login() throws AuthenticationException {
		ClientResponse<AuthResponse> authResponse = resourceProxy.login(credentials);
		return parseEntityFromResponse(authResponse, AuthenticationException.class);
	}

}
