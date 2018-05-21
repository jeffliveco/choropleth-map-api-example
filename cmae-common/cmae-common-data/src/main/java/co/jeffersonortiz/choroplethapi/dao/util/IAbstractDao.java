package co.jeffersonortiz.choroplethapi.dao.util;

import java.io.Serializable;

import co.jeffersonortiz.choroplethapi.entity.util.AbstractEntity;
import co.jeffersonortiz.choroplethapi.exception.data.DataAccessException;

/**
 * 
 * 
 * @author <a href="mailto:me@jeffersonortiz.com">Jefferson Ortiz Quiroga</a>
 * @version 1.0
 * @param <Entity>
 * @param <Id>
 */
public interface IAbstractDao <Entity extends AbstractEntity, Id extends Serializable> {
	
	/**
	 * Persist the newInstance object into database.
	 * 
	 * @param <Entity> newInstance
	 * @return <Id>
	 * @throws DataAccessException
	 */
	Id create(Entity newInstance) throws DataAccessException;
 
	/**
	 * Retrieve an object that was previously persisted to the database using the indicated id as primary key.
     * 
	 * @param <Id> id
	 * @return <Entity>
	 * @throws DataAccessException
	 */
	Entity read(Id id) throws DataAccessException;
 
	/**
	 * Save changes made to a persistent object.
	 * 
	 * @param <Entity> transientObject
	 * @throws DataAccessException
	 */
    void update(Entity transientObject) throws DataAccessException;
 
    /**
     * Remove an object from persistent storage in the database.
     * 
     * @param <Entity> persistentObject
     * @throws DataAccessException
     */
    void delete(Entity persistentObject) throws DataAccessException;
}
