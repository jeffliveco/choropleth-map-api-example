package co.jeffersonortiz.choroplethapi.dto;

import java.util.List;
import java.util.stream.Collectors;

import co.jeffersonortiz.choroplethapi.entity.Shape;
import co.jeffersonortiz.choroplethapi.entity.util.AbstractDto;

/**
 * 
 * @author <a href="mailto:me@jeffersonortiz.com">Jefferson Ortiz Quiroga</a>
 * @version 1.0
 */
public class ShapeDto implements AbstractDto<ShapeDto, Shape> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String type;
	private ShapePropertyDto properties;
	private Object geometry;
	
	public ShapeDto() { }
	
	public ShapeDto(String id, String type, ShapePropertyDto properties, Object geometry) {
		this.id = id;
		this.type = type;
		this.properties = properties;
		this.geometry = geometry;
	}

	// Mapping to DTO
	@Override
	public ShapeDto mapperEntityToDto(Shape entity) {
		ShapePropertyDto properties = new ShapePropertyDto().mapperEntityToDto(entity.getProperties());
		properties.setIso(entity.getCountry());
		return new ShapeDto(entity.getId(), entity.getType(), properties, entity.getGeometry());
	}
	
	@Override
	public List<ShapeDto> mapperListEntityToListDto(List<Shape> listEntity) {
		return listEntity.stream()
			.map(mapper -> {
				ShapePropertyDto properties = new ShapePropertyDto().mapperEntityToDto(mapper.getProperties());
				properties.setIso(mapper.getCountry());
				return new ShapeDto(mapper.getId(), mapper.getType(), properties, mapper.getGeometry());
			})
			.collect(Collectors.toList());
	}
	
	// Mapping to Entity
	@Override
	public Shape mapperDtoToEntity(ShapeDto dto) {
		return new Shape(dto.getId(), 
				dto.getType(), 
				dto.getProperties().getIso(), 
				new ShapePropertyDto().mapperDtoToEntity(dto.getProperties())
		);
	}
	
	@Override
	public List<Shape> mapperListDtoToListEntity(List<ShapeDto> listDto){
		return listDto.stream()
			.map(mapper -> new Shape(mapper.getId(), 
					mapper.getType(), 
					mapper.getProperties().getIso(), 
					new ShapePropertyDto().mapperDtoToEntity(mapper.getProperties()))
			).collect(Collectors.toList());
	}
	
	// Getters & Setters
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
	
	public Object getGeometry() {
		return geometry;
	}

	public void setGeometry(Object geometry) {
		this.geometry = geometry;
	}

	public ShapePropertyDto getProperties() {
		return properties;
	}

	public void setProperties(ShapePropertyDto properties) {
		this.properties = properties;
	}
}
