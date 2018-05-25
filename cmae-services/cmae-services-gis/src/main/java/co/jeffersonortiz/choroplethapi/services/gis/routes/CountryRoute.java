package co.jeffersonortiz.choroplethapi.services.gis.routes;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import co.jeffersonortiz.choroplethapi.dto.ShapeDto;
import co.jeffersonortiz.choroplethapi.entity.Shape;
import co.jeffersonortiz.choroplethapi.services.gis.delegate.GisDelegate;
import co.jeffersonortiz.choroplethapi.util.rest.helper.RestHelper;
import co.jeffersonortiz.choroplethapi.util.rest.model.MessageResponseRest;

@RequestScoped
@Path("country")
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
public class CountryRoute {

	@Inject
	private RestHelper helper;
	
	@Inject
	private GisDelegate delegate;
	
	@GET
	public Response getAll() {
		List<ShapeDto> response = delegate.getAllWord();
		return helper.responseSucessBuilder(Response.Status.OK, MessageResponseRest.TYPE_SUCCESS, Shape.class.getSimpleName(), response);
	}
}
