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
	private String country;
	private ShapePropertyDto properties;
	private String geometry;
	
	public ShapeDto() { }
	
	public ShapeDto(String id, String type, String country, ShapePropertyDto properties, String geometry) {
		this.id = id;
		this.type = type;
		this.country = country;
		this.properties = properties;
		this.geometry = geometry;
	}

	// Mapping to DTO
	@Override
	public ShapeDto mapperEntityToDto(Shape entity) {
		ShapeDto result = new ShapeDto(entity.getId(), entity.getType(), entity.getCountry(),  new ShapePropertyDto().mapperEntityToDto(entity.getProperties()), entity.getGeometry());
		return result;
	}
	
	@Override
	public List<ShapeDto> mapperListEntityToListDto(List<Shape> listEntity) {
		List<ShapeDto> result = listEntity.stream()
			.map(mapper -> new ShapeDto(mapper.getId(), mapper.getType(), mapper.getCountry(),  new ShapePropertyDto().mapperEntityToDto(mapper.getProperties()), mapper.getGeometry()))
			.collect(Collectors.toList());
		return result;
	}
	
	// Mapping to Entity
	@Override
	public Shape mapperDtoToEntity(ShapeDto dto) {
		Shape result = new Shape(dto.getId(), dto.getType(), dto.getCountry(),  new ShapePropertyDto().mapperDtoToEntity(dto.getProperties()));
		return result;
	}
	
	@Override
	public List<Shape> mapperListDtoToListEntity(List<ShapeDto> listDto){
		List<Shape> result = listDto.stream()
			.map(mapper -> new Shape(mapper.getId(), mapper.getType(), mapper.getCountry(),  new ShapePropertyDto().mapperDtoToEntity(mapper.getProperties())))
			.collect(Collectors.toList());
		return result;
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

	public ShapePropertyDto getProperties() {
		return properties;
	}

	public void setProperties(ShapePropertyDto properties) {
		this.properties = properties;
	}
}
