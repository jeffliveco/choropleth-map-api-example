package co.jeffersonortiz.choroplethapi.dao;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import org.hibernate.ogm.datastore.mongodb.query.parsing.nativequery.impl.NativeQueryParseException;

import com.mongodb.MongoQueryException;

import co.jeffersonortiz.choroplethapi.constants.data.DataAccessError;
import co.jeffersonortiz.choroplethapi.dao.util.AbstractDao;
import co.jeffersonortiz.choroplethapi.entity.User;
import co.jeffersonortiz.choroplethapi.exception.data.DataAccessException;

/**
 * @author <a href="mailto:me@jeffersonortiz.com">Jefferson Ortiz Quiroga</a>
 * @version 1.0
 *
 */
public class UserDao extends AbstractDao<User, Serializable> {

	/**
	 * Default attribute that print messages in server console
	 */
	private final static Logger logger = Logger.getLogger(UserDao.class.getName());
	
	/**
	 * Attribute to save instance same class
	 */
	private static UserDao instance; 
	
	/**
	 * Method that implement Singleton pattern
	 * 
	 * @param EntityManager em
	 * @return ProcessDao
	 */
	public static UserDao getInstance(EntityManager em) {
		if(instance == null) {
			instance = new UserDao(em);
		}
		return instance;
	}
	
	/**
	 * Default constructor
	 * @param type
	 * @param em
	 */
	public UserDao(EntityManager em) {
		super(User.class, em);
	}
	
	public List<Object[]> getStats(String gender, Integer age) throws DataAccessException {
		try {
			String query = "db.users.aggregate([ ";
			//query += "{ $match: { sex: { \"female\" } } },";
			query += "{ '$group': { '_id': '$nationality', 'count': { '$sum': 1} } },";
			query += "{ '$sort': { '_id': 1 } }";
			query += " ])";
						
			List<Object[]> dataGeometry = (List<Object[]>) getEntityManager().createNativeQuery(query).getResultList();
			return dataGeometry;
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
