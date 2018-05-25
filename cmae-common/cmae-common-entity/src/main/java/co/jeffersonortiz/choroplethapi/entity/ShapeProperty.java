package co.jeffersonortiz.choroplethapi.entity;

import javax.persistence.Embeddable;

/**
 * 
 * @author <a href="mailto:me@jeffersonortiz.com">Jefferson Ortiz Quiroga</a>
 * @version 1.0
 */
@Embeddable
public class ShapeProperty {
	
    private String name;

    /**
     * Constructor
     */
    public ShapeProperty() { }
    
    /**
     * Constructor with parameters
     * @param name
     */
    public ShapeProperty(String name) {
    	this.name = name;
    }
    
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}