package models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class CustomerRepository extends BaseRepository<Customer> {

	public CustomerRepository(DataSource dataSource) {
		super(dataSource);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Customer> findAll() throws SQLException {
		List<Customer> entities = new ArrayList<>();
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		String sql = "SELECT * FROM customer";
		
		entities = (List<Customer>) jdbcTemplate.query(
				sql, new Object[] {},
				new CustomerMapper());
		
		return entities;
	}
	

	@Override
	public List<Customer> findByStatus(boolean active) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer findById(long id) throws SQLException {
		Customer entity = null;
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		String sql = "SELECT * FROM customers WHERE id = ?";
		
		List<Customer> entities = (List<Customer>) jdbcTemplate.query(
				sql, new Object[] {id},
				new CustomerMapper());
		
		if (entities != null && entities.size() > 0) {
			entity = entities.get(0);
		}
		
		return entity;
	}

	@Override
	public long insert(Customer entity) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean update(Customer entity) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

}