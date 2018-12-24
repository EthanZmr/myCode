package transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.Test;

public class Transaction {
	static String driverClassName = "com.mysql.jdbc.Driver";
	static String url = "jdbc:mysql://localhost:3306/test?characterEncoding=utf-8";
	static String username = "root";
	static String password = "12345678";
	
	@Test
	public void testRansaction() {
		testTransaction1("小王","小马",1000);
	}
	
	/*
	 * 转账事务
	 */
	public void testTransaction1(String source_username, String target_username, double money) {
		Connection conn = null;
		try {
			Class.forName(driverClassName);
			conn = DriverManager.getConnection(url, username, password);
			//开启事务
			conn.setAutoCommit(false);
			
			updateBanlance(conn,source_username, -money);
			updateBanlance(conn,target_username, money);
			
			conn.commit();
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			throw new RuntimeException(e);
		} finally {
			try {
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	/*
	 * 修改指定用户的余额
	 */
	public void updateBanlance(Connection conn, String ac_username, double banlance) {
		PreparedStatement ps = null;
		try {
			String sql = "update account set salary=salary+? where username=?";
			ps = conn.prepareStatement(sql);
			
			ps.setDouble(1, banlance);
			ps.setString(2, ac_username);
			
			ps.executeUpdate();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
}
