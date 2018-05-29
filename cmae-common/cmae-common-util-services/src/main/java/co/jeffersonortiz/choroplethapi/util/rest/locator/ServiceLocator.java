package co.jeffersonortiz.choroplethapi.util.rest.locator;

import java.util.Properties;
import java.util.logging.Logger;

import javax.enterprise.inject.Default;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import co.jeffersonortiz.choroplethapi.business.Service;
import co.jeffersonortiz.choroplethapi.constants.remote.RemoteAttributes;
import co.jeffersonortiz.choroplethapi.constants.remote.RemoteError;
import co.jeffersonortiz.choroplethapi.constants.remote.RemoteProperties;
import co.jeffersonortiz.choroplethapi.exception.remote.RemoteJNDIException;

/**
 * 
 * @author <a href="mailto:me@jeffersonortiz.com">Jefferson Ortiz Quiroga</a>
 * @version 1.0
 */
@Default
public class ServiceLocator {
	
	private Logger logger = Logger.getLogger(ServiceLocator.class.getName());
	
	private ServiceCache serviceCache;
	private static RemoteProperties properties;
	
	public ServiceLocator() {
		logger.info("constructor()");
		serviceCache = ServiceCache.getInstance();
		properties = RemoteProperties.getInstance();
	}

	/**
	 * 
	 * @param serviceJndiName
	 * @return
	 */
	public Service getService(String serviceJndiName) throws RemoteJNDIException {
		Service serviceObj = serviceCache.getService(serviceJndiName);
		if (serviceObj != null) {
			return serviceObj;
		} else {
			try {
				Context ctx = this.createInitialContext();
				serviceObj = (Service) ctx.lookup(serviceJndiName);
			} catch(NamingException ex) {
				logger.info("Error->invocate('"+ serviceJndiName +"')");
				throw new RemoteJNDIException(RemoteError.SERVICE_NOT_FOUND.message(), ex);
			}
			
			if (serviceObj != null) {
				serviceCache.addService(serviceObj, serviceJndiName);
			}
			return serviceObj;
		}
	}
	
	/**
	 * 
	 * @return
	 * @throws NamingException
	 */
	private Context createInitialContext() throws NamingException {
        Properties jndiProperties = new Properties();
        jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, properties.getValue(RemoteAttributes.JNDI_INITIAL_FACTORY));
        jndiProperties.put(Context.PROVIDER_URL, properties.getValue(RemoteAttributes.JNDI_URL_SERVER));
        jndiProperties.put("jboss.naming.client.ejb.context", properties.getValue(RemoteAttributes.JNDI_CLIENT_EJB_CONTEXT));
        jndiProperties.put(Context.URL_PKG_PREFIXES, properties.getValue(RemoteAttributes.JNDI_PKG_PREFIXES));
        jndiProperties.put("jboss.naming.client.connect.options.org.xnio.Options.SASL_POLICY_NOPLAINTEXT", properties.getValue(RemoteAttributes.JNDI_SASL_POLICY));
        
        return new InitialContext(jndiProperties);
    }
}
