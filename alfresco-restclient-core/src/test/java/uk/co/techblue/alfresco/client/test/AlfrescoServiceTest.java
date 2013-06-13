package uk.co.techblue.alfresco.client.test;

import uk.co.techblue.alfresco.dto.AuthResponse;
import uk.co.techblue.alfresco.dto.Credentials;
import uk.co.techblue.alfresco.exception.AuthenticationException;
import uk.co.techblue.alfresco.exception.UserException;
import uk.co.techblue.alfresco.service.AuthService;
import uk.co.techblue.alfresco.service.UserService;

public class AlfrescoServiceTest {

	private static final String BASE_URL = "http://192.168.100.106:8080";
	private static final String AUTH_TICKET = "TICKET_936a073854757fc10fb4e55f82752ce78710e04c";
	
	public static void main(String[] args) {
//		testLogin(getCredentials());
//		testGetUsers();
		testGetUser();
	}

	private static void testGetUser() {
		UserService userService = new UserService(BASE_URL, AUTH_TICKET);
		try {
			System.out.println(userService.getUser("admin"));
		} catch (UserException e) {
			e.printStackTrace();
		}
	}

	private static void testGetUsers() {
		UserService userService = new UserService(BASE_URL, AUTH_TICKET);
		try {
			System.out.println(userService.getUsers("A", 2));
		} catch (UserException e) {
			e.printStackTrace();
		}
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
