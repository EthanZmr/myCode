package pool;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;
import org.junit.Test;
/**
 * DBCP连接池
 * @author ethan
 *
 */
public class DBCP_PoolDemo {
	static String driverClassName = "com.mysql.jdbc.Driver";
	static String url = "jdbc:mysql://localhost:3306/test?characterEncoding=utf-8";
	static String username = "root";
	static String password = "12345678";
	
	@Test
	public void poolTest() throws SQLException {
		/*
		 * 1.创建连接池对象
		 * 2.配置四大参数
		 * 3.配置池参数
		 * 4.得到连接对象
		 */
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(driverClassName);
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		
		dataSource.setMaxActive(20);
		dataSource.setMinIdle(3);
		dataSource.setMaxWait(1000);
		
		Connection conn = dataSource.getConnection();
		//System.out.println(conn.getClass().getName());
		/*
		 * 连接池内部使用四大参数创建了连接对象，即mysql驱动提供的Connection
		 * 连接池使用mysql的连接对象进行装饰，只对close();方法进行了增强
		 * 装饰之后的Connection的Close()方法，。用来把当前连接归还给池
		 */
		conn.close();//把连接归还给池
	}
}
