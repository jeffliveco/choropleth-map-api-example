package co.jeffersonortiz.choroplethapi.exception.business;

/**
 * 
 * @author <a href="mailto:me@jeffersonortiz.com">Jefferson Ortiz Quiroga</a>
 * @version 1.0
 */
public class BusinessException extends Exception {

	/**
	 * Serializer version
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Default construct
	 * @param String message
	 */
	public BusinessException(String message) {
		super(message);
	}
	
	/**
	 * Cause constructor
	 * @param message
	 * @param cause
	 */
	public BusinessException(String message, Throwable cause) {
		super(message, cause);
	}
}
