package co.jeffersonortiz.choroplethapi.business.gis.service;

import java.util.List;

import co.jeffersonortiz.choroplethapi.dto.ShapeDto;
import co.jeffersonortiz.choroplethapi.exception.business.BusinessException;

/**
 * 
 * @author <a href="mailto:me@jeffersonortiz.com">Jefferson Ortiz Quiroga</a>
 * @version 1.0
 */
public interface IGisService {
	
	/**
	 * 
	 * @return
	 * @throws BusinessException
	 */
	List<ShapeDto> getAllWord() throws BusinessException;
}
