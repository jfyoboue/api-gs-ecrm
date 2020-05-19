package components;

import java.sql.Driver;

import javax.sql.DataSource;

import org.mule.api.MuleEventContext;
import org.mule.api.lifecycle.Callable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

public abstract class Component implements Callable {
	
	@Value("${database.driverClassName}")
	protected String dbDriverClassName;
	
	@Value("${database.url}")
	protected String dbUrl;
	
	@Value("${database.user}")
	protected String dbUser;
	
	@Value("${database.password}")
	protected String dbPassword;
	
	/*public DataSource dataSource() {
		//SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
	    DriverManagerDataSource dataSource = new DriverManagerDataSource();
	    dataSource.setDriverClassName(dbDriverClassName);
	    dataSource.setUrl(dbUrl);
	    dataSource.setUsername(dbUser);
	    dataSource.setPassword(dbPassword);
	    
	    return dataSource;
	}*/
	
	
	protected DataSource dataSource(Class<? extends Driver> driverClass) {
		SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
		//dataSource.setDriverClass((Class<? extends Driver>) com.mysql.jdbc.Driver.class); 
		dataSource.setDriverClass(driverClass); 
		dataSource.setUrl(dbUrl);
		dataSource.setUsername(dbUser); 
		dataSource.setPassword(dbPassword);
		return dataSource;
	}
	
	protected DataSource dataSource(Class<? extends Driver> driverClass, String dbUrl, String dbUser, String dbPassword) {
		SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
		//dataSource.setDriverClass((Class<? extends Driver>) com.mysql.jdbc.Driver.class); 
		dataSource.setDriverClass(driverClass); 
		dataSource.setUrl(dbUrl);
		dataSource.setUsername(dbUser); 
		dataSource.setPassword(dbPassword);
		return dataSource;
	}

	@Override
	public abstract Object onCall(MuleEventContext eventContext) throws Exception;
		
}