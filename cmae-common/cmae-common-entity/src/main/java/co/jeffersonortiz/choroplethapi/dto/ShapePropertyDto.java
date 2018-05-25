package co.jeffersonortiz.choroplethapi.dto;

import java.util.List;
import java.util.stream.Collectors;

import co.jeffersonortiz.choroplethapi.entity.ShapeProperty;
import co.jeffersonortiz.choroplethapi.entity.util.AbstractDto;

/**
 * 
 * @author <a href="mailto:me@jeffersonortiz.com">Jefferson Ortiz Quiroga</a>
 * @version 1.0
 */
public class ShapePropertyDto implements AbstractDto<ShapePropertyDto, ShapeProperty> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String name;
	
	public ShapePropertyDto() { }
	
	public ShapePropertyDto(String name) {
		this.name = name;
	}

	// Mapping to DTO
	@Override
	public ShapePropertyDto mapperEntityToDto(ShapeProperty entity) {
		ShapePropertyDto result = new ShapePropertyDto(entity.getName());
		return result;
	}

	@Override
	public List<ShapePropertyDto> mapperListEntityToListDto(List<ShapeProperty> listEntity) {
		List<ShapePropertyDto> result = listEntity.stream()
			.map(mapper -> new ShapePropertyDto(mapper.getName()))
			.collect(Collectors.toList());
		return result;
	}

	// Mapping to Entity
	@Override
	public ShapeProperty mapperDtoToEntity(ShapePropertyDto dto) {
		ShapeProperty result = new ShapeProperty(dto.getName());
		return result;
	}

	@Override
	public List<ShapeProperty> mapperListDtoToListEntity(List<ShapePropertyDto> listDto) {
		List<ShapeProperty> result = listDto.stream()
			.map(mapper -> new ShapeProperty(mapper.getName()))
			.collect(Collectors.toList());
		return result;
	}

	// Getters & Setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
