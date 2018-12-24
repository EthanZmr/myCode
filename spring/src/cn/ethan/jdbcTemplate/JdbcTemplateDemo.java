package cn.ethan.jdbcTemplate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;


public class JdbcTemplateDemo {
	//jdbc底层代码
	@Test
	public void testJdbc() {
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			//加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			//创建连接
			conn = DriverManager.getConnection("jdbc:mysql:///test", "root", "12345678");
			//编写sql语句
			String sql = "select * from t_user2 where username = ?";
			//预编译sql
			psmt = conn.prepareStatement(sql);
			//设置参数
			psmt.setString(1, "lucy");
			rs = psmt.executeQuery();
			//遍历
			while(rs.next()) {
				String username = rs.getString("username");
				String password = rs.getString("password");
				System.out.println(username+":"+password);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				psmt.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	//添加数据
	@Test
	public void add() {
		//创建对象，设置数据库信息
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql:///test");
		dataSource.setUsername("root");
		dataSource.setPassword("12345678");
		
		//创建jdbcTemplate对象
		JdbcTemplate jt = new JdbcTemplate(dataSource);
		
		//调用jdbcTemplate对象里面的方法实现操作
		String sql = "insert into t_user2 values(?,?,?,?)";
		int rows = jt.update(sql, 5,"lucy","250","USA");
		System.out.println(rows);
	}
	//修改数据
	@Test
	public void update() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql:///test");
		dataSource.setUsername("root");
		dataSource.setPassword("12345678");
		
		JdbcTemplate jt = new JdbcTemplate(dataSource);
		
		String sql = "update t_user2 set password = ? where uid = ?";
		int row = jt.update(sql, "888888",5);
		System.out.println(row);
	}
	//删除数据
	@Test
	public void delete() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql:///test");
		dataSource.setUsername("root");
		dataSource.setPassword("12345678");
		
		JdbcTemplate jt = new JdbcTemplate(dataSource);
		String sql = "delete from t_user2 where username = ?";
		int row = jt.update(sql, "lucy");
		System.out.println(row);
	}
	
	//查询数据
	@Test
	public void searchCount() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql:///test");
		dataSource.setUsername("root");
		dataSource.setPassword("12345678");
		
		JdbcTemplate jt = new JdbcTemplate(dataSource);
		
		String sql = "select count(*) from t_user2";
		
		//第二个参数： 返回类型的class
		int count = jt.queryForObject(sql, Integer.class);
		
		System.out.println(count);
	}
	
	//查询返回对象
	@Test
	public void searchObject() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql:///test");
		dataSource.setUsername("root");
		dataSource.setPassword("12345678");
		
		JdbcTemplate jt = new JdbcTemplate(dataSource);
		
		//sql语句
		String sql = "select * from t_user2 where username=?";
		//第二个参数RowMapper 是接口 需要自定义类实现接口，自己做数据封装
		//第三个参数 可变参数
		User user = jt.queryForObject(sql, new MyRowMapper(), "lucy");
		System.out.println(user);
	}
	
	//查询返回list
	@Test
	public void searchList() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql:///test");
		dataSource.setUsername("root");
		dataSource.setPassword("12345678");
		
		JdbcTemplate jt = new JdbcTemplate(dataSource);
		
		String sql = "select * from t_user2";
		List<User> list = jt.query(sql, new MyRowMapper());
		for (User user : list) {
			System.out.println(user);
		}
		
	}
}
