package co.jeffersonortiz.choroplethapi.dao;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.hibernate.ogm.datastore.mongodb.query.parsing.nativequery.impl.NativeQueryParseException;

import com.mongodb.MongoQueryException;

import co.jeffersonortiz.choroplethapi.constants.data.DataAccessError;
import co.jeffersonortiz.choroplethapi.dao.util.AbstractDao;
import co.jeffersonortiz.choroplethapi.entity.Shape;
import co.jeffersonortiz.choroplethapi.exception.data.DataAccessException;

/**
 * @author <a href="mailto:me@jeffersonortiz.com">Jefferson Ortiz Quiroga</a>
 * @version 1.0
 *
 */
public class ShapeDao extends AbstractDao<Shape, Serializable> {
	
	/**
	 * Default attribute that print messages in server console
	 */
	private final static Logger logger = Logger.getLogger(ShapeDao.class.getName());
	
	/**
	 * Attribute to save instance same class
	 */
	private static ShapeDao instance; 
	
	/**
	 * Method that implement Singleton pattern
	 * 
	 * @param EntityManager em
	 * @return ProcessDao
	 */
	public static ShapeDao getInstance(EntityManager em) {
		if(instance == null) {
			instance = new ShapeDao(em);
		}
		return instance;
	}
	
	/**
	 * Default constructor
	 * @param type
	 * @param em
	 */
	public ShapeDao(EntityManager em) {
		super(Shape.class, em);
	}
	
	/**
	 * 
	 * @return shapes
	 * @throws DataAccessException
	 */
	public List<Shape> getAll() throws DataAccessException {
		try {
			// 1. set query		
			Query queryHQL = getEntityManager().createQuery("FROM Shape");
			// 3. execute query and set results
			List<Shape> resultData = queryHQL.getResultList();
			// 4. lazily initialize
			for(Shape shape: resultData) {
				shape.setLazyHibernateSetup();
			}
			// 5. return data
			return resultData;
		} catch (CloneNotSupportedException e) {
			DataAccessError error = DataAccessError.NO_CLONABLE_ENTITY;
			logger.info(error.message() + ": " + e.getMessage());
			throw new DataAccessException(error.message(), e.getCause());
		} catch (MongoQueryException e) {
			DataAccessError error = DataAccessError.QUERY_ERROR;
			logger.info(error.message() + ": " + e.getErrorMessage());
			throw new DataAccessException(error.message(), e.getCause());
		} catch (PersistenceException e) {
			DataAccessError error = DataAccessError.GENERAL;
			logger.info(error.message() + ": " + e.getMessage());
			throw new DataAccessException(error.message(), e.getCause());
		}
	}

	/**
	 * 
	 * @param shapes
	 * @return
	 * @throws DataAccessException
	 */	
	public List<Shape> getGeometries(List<Shape> shapes) throws DataAccessException {
		try {			
			// 1. Iterate list shapes
			List<Shape> result = shapes.stream()
				.map(mapper -> {
					// 2. Construct native query
					String query = "db.shapes.find({ _id: ObjectId('" + mapper.getId() + "') })";
					// 3. Get data for query
					Object[] dataGeometry = (Object[]) getEntityManager().createNativeQuery(query).getSingleResult();
					// 4. Set geometry to Shape data
					mapper.setGeometry(dataGeometry[4]);
					// 5. Return shape data
					return mapper;
				})
				.collect(Collectors.toList());
			// 6. Return result
			return result;
		} catch (NoResultException e) {
			return shapes;
		} catch (NativeQueryParseException e) {
			DataAccessError error = DataAccessError.QUERY_ERROR;
			logger.info(error.message() + ": " + e.getMessage());
			throw new DataAccessException(error.message(), e.getCause());
		} catch (MongoQueryException e) {
			DataAccessError error = DataAccessError.QUERY_ERROR;
			logger.info(error.message() + ": " + e.getErrorMessage());
			throw new DataAccessException(error.message(), e.getCause());
		} catch (PersistenceException e) {
			DataAccessError error = DataAccessError.GENERAL;
			logger.info(error.message() + ": " + e.getMessage());
			throw new DataAccessException(error.message(), e.getCause());
		}
	}
}
