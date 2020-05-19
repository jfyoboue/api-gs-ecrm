package models;

import java.sql.SQLException;
import java.util.List;

/**
 * Interface des fonctions des repositories
 * 
 * @author jyoboue
 *
 * @param <T>
 */
public interface Repository<T> {
	List<T> findAll() throws SQLException ;
	List<T> findByStatus(boolean active) throws SQLException ;
	T findById(long id) throws SQLException ;
	long insert(T entity) throws SQLException ;
	boolean update(T entity) throws SQLException ;
}