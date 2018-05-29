package co.jeffersonortiz.choroplethapi.constants.data;

/**
 * @author <a href="mailto:me@jeffersonortiz.com">Jefferson Ortiz Quiroga</a>
 * @version 1.0
 */
public enum DataAccessError {
	ENTITY_EXIST ("DATA/ENTITY_EXIST"),
	NOT_ENTITY ("DATA/NOT_ENTITY"),
	QUERY_ERROR ("DATA/QUERY_ERROR"),
	NO_CLONABLE_ENTITY ("DATA/NO_CLONABLE_ENTITY"),
	GENERAL ("DATA/GENERAL"),
	INVALID_PARAM_NAME ("DATA/INVALID_PARAM_NAME");
	
	private final String message;
	
	DataAccessError (String message) {
		this.message = message;
	}
	
	public String message() { return message; }
}