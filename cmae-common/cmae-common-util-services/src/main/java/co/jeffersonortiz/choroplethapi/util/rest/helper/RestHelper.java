package co.jeffersonortiz.choroplethapi.util.rest.helper;

import javax.enterprise.inject.Default;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.Response.StatusType;

import co.jeffersonortiz.choroplethapi.util.rest.model.MessageResponseRest;

/**
 * 
 * @author <a href="mailto:me@jeffersonortiz.com">Jefferson Ortiz Quiroga</a>
 * @version 1.0
 */
@Default
public class RestHelper {
	
	public Response validateTokenAPI(String token) {
		Status status = Response.Status.UNAUTHORIZED;
		
		MessageResponseRest unauth = new MessageResponseRest();
		unauth.setCode(status.getStatusCode());
		unauth.setStatus(status.toString());
		unauth.setType(MessageResponseRest.TYPE_ERROR);
		unauth.setData("NO_API_KEY");
		
		if(token == null) {
			return this.build(status, unauth);
		} else if(token.isEmpty()) {
			return this.build(status, unauth);
		}
		
		return null;
	}
	
	public Response responseSucessBuilder(String type, String model, Object data) {
		Status successResponse = Status.OK;
		
		MessageResponseRest success = new MessageResponseRest();
		success.setCode(successResponse.getStatusCode());
		success.setStatus(successResponse.toString());
		success.setType(type);
		success.setModel(model);
		success.setData(data);
		
		return this.build(successResponse, success);
	}
	
	public Response responseSucessGeneric(Object data) {	
		return this.build(Status.OK, data);
	}
	
	public Response responseErrorBuilder(StatusType status, String type, String error) {
		MessageResponseRest response = new MessageResponseRest();
		response.setCode(status.getStatusCode());
		response.setStatus(status.toString());
		response.setType(type);
		response.setData(error);
		response.setModel(String.class.getSimpleName());
		
		return this.build(status, response);
	}
	
	private Response build(StatusType status, Object data) {
		return Response.status(status).entity(data).header("Access-Control-Allow-Origin", "*").build();
	}
}
