package CucumberTesting.AutomationSalesforceTesting.salesforce;

import com.sforce.soap.enterprise.Connector;
import com.sforce.soap.enterprise.EnterpriseConnection;
import com.sforce.ws.ConnectionException;
import com.sforce.ws.ConnectorConfig;

import CucumberTesting.AutomationSalesforceTesting.util.*;

public class SalesforceAuthentication {
	protected String username;
	protected String password;
	protected String authEndPoint;
	protected PropertyReader reader;
	protected ConnectorConfig config;
	public final String API_VERSION = "40.0";
	
	
	public SalesforceAuthentication(){
		reader = new PropertyReader();
		//Authenticate User to perform operations
		if(config==null)
			authenticate();
	}
	
	public void authenticate(){
		config = new ConnectorConfig();
	    config.setUsername(reader.readProperty("username"));
	    config.setPassword(reader.readProperty("password"));
	    config.setAuthEndpoint(reader.readProperty("loginurl"));
	    try {
	      EnterpriseConnection connection = Connector.newConnection(config);
	    } catch (ConnectionException e1) {
	        e1.printStackTrace();
	    }  
	}
	
	public String getAuthEndPoint(){
		return config.getAuthEndpoint();
	}
	
	public String getServiceEndPoint(){
		return config.getServiceEndpoint();
	}
	
	public String getSessionId(){
		return config.getSessionId();
	}
	
	public String getBaseUrl(){
		return config.getServiceEndpoint().substring(0,config.getServiceEndpoint().indexOf("services"))+
				"/secur/frontdoor.jsp?sid="+getSessionId();
	}
	
	
	
}
