package co.jeffersonortiz.choroplethapi.dto;

import java.io.Serializable;

public class ShapeDto implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String type;
	private String country;
	private String geometry;
	
	public ShapeDto(String id, String type, String country, String geometry) {
		this.id = id;
		this.type = type;
		this.country = country;
		this.geometry = geometry;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	public String getGeometry() {
		return geometry;
	}

	public void setGeometry(String geometry) {
		this.geometry = geometry;
	}
}
