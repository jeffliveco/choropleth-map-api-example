package co.jeffersonortiz.choroplethapi.constants.remote;

/**
 * @author <a href="mailto:me@jeffersonortiz.com">Jefferson Ortiz Quiroga</a>
 * @version 1.0
 */
public enum RemoteError {
	SERVICE_NOT_FOUND ("REMOTE/SERVICE_NOT_FOUND");
	
	private final String message;
	
	RemoteError (String message) {
		this.message = message;
	}
	
	public String message() { return message; }
}
