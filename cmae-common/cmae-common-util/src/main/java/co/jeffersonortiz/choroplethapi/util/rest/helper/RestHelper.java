package co.jeffersonortiz.choroplethapi.util.rest.helper;

import javax.enterprise.inject.Default;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.Response.StatusType;

import co.jeffersonortiz.choroplethapi.util.rest.model.MessageResponseRest;

@Default
public class RestHelper {
	
	public Response validateTokenAPI(String token) {
		Status status = Response.Status.UNAUTHORIZED;
		
		MessageResponseRest unauth = new MessageResponseRest();
		unauth.setCode(status.getStatusCode());
		unauth.setStatus(status.toString());
		unauth.setType(MessageResponseRest.TYPE_ERROR);
		unauth.setMessage("NO_API_KEY");
		
		if(token == null) {
			return Response.status(status).entity(unauth).header("Access-Control-Allow-Origin", "*").build();
		} else if(token.isEmpty()) {
			return Response.status(status).entity(unauth).header("Access-Control-Allow-Origin", "*").build();
		}
		
		return null;
	}
	
	public Response responseSucessBuilder(Status status, String type, String model, Object data) {
		MessageResponseRest success = new MessageResponseRest();
		success.setCode(status.getStatusCode());
		success.setStatus(status.toString());
		success.setType(type);
		success.setModel(model);
		success.setData(data);
		
		return Response.status(status).entity(success).header("Access-Control-Allow-Origin", "*").build();
	}
	
	public Response responseErrorBuilder(StatusType status, String type, Throwable error) {
		MessageResponseRest response = new MessageResponseRest();
		response.setCode(status.getStatusCode());
		response.setStatus(status.toString());
		response.setType(type);
		response.setMessage(error.getMessage());
		response.setCausesError(error.getStackTrace());
		
		return Response.status(status).entity(response).type(MediaType.APPLICATION_JSON).header("Access-Control-Allow-Origin", "*").build();
	}
}
