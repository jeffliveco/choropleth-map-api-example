package co.jeffersonortiz.choroplethapi.exception.services;

/**
 * 
 * @author <a href="mailto:me@jeffersonortiz.com">Jefferson Ortiz Quiroga</a>
 * @version 1.0
 */
public class ServiceException extends RuntimeException {
	
	/**
	 * Serializer version
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Default construct
	 * @param String message
	 */
	public ServiceException(String message) {
		super(message);
	}
	
	/**
	 * Cause constructor
	 * @param message
	 * @param cause
	 */
	public ServiceException(String message, Exception cause) {
		super(message, cause);
	}
}
