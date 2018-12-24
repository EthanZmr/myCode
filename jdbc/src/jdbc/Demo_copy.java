package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public class Demo_copy {
	static String driverClassName = "com.mysql.jdbc.Driver";
	static String url = "jdbc:mysql://localhost:3306/test?characterEncoding=utf-8";
	static String username = "root";
	static String password = "12345678";
	
	@Test
	public void testConnection() {
		Connection conn = null;
		try {
			Class.forName(driverClassName);
			conn = DriverManager.getConnection(url, username, password);
			System.out.println(conn);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Test
	public void linkMysql() {
		Connection conn = null;
		Statement st = null;
		try {
			Class.forName(driverClassName);
			conn = DriverManager.getConnection(url, username, password);
			st = conn.createStatement();
			String sql = "";
			int i = st.executeUpdate(sql);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				if(conn != null) conn.close();
				if(st != null) st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Test
	public void testQuery() {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			Class.forName(driverClassName);
			conn = DriverManager.getConnection(url, username, password);
			st = conn.createStatement();
			String sql = "select * from t_user2";
			rs = st.executeQuery(sql);
			ResultSetMetaData rsmd = rs.getMetaData();
			int count = rsmd.getColumnCount();
			while(rs.next()) {
				for (int i = 1; i < count; i++) {
					System.out.print(rs.getObject(i));
					if(i < count) {
						System.out.print(",");
					}
				}
				System.out.println();
			}
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				if(conn != null) conn.close();
				if(st != null) st.close();
				if(rs != null) rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Test
	public void testQuery2() {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			Class.forName(driverClassName);
			conn = DriverManager.getConnection(url, username, password);
			st = conn.createStatement();
			String sql = "select * from t_user2";
			rs = st.executeQuery(sql);
			ResultSetMetaData rsmd = rs.getMetaData();
			int count = rsmd.getColumnCount();
			while(rs.next()) {
				for (int i = 1; i < count; i++) {
					System.out.print(rs.getObject(i));
					if(i < count) {
						System.out.print(",");
					}
				}
				System.out.println();
			}
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				if(conn != null) conn.close();
				if(st != null) st.close();
				if(rs != null) rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Test
	public void testQuery3() {
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
				for (int i = 1; i < count; i++) {
					System.out.print(rs.getObject(i));
					if(i < count) {
						System.out.print(",");
					}
				}
				System.out.println();
			}
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				if(conn != null) conn.close();
				if(smt != null) smt.close();
				if(rs != null) rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Test
	public void testQuery4() {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			Class.forName(driverClassName);
			conn = DriverManager.getConnection(url, username, password);
			st = conn.createStatement();
			String sql = "select * from t_user2";
			rs = st.executeQuery(sql);
			ResultSetMetaData rsmd = rs.getMetaData();
			int count = rsmd.getColumnCount();
			while(rs.next()) {
				for (int i = 1; i < count; i++) {
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
			try {
				if(conn != null) conn.close();
				if(st != null) st.close();
				if(rs != null) rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	/*
	 * preparedstatement
	 * 使用username和password查询数据
	 * 若查出结果集，说明正确，返回true
	 * 若查不出结果集，说明用户名密码错误，返回false
	 */
	public boolean QueryUser(String _username, String _password) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Class.forName(driverClassName);
			conn = DriverManager.getConnection(url, username, password);
			String sql = "select * from t_user2 where username=? and password=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, _username);
			ps.setString(2, _password);
			rs = ps.executeQuery();
			return rs.next();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn != null) conn.close();
				if(ps != null) ps.close();
				if(rs != null) rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	
	public boolean queryUser2(String _username, String _password) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Class.forName(driverClassName);
			conn = DriverManager.getConnection(url, username, password);
			String sql = "select * from t_user2 where username=? and password=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, _username);
			ps.setString(2, _password);
			rs = ps.executeQuery();
			return rs.next();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn != null) conn.close();
				if(ps != null) ps.close();
				if(rs != null) rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	
	@Test
	public void testQueryUser() {
		String query_username = "harry";
		String query_password = "111";
		boolean flag = queryUser2(query_username, query_password);
		System.out.println(flag);
	}
}
