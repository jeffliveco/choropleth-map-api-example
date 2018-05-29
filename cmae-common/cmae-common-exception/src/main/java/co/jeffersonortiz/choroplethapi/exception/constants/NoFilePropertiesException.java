package co.jeffersonortiz.choroplethapi.exception.constants;

public class NoFilePropertiesException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public NoFilePropertiesException(String message) {
		super(message);
	}
	
	public NoFilePropertiesException(String message, Throwable cause) {
		super(message, cause);
	}
}
