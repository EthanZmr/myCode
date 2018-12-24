package jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public class Demo {
	static String driverClassName = "com.mysql.jdbc.Driver";
	static String url = "jdbc:mysql://localhost:3306/test?characterEncoding=utf-8";
	static String username = "root";
	static String password = "12345678";
	
	@Test
	public void testJdbc1() {
		/*
		 * jdbc四大参数
		 * >driverClass : com.mysql.jdbc.Driver
		 * >url	: jdbc:mysql://localhost:3306/test
		 * >username : root
		 * >password : 12345678
		 */
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/test";
			String username = "root";
			String password = "12345678";
			Connection conn = DriverManager.getConnection(url, username, password);
			System.out.println(conn);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/*
	 * jdbc连接mysql数据库
	 */
	@Test
	public void link() {
		String driverClassName = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/test?characterEncoding=utf-8";
		String username = "root";
		String password = "12345678";
		//加载驱动类
		try {
			Class.forName(driverClassName);
			Connection conn = DriverManager.getConnection(url, username, password);
			Statement smt = conn.createStatement();
			//String sql = "insert into t_user2 values(3,'李四','456','japan')";
			String sql = "update t_user2 set username='王五',password='908' where uid=3";
			int i = smt.executeUpdate(sql);
			System.out.println(i);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/*
	 * jdbc查询
	 */
	@Test
	public void select() {
		Connection conn = null;
		Statement smt = null;
		ResultSet rs = null;
		try {
			Class.forName(driverClassName);
			conn = DriverManager.getConnection(url, username, password);
			smt = conn.createStatement();
			String sql = "select * from t_user2";
			rs = smt.executeQuery(sql);
			ResultSetMetaData rsmd = rs.getMetaData();
			int count = rsmd.getColumnCount();
			
			while(rs.next()) {
				for (int i = 1; i <= count; i++) {
					System.out.print(rs.getObject(i));
					if(i < count) {
						System.out.print(",");
					}
				}
				System.out.println();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(conn != null&&smt != null&&rs != null) {
				try {
					rs.close();
					smt.close();
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	/*
	 * jdbc代码规范化
	 */
	@Test
	public void Query() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName(driverClassName);
			conn = DriverManager.getConnection(url, username, password);
			stmt = conn.createStatement();
			String sql = "select * from t_user2";
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				String username = rs.getString("username");
				String password = rs.getString("password");
				System.out.println(username + ":" + password);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) {rs.close();}
				if(stmt != null) {stmt.close();}
				if(conn != null) {conn.close();}	
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	/*
	 * PreparedStatement
	 * 使用username和password查询数据
	 * 若查询出结果集，说明正确，返回true；
	 * 若查不出结果，说明用户名密码错误，返回false；
	 */
	public boolean login(String _username,String _password) {
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		try {
			Class.forName(driverClassName);
			conn = DriverManager.getConnection(url, username, password);
			
			String sql = "select * from t_user2 where username=? and password=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, _username);
			ps.setString(2, _password);
			rs = ps.executeQuery();
			return rs.next();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) {rs.close();}
				if(ps != null) {ps.close();}
				if(conn != null) {conn.close();}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	
	@Test
	public void testDemo() {
		String username = "harry";
		String password = "111";
		boolean flag = login(username, password);
		System.out.println(flag);
	}
	
	@Test
	public void testfun() throws ClassNotFoundException, IOException, SQLException {
		Connection con = JdbcUtils.getConnection();
		System.out.println(con);
	}
}
