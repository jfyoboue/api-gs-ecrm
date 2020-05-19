package models;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerMapper extends EntityMapper<Customer> {

	@Override
	public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
		Customer entity = new Customer();
		
		entity.setId(rs.getLong("id"));
		entity.setName(rs.getString("name"));
		entity.setAddress(rs.getString("address"));
		entity.setWebsite(rs.getString("website"));
		entity.setCreatedAt(getDateTime(rs, "created_at"));
		entity.setUpdatedAt(getDateTime(rs, "updated_at"));
		
		return entity;
	}

}