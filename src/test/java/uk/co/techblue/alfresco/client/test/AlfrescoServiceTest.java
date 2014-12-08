package uk.co.techblue.alfresco.client.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.activation.FileDataSource;

import uk.co.techblue.alfresco.dto.AuthResponse;
import uk.co.techblue.alfresco.dto.Credentials;
import uk.co.techblue.alfresco.dto.common.GroupSorter;
import uk.co.techblue.alfresco.dto.content.ContentMetadata;
import uk.co.techblue.alfresco.dto.content.ContentUploadForm;
import uk.co.techblue.alfresco.dto.content.QueryResponseSorter;
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

	private static final String BASE_URL = "http://localhost:8080";
	private static final String AUTH_TICKET = "TICKET_6545adf481da58bb87490df0a7b75300d74921f5";

    public static void main(final String args[]) {
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
        // testGetContent();
        testAdvancedSearch();
        // testUploadContent();
        // testStoreMetadata();
    }

    private static void testStoreMetadata() {
        final ContentService contentService = new ContentService(BASE_URL,
            AUTH_TICKET);
        final ContentMetadata contentMetadata = new ContentMetadata();
        final Map<String, String> properties = new HashMap<String, String>();
        properties.put("author", "SavedbyWindowsInternetExplorer8");
        properties.put("originator", "SavedbyWindowsInternetExplorer8");
        properties.put("application-id", "44284");
        contentMetadata.setProperties(properties);
        ;
        try {
            contentService.storeNodeMetadata("7b08f922-d84b-4aeb-a44c-8743c4a9d0d0", contentMetadata);
        } catch (final ContentException e) {
            e.printStackTrace();
        }
    }

    private static void testAdvancedSearch() {
        final ContentService contentService = new ContentService(BASE_URL,
            AUTH_TICKET);
        // EVERYTHING EXCEPT FOR PROPCO CONTENT MODEL
        // SearchRequest searchReuqest = new SearchRequest("@cm\\:lastName:\"Arora\"");
        // FOR PROPCO CONTENT MODEL
        // SearchRequest searchReuqest = new SearchRequest("cm:lastName=\"Jain\"");
        // final SearchRequest searchReuqest = new SearchRequest("+PATH:\"//cm:QA//*\" +@cm\\:lastName:\"Jain\"");
        final SearchRequest searchReuqest = new SearchRequest("@barbon\\:application-id:44284");
        // final PagingConfig pagingConfig = new PagingConfig();
        // pagingConfig.setMaxItems(2);
        // pagingConfig.setSkipCount(5);
        final QueryResponseSorter responseSorter = new QueryResponseSorter();
        responseSorter.setColumnName("@cm:modified");
        final List<QueryResponseSorter> responseSorters = new ArrayList<QueryResponseSorter>();
        responseSorters.add(responseSorter);
        searchReuqest.setResponseSorters(responseSorters);
        // searchReuqest.setPagingConfig(pagingConfig);
        try {
            System.out.println("RESPONSE:" + contentService.search(searchReuqest));
        } catch (final SearchException e) {
            e.printStackTrace();
        }

    }

    private static void testUploadContent() {
        final ContentService contentService = new ContentService(BASE_URL,
            AUTH_TICKET);
        final ContentUploadForm uploadMetadata = new ContentUploadForm();
        final FileDataSource fileDataSource = new FileDataSource("C:\\Users\\Public\\Pictures\\Sample Pictures\\Desert.jpg");
        // FileDataSource fileDataSource = new FileDataSource("C:\\Users\\Public\\Pictures\\Sample Pictures\\Desert.jpg");
        uploadMetadata.setFileData(fileDataSource);
        uploadMetadata.setDestination("workspace://SpacesStore/a31a1771-fd57-4d78-a6b8-65372e50fdbc");
        // uploadMetadata.setContainerId("documentLibrary");
        // uploadMetadata.setUploadDirectory("/Company Home");
        // uploadMetadata.setSiteId("swsdp");
        uploadMetadata.setFileName("demo123.pdf");
        uploadMetadata.setDescription("Test REST upload");

        try {
            System.out.println(contentService.uploadDocument(uploadMetadata));
        } catch (final ContentException e) {
            e.printStackTrace();
        }
    }

    private static void testGetContent() {
        final ContentService contentService = new ContentService(BASE_URL,
            AUTH_TICKET);
        try {
            // ba90e398-dc4f-4de8-a97d-e30669ebee6c DOCX
            // 27eb6ac6-abb3-4e31-be96-a97140ff641a DOC
            System.out.println(contentService.getNodeContent("baf47bf6-0fa2-458e-b557-b38e3c2683fb"));
        } catch (final ContentException e) {
            e.printStackTrace();
        }
    }

    private static void testUpdateUser() {
        final UserService userService = new UserService(BASE_URL, AUTH_TICKET);
        final User user = new User();
        user.setCompanyaddress1("73, Sector 5");
        user.setCompanyaddress2("Manesar");
        user.setOrganization("Techblue Software");
        user.setMobile("9212641104");
        try {
            System.out.println(userService.updateUser("ajay", user));
        } catch (final UserException e) {
            e.printStackTrace();
        }
    }

    private static void testChangeUserPassword() {
        final UserService userService = new UserService(BASE_URL, AUTH_TICKET);
        try {
            userService.changePassword("ajay", "ajay", "ajayd");
        } catch (final UserException e) {
            e.printStackTrace();
        }
    }

    private static void testDeleteUser() {
        final UserService userService = new UserService(BASE_URL, AUTH_TICKET);
        try {
            userService.deleteUser("ajay");
        } catch (final UserException e) {
            e.printStackTrace();
        }
    }

    private static void testCreateUser() {
        final UserService userService = new UserService(BASE_URL, AUTH_TICKET);
        final AddUser user = getMockUser();
        try {
            System.out.println(userService.createUser(user));
        } catch (final UserException e) {
            e.printStackTrace();
        }
    }

    private static AddUser getMockUser() {
        final AddUser user = new AddUser();
        user.setUserName("ajay");
        user.setPassword("ajay");
        user.setFirstName("Ajay");
        user.setLastName("Deshwal");
        user.setJobtitle("Software Engineer");
        user.setEmail("ajay.deshwal@techblue.co.uk");
        user.setQuota(3);
        final List<String> groups = new ArrayList<String>();
        groups.add("GROUP_ALFRESCO_ADMINISTRATORS");
        user.setGroups(groups);
        return user;
    }

    private static void testGetParentAuthorities() {
        final GroupService userService = new GroupService(BASE_URL, AUTH_TICKET);
        try {
            final AuthorityQuery authorityQuery = new AuthorityQuery();
            authorityQuery.setSortBy(GroupSorter.authorityName);
            System.out.println(userService.getParentAuthorities(
                "EMAIL_CONTRIBUTORS", authorityQuery));
        } catch (final GroupException e) {
            e.printStackTrace();
        }
    }

    private static void testGetChildAuthorities() {
        final GroupService userService = new GroupService(BASE_URL, AUTH_TICKET);
        try {
            final AuthorityQuery authorityQuery = new AuthorityQuery();
            authorityQuery.setSortBy(GroupSorter.authorityName);
            System.out.println(userService.getChildAuthorities(
                "ALFRESCO_ADMINISTRATORS", authorityQuery));
        } catch (final GroupException e) {
            e.printStackTrace();
        }
    }

    private static void testGetGroup() {
        final GroupService userService = new GroupService(BASE_URL, AUTH_TICKET);
        try {
            System.out.println(userService.getGroup("ALFRESCO_ADMINISTRATORS"));
        } catch (final GroupException e) {
            e.printStackTrace();
        }
    }

    private static void testGetGroups() {
        final GroupService userService = new GroupService(BASE_URL, AUTH_TICKET);
        try {
            final GroupQuery groupQuery = new GroupQuery();
            System.out.println(userService.getGroups(groupQuery));
        } catch (final GroupException e) {
            e.printStackTrace();
        }
    }

    private static void testGetUser() {
        final UserService userService = new UserService(BASE_URL, AUTH_TICKET);
        try {
            System.out.println(userService.getUser("ajay"));
        } catch (final UserException e) {
            e.printStackTrace();
        }
    }

    private static void testGetUsers() {
        final UserService userService = new UserService(BASE_URL, AUTH_TICKET);
        try {
            System.out.println(userService.getUsers("A", 2));
        } catch (final UserException e) {
            e.printStackTrace();
        }
    }

    private static void testLogin(final Credentials credentials) {
        final AuthService authService = new AuthService(BASE_URL, credentials);
        try {
            final AuthResponse token = authService.login();
            System.out.println("Auth Token: " + token);
        } catch (final AuthenticationException e) {
            e.printStackTrace();
        }
    }

	private static Credentials getCredentials() {
		return new Credentials("admin", "admin");
	}
}