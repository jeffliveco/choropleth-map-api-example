package co.jeffersonortiz.choroplethapi.entity;

import javax.persistence.Embeddable;

@Embeddable
public class ShapeProperty {
	
    public String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}