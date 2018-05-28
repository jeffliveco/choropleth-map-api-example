package co.jeffersonortiz.choroplethapi.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ShapeCollectionDto implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String type;
	private List<ShapeDto> features;
	
	public ShapeCollectionDto() {
		this.type = "FeatureCollection"; 
		this.features = new ArrayList<>();
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<ShapeDto> getFeatures() {
		return features;
	}

	public void setFeatures(List<ShapeDto> features) {
		this.features = features;
	}
}
