package co.jeffersonortiz.choroplethapi.util.rest.locator;

import java.util.Properties;
import java.util.logging.Logger;

import javax.enterprise.inject.Default;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import co.jeffersonortiz.choroplethapi.business.Service;

@Default
public class ServiceLocator {
	
	private Logger logger = Logger.getLogger(ServiceLocator.class.getName());
	
	public static String GIS_SERVICE_JNDI = "/cmae-build-gis-0.0.1-SNAPSHOT/co.jeffersonortiz.choroplethapi-cmae-business-gis-0.0.1-SNAPSHOT/GisFacade!co.jeffersonortiz.choroplethapi.business.gis.facade.GisFacadeRemote";
	
	private ServiceCache serviceCache;

	public ServiceLocator() {
		logger.info("ServiceLocator->constructor()");
		serviceCache = new ServiceCache();
	}

	/**
	 * Fetch the service with the name param from the cache first, if no service is
	 * found, lookup the service from the {@link InitContext} and then add the newly
	 * created service into the cache map for future requests.
	 *
	 * @param serviceJndiName a string
	 * @return {@link Service}
	 */
	public Service getService(String serviceJndiName) {
		Service serviceObj = serviceCache.getService(serviceJndiName);
		if (serviceObj != null) {
			return serviceObj;
		} else {
			try {
				Context ctx = this.createInitialContext();
				serviceObj = (Service) ctx.lookup(serviceJndiName);
			} catch(NamingException ex) {
				ex.printStackTrace();
			}
			
			if (serviceObj != null) { // Only cache a service if it actually exists
				serviceCache.addService(serviceObj, serviceJndiName);
			}
			return serviceObj;
		}
	}
	
	private Context createInitialContext() throws NamingException {
        Properties jndiProperties = new Properties();
        jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
        jndiProperties.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
        jndiProperties.put("jboss.naming.client.ejb.context", true);
        jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
        jndiProperties.put("jboss.naming.client.connect.options.org.xnio.Options.SASL_POLICY_NOPLAINTEXT", "false");
        
        return new InitialContext(jndiProperties);
    }
}
