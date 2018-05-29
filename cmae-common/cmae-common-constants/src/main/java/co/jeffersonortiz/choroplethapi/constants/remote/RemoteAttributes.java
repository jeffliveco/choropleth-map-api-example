package co.jeffersonortiz.choroplethapi.constants.remote;

/**
 * 
 * @author <a href="mailto:me@jeffersonortiz.com">Jefferson Ortiz Quiroga</a>
 * @version 1.0
 */
public enum RemoteAttributes {
	// SERVICE JNDI
	JNDI_INITIAL_FACTORY ("application.remote.jndi.initial.factory"),
	JNDI_URL_SERVER ("application.remote.jndi.url.server"),
	JNDI_CLIENT_EJB_CONTEXT ("application.remote.jndi.client.ejb.context"),
	JNDI_PKG_PREFIXES ("application.remote.jndi.url.pkg.prefixes"),
	JNDI_SASL_POLICY ("application.remote.jndi.sasl.policy"),
	// EJB
	EJB_GIS_APP ("application.remote.ejb.gis.app"),
	EJB_GIS_MODULE ("application.remote.ejb.gis.module"),
	EJB_GIS_NAME ("application.remote.ejb.gis.name"),
	EJB_GIS_INTERFACE ("application.remote.ejb.gis.interface");
	
	private final String value;
	
	RemoteAttributes (String value) {
		this.value = value;
	}
	
	public String value() { return value; }	
}
