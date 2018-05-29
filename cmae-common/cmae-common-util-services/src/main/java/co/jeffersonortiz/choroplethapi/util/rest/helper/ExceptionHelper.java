package co.jeffersonortiz.choroplethapi.util.rest.helper;

import java.util.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.StatusType;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import co.jeffersonortiz.choroplethapi.util.rest.model.MessageResponseRest;

/**
 * 
 * @author <a href="mailto:me@jeffersonortiz.com">Jefferson Ortiz Quiroga</a>
 * @version 1.0
 */
@Provider
public class ExceptionHelper implements ExceptionMapper<Throwable> {
	
	/**
	 * Default attribute that print messages in server console
	 */
	private final static Logger logger = Logger.getLogger(ExceptionHelper.class.getName());
	
	@Inject
	private RestHelper helper;
	
	public Response toResponse(Throwable ex) {
		logger.info("toResponse()->" + ex.getMessage());
		
		StatusType status;
		String message;
		
		if(ex.getMessage() != null) {
			if(validateSystemError(ex.getMessage())) {
				status = Response.Status.INTERNAL_SERVER_ERROR;
				message = ex.getMessage();
			} else {
				message = "SYSTEM_ERROR";
				status = Response.Status.INTERNAL_SERVER_ERROR;
			}			
		} else {
			message = "SYSTEM_ERROR";
			status = Response.Status.INTERNAL_SERVER_ERROR;
		}
		
		return helper.responseErrorBuilder(status, MessageResponseRest.TYPE_ERROR, message);
	}
	
	private Boolean validateSystemError(String message) {
		if(message.contains("DATA/")) {
			return true;
		} else if(message.contains("FILE/")) {
			return true;
		}
		return false;
	}
}
