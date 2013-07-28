package uk.co.techblue.alfresco.client.test;

import java.util.ArrayList;
import java.util.List;

import javax.activation.FileDataSource;

import uk.co.techblue.alfresco.dto.AuthResponse;
import uk.co.techblue.alfresco.dto.Credentials;
import uk.co.techblue.alfresco.dto.common.GroupSorter;
import uk.co.techblue.alfresco.dto.content.ContentUploadForm;
import uk.co.techblue.alfresco.dto.content.SearchRequest;
import uk.co.techblue.alfresco.dto.user.AddUser;
import uk.co.techblue.alfresco.dto.user.AuthorityQuery;
import uk.co.techblue.alfresco.dto.user.GroupQuery;
import uk.co.techblue.alfresco.dto.user.User;
import uk.co.techblue.alfresco.exception.AuthenticationException;
import uk.co.techblue.alfresco.exception.ContentException;
import uk.co.techblue.alfresco.exception.GroupException;
import uk.co.techblue.alfresco.exception.SearchException;
import uk.co.techblue.alfresco.exception.UserException;
import uk.co.techblue.alfresco.service.AuthService;
import uk.co.techblue.alfresco.service.ContentService;
import uk.co.techblue.alfresco.service.GroupService;
import uk.co.techblue.alfresco.service.UserService;

public class AlfrescoServiceTest {

	private static final String BASE_URL = "http://192.168.100.106:8080";
	private static final String AUTH_TICKET = "TICKET_b434309f77e23789c784e1d19d9aae7447a4892b";

	public static void main(String[] args) {
		// testLogin(getCredentials());
		// testGetUsers();
		// testGetGroups();
		// testGetGroup();
		// testGetChildAuthorities();
		// testGetParentAuthorities();
		// testDeleteUser();
		// testCreateUser();
		// testGetUser();
		// testChangeUserPassword();
		// testUpdateUser();
		// testGetUser();
//		testGetContent();
	    testAdvancedSearch();
//	    testUploadContent();
	}

	private static void testAdvancedSearch() {
	    ContentService contentService = new ContentService(BASE_URL,
                AUTH_TICKET);
	  //EVERYTHING EXCEPT FOR PROPCO CONTENT MODEL
//	    SearchRequest searchReuqest = new SearchRequest("@cm\\:lastName:\"Arora\"");
	    //FOR PROPCO CONTENT MODEL
//	    SearchRequest searchReuqest = new SearchRequest("cm:lastName=\"Jain\"");
	    SearchRequest searchReuqest = new SearchRequest("+PATH:\"//cm:QA//*\" +@cm\\:lastName:\"Jain\"");
	    try {
            System.out.println("RESPONSE:"+contentService.search(searchReuqest));
        } catch (SearchException e) {
            e.printStackTrace();
        }
	    
    }

    private static void testUploadContent() {
	    ContentService contentService = new ContentService(BASE_URL,
                AUTH_TICKET);
	    ContentUploadForm uploadMetadata = new ContentUploadForm();
//	    FileDataSource fileDataSource =  new FileDataSource("C:\\Users\\Public\\Pictures\\Sample Pictures\\Desert.jpg");
	    FileDataSource fileDataSource =  new FileDataSource("D:\\ImportantStuff\\Documents\\Team Evaluation\\Team_Evaluation_Form_Template.pdf");
	    uploadMetadata.setFileData(fileDataSource);
	    uploadMetadata.setDestination("workspace://SpacesStore/2d0948ba-c907-436f-a7a6-9d00aeb031c0");
//	    uploadMetadata.setContainerId("documentLibrary");
//	    uploadMetadata.setUploadDirectory("/Company Home");
//	    uploadMetadata.setSiteId("swsdp");
	    uploadMetadata.setFileName("Team Evaluation Form_Template.pdf");
	    uploadMetadata.setDescription("Test REST upload");
	    
        try {
            System.out.println(contentService.uploadDocument(uploadMetadata));
        } catch (ContentException e) {
            e.printStackTrace();
        }
    }

    private static void testGetContent() {
		ContentService contentService = new ContentService(BASE_URL,
				AUTH_TICKET);
		try {
			//ba90e398-dc4f-4de8-a97d-e30669ebee6c DOCX
			//27eb6ac6-abb3-4e31-be96-a97140ff641a DOC
			System.out.println(contentService.getNodeContent("27eb6ac6-abb3-4e31-be96-a97140ff641a"));
		} catch (ContentException e) {
			e.printStackTrace();
		}
	}

	private static void testUpdateUser() {
		UserService userService = new UserService(BASE_URL, AUTH_TICKET);
		User user = new User();
		user.setCompanyaddress1("73, Sector 5");
		user.setCompanyaddress2("Manesar");
		user.setOrganization("Techblue Software");
		user.setMobile("9212641104");
		try {
			System.out.println(userService.updateUser("ajay", user));
		} catch (UserException e) {
			e.printStackTrace();
		}
	}

	private static void testChangeUserPassword() {
		UserService userService = new UserService(BASE_URL, AUTH_TICKET);
		try {
			userService.changePassword("ajay", "ajay", "ajayd");
		} catch (UserException e) {
			e.printStackTrace();
		}
	}

	private static void testDeleteUser() {
		UserService userService = new UserService(BASE_URL, AUTH_TICKET);
		try {
			userService.deleteUser("ajay");
		} catch (UserException e) {
			e.printStackTrace();
		}
	}

	private static void testCreateUser() {
		UserService userService = new UserService(BASE_URL, AUTH_TICKET);
		AddUser user = getMockUser();
		try {
			System.out.println(userService.createUser(user));
		} catch (UserException e) {
			e.printStackTrace();
		}
	}

	private static AddUser getMockUser() {
		AddUser user = new AddUser();
		user.setUserName("ajay");
		user.setPassword("ajay");
		user.setFirstName("Ajay");
		user.setLastName("Deshwal");
		user.setJobtitle("Software Engineer");
		user.setEmail("ajay.deshwal@techblue.co.uk");
		user.setQuota(3);
		List<String> groups = new ArrayList<String>();
		groups.add("GROUP_ALFRESCO_ADMINISTRATORS");
		user.setGroups(groups);
		return user;
	}

	private static void testGetParentAuthorities() {
		GroupService userService = new GroupService(BASE_URL, AUTH_TICKET);
		try {
			AuthorityQuery authorityQuery = new AuthorityQuery();
			authorityQuery.setSortBy(GroupSorter.authorityName);
			System.out.println(userService.getParentAuthorities(
					"EMAIL_CONTRIBUTORS", authorityQuery));
		} catch (GroupException e) {
			e.printStackTrace();
		}
	}

	private static void testGetChildAuthorities() {
		GroupService userService = new GroupService(BASE_URL, AUTH_TICKET);
		try {
			AuthorityQuery authorityQuery = new AuthorityQuery();
			authorityQuery.setSortBy(GroupSorter.authorityName);
			System.out.println(userService.getChildAuthorities(
					"ALFRESCO_ADMINISTRATORS", authorityQuery));
		} catch (GroupException e) {
			e.printStackTrace();
		}
	}

	private static void testGetGroup() {
		GroupService userService = new GroupService(BASE_URL, AUTH_TICKET);
		try {
			System.out.println(userService.getGroup("ALFRESCO_ADMINISTRATORS"));
		} catch (GroupException e) {
			e.printStackTrace();
		}
	}

	private static void testGetGroups() {
		GroupService userService = new GroupService(BASE_URL, AUTH_TICKET);
		try {
			GroupQuery groupQuery = new GroupQuery();
			System.out.println(userService.getGroups(groupQuery));
		} catch (GroupException e) {
			e.printStackTrace();
		}
	}

	private static void testGetUser() {
		UserService userService = new UserService(BASE_URL, AUTH_TICKET);
		try {
			System.out.println(userService.getUser("ajay"));
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
			System.out.println("Auth Token: " + token);
		} catch (AuthenticationException e) {
			e.printStackTrace();
		}
	}

	private static Credentials getCredentials() {
		return new Credentials("admin", "admin");
	}
}
