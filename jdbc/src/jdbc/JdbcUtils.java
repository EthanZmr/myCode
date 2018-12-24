package jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtils {
	/*private static Properties props = null;
	static {
		try {
			InputStream in = JdbcUtils.class.getClassLoader().getResourceAsStream("dbconfig.properties");
			props = new Properties();
			props.load(in);
		} catch (IOException e) {
			throw new RuntimeException();
		}
		try {
			Class.forName(props.getProperty("driverclass"));
		} catch (ClassNotFoundException e) {
			throw new RuntimeException();
		}
	}
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(props.getProperty("url"), props.getProperty("username"), props.getProperty("password"));
	}*/
	
	/*private static Properties props = null;
	static {
		try {
			InputStream in = JdbcUtils.class.getResourceAsStream("dbconfig.properties"); //JdbcUtils.class.getClassLoader().getResourceAsStream();
			props = new Properties();
			props.load(in);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		try {
			Class.forName(props.getProperty("driverclass"));
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(props.getProperty("url"), props.getProperty("username"), props.getProperty("password"));
	}*/
	
	private static Properties props = null;
	static {
		try {
			InputStream in = JdbcUtils.class.getClassLoader().getResourceAsStream("dbconfig.properties");
			props = new Properties();
			props.load(in);
			Class.forName(props.getProperty("driverclass"));
		} catch (IOException e) {
			throw new RuntimeException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(props.getProperty("url"), props.getProperty("username"), props.getProperty("password"));
	}
}
