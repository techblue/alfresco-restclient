package uk.co.techblue.alfresco.commons;

public interface AlfrescoConstants {

	String RESOURCE_CONTEXT_BASE_PATH = "/alfresco/service/api/";
	String AUTH_TICKET_PARAM_NAME = "alf_ticket";
	String DEFAULT_STORE_TYPE = "workspace";
	String DEFAULT_STORE_ID = "SpacesStore";
	String DEFAULT_STORE = DEFAULT_STORE_TYPE+"://"+DEFAULT_STORE_ID;
}
