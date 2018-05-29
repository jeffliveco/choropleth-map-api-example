package co.jeffersonortiz.choroplethapi.services.gis.routes;

import java.util.List;
import java.util.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import co.jeffersonortiz.choroplethapi.dto.ShapeCollectionDto;
import co.jeffersonortiz.choroplethapi.dto.ShapeDto;
import co.jeffersonortiz.choroplethapi.services.gis.delegate.GisDelegate;
import co.jeffersonortiz.choroplethapi.util.rest.helper.RestHelper;

/**
 * 
 * @author <a href="mailto:me@jeffersonortiz.com">Jefferson Ortiz Quiroga</a>
 * @version 1.0
 */
@RequestScoped
@Path("country")
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
public class CountryRoute {

	private final static Logger logger = Logger.getLogger(CountryRoute.class.getName());
	
	@Inject
	private RestHelper helper;
	
	@Inject
	private GisDelegate delegate;
	
	@GET
	@Path("geojson")
	public Response getAll() {
		logger.info("call->GetAll()");
		List<ShapeDto> dataList = delegate.getAllWord();
		ShapeCollectionDto response = new ShapeCollectionDto();
		response.setFeatures(dataList);
		return helper.responseSucessGeneric(response);
	}
}
