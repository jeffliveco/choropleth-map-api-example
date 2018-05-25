package co.jeffersonortiz.choroplethapi.util.rest.locator;

import java.util.HashMap;
import java.util.Map;

import co.jeffersonortiz.choroplethapi.business.Service;

public class ServiceCache {

	private final Map<String, Service> serviceCacheList;

	public ServiceCache() {
		serviceCacheList = new HashMap<>();
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
