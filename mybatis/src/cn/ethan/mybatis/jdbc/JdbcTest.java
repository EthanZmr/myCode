package cn.ethan.mybatis.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcTest {
	public static void main(String[] args) {
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?characterEncoding=utf-8", "root", "12345678");
			String sql = "select * from user where username = ?";
			ps = connection.prepareStatement(sql);
			ps.setString(1,"王五");
			rs = ps.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getString("id") + ":" + rs.getString("username"));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
}
