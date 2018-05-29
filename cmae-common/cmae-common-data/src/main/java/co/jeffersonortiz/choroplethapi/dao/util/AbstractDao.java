package co.jeffersonortiz.choroplethapi.dao.util;

import java.io.Serializable;
import java.util.logging.Logger;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.TransactionRequiredException;

import co.jeffersonortiz.choroplethapi.constants.data.DataAccessError;
import co.jeffersonortiz.choroplethapi.entity.util.AbstractEntity;
import co.jeffersonortiz.choroplethapi.exception.data.DataAccessException;

/**
 * 
 * @author <a href="mailto:me@jeffersonortiz.com">Jefferson Ortiz Quiroga</a>
 * @version 1.0
 * @param <Entity>
 * @param <Id>
 */
public class AbstractDao<Entity extends AbstractEntity, Id extends Serializable> implements IAbstractDao<Entity, Id> {
	
	/**
	 * Default attribute that print messages in server console
	 */
	private final static Logger logger = Logger.getLogger(AbstractDao.class.getName());
	
	/**
	 * 
	 */
	private EntityManager em;
	
	/**
	 * 
	 */
	private Class<Entity> type;
	
	/**
	 * Default constructor
	 * 
	 * @param Class<Entity> type
	 * @param EntityManager em
	 */
	public AbstractDao(Class<Entity> type, EntityManager em) {
		try {
			this.type = type;
			this.em = em;			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Id create(Entity newInstance) throws DataAccessException {
		try {
			em.persist(newInstance);
			em.flush();
			return (Id) newInstance.getId();
		} catch (EntityExistsException e) {
			DataAccessError error = DataAccessError.ENTITY_EXIST;
			logger.info(error.message() + ": " + e.getMessage());
			throw new DataAccessException(error.message(), e.getCause());
		} catch (IllegalArgumentException e) {
			DataAccessError error = DataAccessError.NOT_ENTITY;
			logger.info(error.message() + ": " + e.getMessage());
			throw new DataAccessException(error.message(), e.getCause());
		} catch (TransactionRequiredException e) {
			DataAccessError error = DataAccessError.GENERAL;
			logger.info(error.message() + ": " + e.getMessage());
			throw new DataAccessException(error.message(), e.getCause());
		}
	}

	@Override
	public Entity read(Id id) throws DataAccessException {
		try {
			Entity response = em.find(type, id);
			if(response != null) {
				response.setLazyHibernateSetup();
			}
			em.flush();
			return response;
		} catch (CloneNotSupportedException e) {
			DataAccessError error = DataAccessError.NO_CLONABLE_ENTITY;
			logger.info(error.message() + ": " + e.getMessage());
			throw new DataAccessException(error.message(), e.getCause());
		} catch (IllegalArgumentException e) {
			DataAccessError error = DataAccessError.NOT_ENTITY;
			logger.info(error.message() + ": " + e.getMessage());
			throw new DataAccessException(error.message(), e.getCause());
		}
	}

	@Override
	public void update(Entity transientObject) throws DataAccessException {
		try {
			em.merge(transientObject);
			em.flush();
		} catch (IllegalArgumentException e) {
			DataAccessError error = DataAccessError.NOT_ENTITY;
			logger.info(error.message() + ": " + e.getMessage());
			throw new DataAccessException(error.message(), e.getCause());
		} catch (TransactionRequiredException e) {
			DataAccessError error = DataAccessError.GENERAL;
			logger.info(error.message() + ": " + e.getMessage());
			throw new DataAccessException(error.message(), e.getCause());
		}
	}

	@Override
	public void delete(Entity persistentObject) throws DataAccessException {
		try {
			em.remove(persistentObject);
			em.flush();
		} catch (IllegalArgumentException e) {
			DataAccessError error = DataAccessError.NOT_ENTITY;
			logger.info(error.message() + ": " + e.getMessage());
			throw new DataAccessException(error.message(), e.getCause());
		} catch (TransactionRequiredException e) {
			DataAccessError error = DataAccessError.GENERAL;
			logger.info(error.message() + ": " + e.getMessage());
			throw new DataAccessException(error.message(), e.getCause());
		}
	}
	
	public EntityManager getEntityManager() {
		return this.em;
	}
}