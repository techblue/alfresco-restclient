package uk.co.techblue.alfresco.client.test;

import uk.co.techblue.alfresco.dto.AuthResponse;
import uk.co.techblue.alfresco.dto.Credentials;
import uk.co.techblue.alfresco.exception.AuthenticationException;
import uk.co.techblue.alfresco.service.AuthService;

public class AlfrescoServiceTest {

	private static final String BASE_URL = "http://192.168.100.106:8080";
	
	public static void main(String[] args) {
		testLogin(getCredentials());
	}

	private static void testLogin(Credentials credentials) {
		AuthService authService = new AuthService(BASE_URL, credentials);
		try {
			AuthResponse token = authService.login();
			System.out.println("Auth Token: "+token);
		} catch (AuthenticationException e) {
			e.printStackTrace();
		}
	}

	private static Credentials getCredentials() {
		return new Credentials("admin", "admin");
	}
}
