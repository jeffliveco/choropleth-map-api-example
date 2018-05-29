package co.jeffersonortiz.choroplethapi.services.gis.delegate;

import java.util.List;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

import co.jeffersonortiz.choroplethapi.business.gis.facade.GisFacadeRemote;
import co.jeffersonortiz.choroplethapi.constants.remote.RemoteProperties;
import co.jeffersonortiz.choroplethapi.dto.ShapeDto;
import co.jeffersonortiz.choroplethapi.exception.services.ServiceException;
import co.jeffersonortiz.choroplethapi.util.rest.locator.ServiceLocator;

/**
 * 
 * @author <a href="mailto:me@jeffersonortiz.com">Jefferson Ortiz Quiroga</a>
 * @version 1.0
 */
@Default
public class GisDelegate {

	private Logger logger = Logger.getLogger(GisDelegate.class.getName());
	
	@Inject
	private ServiceLocator locator;
	private GisFacadeRemote gisService;
	
	private static RemoteProperties properties;
	
	public GisDelegate() {
		logger.info("constructor()");
		properties = RemoteProperties.getInstance();
	}
	
	@PostConstruct
	public void init() {
		gisService = (GisFacadeRemote) locator.getService(properties.getGisJNDIService());
	}
	
	public List<ShapeDto> getAllWord() {
		try {
			return gisService.getAllWord();
		} catch (Exception e) {
			logger.info(e.getMessage());
			throw new ServiceException(e.getMessage());
		}
	}

}
