package co.jeffersonortiz.choroplethapi.dao;

import java.io.Serializable;
import java.util.logging.Logger;

import javax.persistence.EntityManager;

import co.jeffersonortiz.choroplethapi.dao.util.AbstractDao;
import co.jeffersonortiz.choroplethapi.entity.User;

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
}
