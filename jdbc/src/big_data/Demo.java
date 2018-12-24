package big_data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.rowset.serial.SerialBlob;

import org.apache.commons.io.IOUtils;
import org.junit.Test;

/*
 * 大数据
 */
public class Demo {
	static String driverClassName = "com.mysql.jdbc.Driver";
	static String url = "jdbc:mysql://localhost:3306/test?characterEncoding=utf-8";
	static String username = "root";
	static String password = "12345678";
	/*
	 * 把文件保存到数据库中去
	 */
	@Test
	public void fun1() throws FileNotFoundException, IOException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			Class.forName(driverClassName);
			conn = DriverManager.getConnection(url, username, password);
			String sql = "insert into tab_bin values(?,?,?)";
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, 2);
			ps.setString(2, "面试题");
			byte[] bys = IOUtils.toByteArray(new FileInputStream("/Users/ethan/Documents/面试题.pages"));
			Blob blob = new SerialBlob(bys);
			ps.setBlob(3, blob);
			ps.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn != null) conn.close();
				if(ps != null) ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	/*
	 * 从数据库中读取文件
	 */
	@Test
	public void fun2() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Class.forName(driverClassName);
			conn = DriverManager.getConnection(url, username, password);
			String sql = "select * from tab_bin";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				Blob blob = rs.getBlob("data");
				
				InputStream in = blob.getBinaryStream();
				FileOutputStream fos = new FileOutputStream("/Users/ethan/Documents/demo/面试题副本.pages");
				int len = 0;
				byte[] bys = new byte[1024];
				while((len = in.read(bys)) != -1) {
					fos.write(bys, 0, len);
				}
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
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
		
	}
}
