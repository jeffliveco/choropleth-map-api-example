package co.jeffersonortiz.choroplethapi.business.gis.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;

import co.jeffersonortiz.choroplethapi.dao.ShapeDao;
import co.jeffersonortiz.choroplethapi.dao.UserDao;
import co.jeffersonortiz.choroplethapi.dto.ShapeDto;
import co.jeffersonortiz.choroplethapi.entity.Shape;
import co.jeffersonortiz.choroplethapi.exception.business.BusinessException;
import co.jeffersonortiz.choroplethapi.exception.data.DataAccessException;

/**
 * 
 * @author <a href="mailto:me@jeffersonortiz.com">Jefferson Ortiz Quiroga</a>
 * @version 1.0
 */
public class GisService implements IGisFacade {

	/**
	 * 
	 */
	private ShapeDao shapeDao;
	
	/**
	 * 
	 */
	private UserDao userDao;
	
	/**
	 * 
	 */
	private static GisService instance;
	
	/**
	 * 
	 * @param em
	 * @return
	 */
	public static GisService getInstance(EntityManager em) {
		if(instance == null) {
			instance = new GisService(em);
		}
		return instance;
	}
	
	public GisService(EntityManager em) {
		shapeDao = ShapeDao.getInstance(em);
		userDao = UserDao.getInstance(em);
	}
	
	@Override
	public List<ShapeDto> getAllWord() throws BusinessException {
		try {
			List<Shape> resultData = shapeDao.getAll();
			resultData = shapeDao.getGeometries(resultData);
			resultData = resultData.stream().parallel().map(mapper -> {
				try {
					int count = userDao.getStats(null, null).stream().parallel()
							.filter(user -> user[0].equals(mapper.getCountry()))
							.mapToInt(user -> (Integer) user[1])
							.sum();
					mapper.getProperties().setUserCount(count);
				} catch (DataAccessException e) {
					throw new BusinessException(e.getMessage());
				}
				
				return mapper;
			}).collect(Collectors.toList());
			
			return new ShapeDto().mapperListEntityToListDto(resultData);
		} catch (DataAccessException e) {
			throw new BusinessException(e.getMessage());
		}
	}
}
