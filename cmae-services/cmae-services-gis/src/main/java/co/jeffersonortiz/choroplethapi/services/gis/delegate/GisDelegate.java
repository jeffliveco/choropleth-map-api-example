package co.jeffersonortiz.choroplethapi.services.gis.delegate;

import java.util.List;
import java.util.logging.Logger;

import javax.enterprise.inject.Default;

import co.jeffersonortiz.choroplethapi.business.gis.facade.GisFacadeRemote;
import co.jeffersonortiz.choroplethapi.dto.ShapeDto;
import co.jeffersonortiz.choroplethapi.exception.business.BusinessException;
import co.jeffersonortiz.choroplethapi.util.rest.locator.ServiceLocator;

@Default
public class GisDelegate {

	private Logger logger = Logger.getLogger(GisDelegate.class.getName());
	
	private ServiceLocator locator;
	private GisFacadeRemote gisService;
	
	public GisDelegate() {
		locator = new ServiceLocator();
		gisService = (GisFacadeRemote) locator.getService(ServiceLocator.GIS_SERVICE_JNDI);
		logger.info("service->" + gisService);
	}
	
	public List<ShapeDto> getAllWord() {
		try {
			return gisService.getAllWord();
		} catch (BusinessException e) {
			e.printStackTrace();
			return null;
		}
	}

}
