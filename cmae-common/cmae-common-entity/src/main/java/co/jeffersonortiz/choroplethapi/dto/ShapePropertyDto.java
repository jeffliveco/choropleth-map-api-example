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
	private String iso;
	
	public ShapePropertyDto() { }
	
	public ShapePropertyDto(String name, String iso) {
		this.name = name;
		this.iso = iso;
	}
	
	public ShapePropertyDto(String name) {
		this.name = name;
	}

	// Mapping to DTO
	@Override
	public ShapePropertyDto mapperEntityToDto(ShapeProperty entity) {
		return new ShapePropertyDto(entity.getName());
	}

	@Override
	public List<ShapePropertyDto> mapperListEntityToListDto(List<ShapeProperty> listEntity) {
		return listEntity.stream()
			.map(mapper -> new ShapePropertyDto(mapper.getName()))
			.collect(Collectors.toList());
	}

	// Mapping to Entity
	@Override
	public ShapeProperty mapperDtoToEntity(ShapePropertyDto dto) {
		return new ShapeProperty(dto.getName());
	}

	@Override
	public List<ShapeProperty> mapperListDtoToListEntity(List<ShapePropertyDto> listDto) {
		return listDto.stream()
			.map(mapper -> new ShapeProperty(mapper.getName()))
			.collect(Collectors.toList());
	}

	// Getters & Setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getIso() {
		return iso;
	}

	public void setIso(String iso) {
		this.iso = iso;
	}
}
