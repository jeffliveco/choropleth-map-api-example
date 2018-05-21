package co.jeffersonortiz.choroplethapi.dao.constants;

/**
 * @author <a href="mailto:me@jeffersonortiz.com">Jefferson Ortiz Quiroga</a>
 * @version 1.0
 */
public enum DataAccessError {
	ENTITY_EXIST ("ENTITY_EXIST"),
	NOT_ENTITY ("NOT_ENTITY"),
	QUERY_ERROR ("QUERY_ERROR"),
	NO_CLONABLE_ENTITY ("NO_CLONABLE_ENTITY"),
	GENERAL ("GENERAL"),
	INVALID_PARAM_NAME ("INVALID_PARAM_NAME");
	
	private final String message;
	
	DataAccessError (String message) {
		this.message = message;
	}
	
	public String message() { return message; }
}