package co.jeffersonortiz.choroplethapi.constants.remote;

import co.jeffersonortiz.choroplethapi.util.constants.ApplicationProperties;

/**
 * 
 * @author <a href="mailto:me@jeffersonortiz.com">Jefferson Ortiz Quiroga</a>
 * @version 1.0
 */
public class RemoteProperties extends ApplicationProperties<RemoteAttributes> {

	private static RemoteProperties instance; 
	
	public RemoteProperties() {
		super("application.remote.properties");
	}
	
	public static RemoteProperties getInstance() {
		if (instance == null) {
			instance = new RemoteProperties();
		}
		return instance;
	}

	@Override
	public String getValue(RemoteAttributes attribute) {
		return getModuleAttributes().getProperty(attribute.value());
	}
	
	public String getGisJNDIService() {
		return "/" + getValue(RemoteAttributes.EJB_GIS_APP) + 
			"/" + getValue(RemoteAttributes.EJB_GIS_MODULE) + 
			"/" + getValue(RemoteAttributes.EJB_GIS_NAME) + 
			"!" + getValue(RemoteAttributes.EJB_GIS_INTERFACE);
	}
}
