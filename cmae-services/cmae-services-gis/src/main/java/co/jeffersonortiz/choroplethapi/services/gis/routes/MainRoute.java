package co.jeffersonortiz.choroplethapi.services.gis.routes;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import co.jeffersonortiz.choroplethapi.util.rest.helper.RestHelper;
import co.jeffersonortiz.choroplethapi.util.rest.model.MessageResponseRest;

@RequestScoped
@Path("")
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
public class MainRoute {
	
	@Inject
	private RestHelper helper;
	
	@GET
	public Response init() {
		return helper.responseSucessBuilder(MessageResponseRest.TYPE_SUCCESS, String.class.getSimpleName(), "Test API by Jefferson Ortiz");
	}
}
