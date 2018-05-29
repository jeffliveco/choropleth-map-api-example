package co.jeffersonortiz.choroplethapi.exception.business;

import javax.ejb.ApplicationException;
import javax.ejb.EJBException;

/**
 * 
 * @author <a href="mailto:me@jeffersonortiz.com">Jefferson Ortiz Quiroga</a>
 * @version 1.0
 */

@ApplicationException(rollback = true)
public class BusinessException extends EJBException {

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
	public BusinessException(String message, Exception cause) {
		super(message, cause);
	}
}
