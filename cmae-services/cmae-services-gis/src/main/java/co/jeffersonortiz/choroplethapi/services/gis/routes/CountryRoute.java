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

import com.google.gson.Gson;

import co.jeffersonortiz.choroplethapi.dto.ShapeCollectionDto;
import co.jeffersonortiz.choroplethapi.dto.ShapeDto;
import co.jeffersonortiz.choroplethapi.services.gis.delegate.GisDelegate;
import co.jeffersonortiz.choroplethapi.util.rest.helper.RestHelper;

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
	public Response getAll() {
		List<ShapeDto> dataList = delegate.getAllWord();
		ShapeCollectionDto response = new ShapeCollectionDto();
		response.setFeatures(dataList);
		
		Gson json = new Gson();
		
		logger.info("ShapeCollectionDto " + json.toJson(response));
		
		//return helper.responseSucessBuilder(Response.Status.OK, MessageResponseRest.TYPE_SUCCESS, Shape.class.getSimpleName(), response);
		return Response.status(Response.Status.OK).entity(json.toJson(response)).header("Access-Control-Allow-Origin", "*").build();
	}
}
