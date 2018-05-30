package co.jeffersonortiz.choroplethapi.entity;

import javax.persistence.Embeddable;
import javax.persistence.Transient;

/**
 * 
 * @author <a href="mailto:me@jeffersonortiz.com">Jefferson Ortiz Quiroga</a>
 * @version 1.0
 */
@Embeddable
public class ShapeProperty {
	
    private String name;
    
    @Transient
    private Integer userCount;

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

	public Integer getUserCount() {
		return userCount;
	}

	public void setUserCount(Integer userCount) {
		this.userCount = userCount;
	}
}