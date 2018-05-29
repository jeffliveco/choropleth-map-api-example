package co.jeffersonortiz.choroplethapi.util.rest.locator;

import java.util.HashMap;
import java.util.Map;

import co.jeffersonortiz.choroplethapi.business.Service;

/**
 * 
 * @author <a href="mailto:me@jeffersonortiz.com">Jefferson Ortiz Quiroga</a>
 * @version 1.0
 */
public class ServiceCache {

	private static ServiceCache instance;
	private final Map<String, Service> serviceCacheList;

	public ServiceCache() {
		serviceCacheList = new HashMap<>();
	}
	
	/**
	 * 
	 * @return ServiceCache
	 */
	public static ServiceCache getInstance() {
		if (instance == null) {
			instance = new ServiceCache();
		}
		return instance;
	}

	public Service getService(String serviceName) {
		Service cachedService = null;
		for (String serviceJndiName : serviceCacheList.keySet()) {
			if (serviceJndiName.equals(serviceName)) {
				cachedService = serviceCacheList.get(serviceJndiName);
			}
		}
		return cachedService;
	}
	
	public void addService(Service newService, String name) {
		serviceCacheList.put(name, newService);
	}
}
