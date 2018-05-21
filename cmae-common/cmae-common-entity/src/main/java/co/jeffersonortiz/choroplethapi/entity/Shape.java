package co.jeffersonortiz.choroplethapi.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.mongodb.client.model.geojson.Geometry;

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
	private ShapeProperty properties;
	private List<Geometry> geometry;
	
	/**
	 * Default constructor
	 */
	public Shape() {}
	
	public void setLazyHibernateSetup() throws CloneNotSupportedException {}
	
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

	public List<Geometry> getGeometry() {
		return geometry;
	}

	public void setGeometry(List<Geometry> geometry) {
		this.geometry = geometry;
	}
}

@Embeddable
class ShapeProperty {
    public String name;
}
