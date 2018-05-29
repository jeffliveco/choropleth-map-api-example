package co.jeffersonortiz.choroplethapi.util.rest.model;

import java.io.Serializable;

public class MessageResponseRest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static String TYPE_ERROR = "ERROR";
	public static String TYPE_SUCCESS = "SUCCESS";
	
	private int code;
	private String status;
	private String type;
	private String model;
	private Object data;
	
	public int getCode() {
		return code;
	}
	
	public void setCode(int code) {
		this.code = code;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getModel() {
		return model;
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	
	public Object getData() {
		return data;
	}
	
	public void setData(Object data) {
		this.data = data;
	}
	
}
