package jdbc;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/*
 * JdbcUtils 2.0
 */
public class JdbcUtilsVersion2 {
	private static ComboPooledDataSource dataSource = new ComboPooledDataSource();
	public static Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}
	
	public static DataSource getDataSource() {
		return dataSource;
	}
}
