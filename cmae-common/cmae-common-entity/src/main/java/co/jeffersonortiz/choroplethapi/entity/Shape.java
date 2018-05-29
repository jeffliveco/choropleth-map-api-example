package co.jeffersonortiz.choroplethapi.entity;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Type;

import co.jeffersonortiz.choroplethapi.entity.util.AbstractEntity;

/**
 * 
 * @author <a href="mailto:me@jeffersonortiz.com">Jefferson Ortiz Quiroga</a>
 * @version 1.0
 */
@Entity
@Table(name = "shapes")
public class Shape implements AbstractEntity {
	
	/**
	 *  Serialize Data
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Type(type = "objectid")
    private String id;
	private String type;
	@Column(name="iso_country")
	private String country;
	@Embedded
	private ShapeProperty properties;
	@Transient
	private Object geometry;
	
	/**
	 * Constructor
	 */
	public Shape() {}
	
	/**
	 * Constructor with parameters
	 * @param id
	 * @param type
	 * @param country
	 * @param properties
	 */
	public Shape(String id, String type, String country, ShapeProperty properties) {
		this.id = id;
		this.type = type;
		this.country = country;
		this.properties = properties;
	}
	
	public void setLazyHibernateSetup() throws CloneNotSupportedException {
		this.getProperties();
	}
	
	// Getters and Setters
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

	public ShapeProperty getProperties() {
		return properties;
	}

	public void setProperties(ShapeProperty properties) {
		this.properties = properties;
	}

	public Object getGeometry() {
		return geometry;
	}

	public void setGeometry(Object geometry) {
		this.geometry = geometry;
	}
}