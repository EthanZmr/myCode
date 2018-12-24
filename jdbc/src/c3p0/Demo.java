package c3p0;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/*
 * c3p0连接池
 */
public class Demo {
	static String driverClassName = "com.mysql.jdbc.Driver";
	static String url = "jdbc:mysql://localhost:3306/test?characterEncoding=utf-8";
	static String username = "root";
	static String password = "12345678";
	
	
	@Test
	public void fun1() throws PropertyVetoException, SQLException {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		
		dataSource.setDriverClass(driverClassName);
		dataSource.setJdbcUrl(url);
		dataSource.setUser(username);
		dataSource.setPassword(password);
		
		//池配置
		dataSource.setAcquireIncrement(5);
		dataSource.setInitialPoolSize(20);
		dataSource.setMinPoolSize(2);
		dataSource.setMaxPoolSize(50);
		
		Connection conn = dataSource.getConnection();
		System.out.println(conn);
		conn.close();
	}
	
	/*
	 * 配置文件的默认配置
	 */
	@Test
	public void fun2() throws SQLException {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		
		Connection conn = dataSource.getConnection();
		System.out.println(conn);
		conn.close();
	}
	
	/*
	 * 配置文件的命名配置
	 */
	@Test
	public void fun3() throws SQLException {
		/*
		 * 构造器的参数指定命名配置元素的名称！
		 * <name-config name="oracle-config">
		 */
		ComboPooledDataSource dataSource = new ComboPooledDataSource("oracle-config");
		
		Connection conn = dataSource.getConnection();
		System.out.println(conn);
		conn.close();
	}
}
