package co.jeffersonortiz.choroplethapi.entity.util;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * @author <a href="mailto:me@jeffersonortiz.com">Jefferson Ortiz Quiroga</a>
 * @version 1.0
 */
public interface AbstractDto<DTO, Entity> extends Serializable {

	// Mapping to DTO
	public DTO mapperEntityToDto(Entity entity);
	public List<DTO> mapperListEntityToListDto(List<Entity> listEntity);
	
	// Mapping to Entity
	public Entity mapperDtoToEntity(DTO dto);
	public List<Entity> mapperListDtoToListEntity(List<DTO> listDto);
}
