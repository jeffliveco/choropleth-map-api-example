package co.jeffersonortiz.choroplethapi.exception.remote;

/**
 * 
 * @author <a href="mailto:me@jeffersonortiz.com">Jefferson Ortiz Quiroga</a>
 * @version 1.0
 */
public class RemoteJNDIException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public RemoteJNDIException(String message) {
		super(message);
	}
	
	public RemoteJNDIException(String message, Throwable cause) {
		super(message, cause);
	}

}
