package models;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

/***
 * Classe de base des repositories
 * 
 * @author yobouejean-francois
 *
 */
public abstract class BaseRepository <T> implements Repository<T> {
	// Fields
	/**
	 * Source de données
	 */
	protected DataSource dataSource;
	
	
	// Constructors
	/**
	 * Constructeur
	 * 
	 * @param dataSource
	 */
	public BaseRepository(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	
	// Abstract Methods
	@Override
	public abstract List<T> findAll() throws SQLException ;

	@Override
	public abstract List<T> findByStatus(boolean active) throws SQLException ;

	@Override
	public abstract T findById(long id) throws SQLException ;

	@Override
	public abstract long insert(T entity) throws SQLException ; 

	@Override
	public abstract boolean update(T entity) throws SQLException ;
}