package uk.co.techblue.alfresco.resource;

import uk.co.techblue.alfresco.client.Resource;
import uk.co.techblue.alfresco.client.Service;

public abstract class AbstractService<RT extends Resource> extends Service<RT> {

	protected final String authTicket;

	public AbstractService(String restBaseUri, String authTicket) {
		super(restBaseUri);
		this.authTicket = authTicket;
	}
	
}
