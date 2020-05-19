package models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.jdbc.core.RowMapper;


public abstract class EntityMapper<T> implements RowMapper<T> {
	// Fields
	protected static final SimpleDateFormat SQL = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	protected static final SimpleDateFormat SQL_DATE = new SimpleDateFormat("yyyy-MM-dd"); 
	
	
	// Abstract Methods
	@Override
	public abstract T mapRow(ResultSet rs, int rowNum) throws SQLException;
	
	
	// Protected Methods
	protected Date getDateTime(ResultSet rs, String rowName) throws SQLException {
		Date date = null;
		String rowValue = rs.getString(rowName);
		
		if (rowValue != null && !rowValue.isEmpty() && !rowValue.equalsIgnoreCase("null")) {
			try {
				date = SQL.parse(rowValue);
			} catch (ParseException e) {
	        	e.printStackTrace();
	        }
		}
		
		return date;
	}
	
	protected Date getDateTime(ResultSet rs, String rowName, SimpleDateFormat format) throws SQLException {
		Date date = null;
		String rowValue = rs.getString(rowName);
		
		if (rowValue != null && !rowValue.isEmpty() && !rowValue.equalsIgnoreCase("null")) {
			try {
				date = format.parse(rowValue);
			} catch (ParseException e) {
	        	e.printStackTrace();
	        }
		}
		
		return date;
	}
}