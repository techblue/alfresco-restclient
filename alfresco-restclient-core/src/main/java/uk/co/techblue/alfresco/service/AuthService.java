package uk.co.techblue.alfresco.service;

import org.jboss.resteasy.client.ClientResponse;

import uk.co.techblue.alfresco.client.Service;
import uk.co.techblue.alfresco.dto.AuthResponse;
import uk.co.techblue.alfresco.dto.Credentials;
import uk.co.techblue.alfresco.dto.error.ServiceResponse;
import uk.co.techblue.alfresco.exception.AuthenticationException;
import uk.co.techblue.alfresco.resource.AuthResource;


public class AuthService extends Service<AuthResource> {

	protected final Credentials credentials;
	
	public AuthService(String restBaseUri, Credentials credentials) {
		super(restBaseUri);
		this.credentials = credentials;
	}
	
	public AuthService(String restBaseUri) {
		super(restBaseUri);
		this.credentials = null;
	}
	
	@Override
	protected Class<AuthResource> getResourceClass() {
		return AuthResource.class;
	}
	
	public AuthResponse login() throws AuthenticationException {
		ClientResponse<AuthResponse> authResponse = resourceProxy.login(credentials);
		return parseEntityFromResponse(authResponse, AuthenticationException.class);
	}
	
	public ServiceResponse logout(String authTicket) throws AuthenticationException {
		ClientResponse<ServiceResponse> authResponse = resourceProxy.logout(authTicket, authTicket, "json");
		return parseEntityFromResponse(authResponse, AuthenticationException.class);
	}

}
