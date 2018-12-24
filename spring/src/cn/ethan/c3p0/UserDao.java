package cn.ethan.c3p0;

import org.springframework.jdbc.core.JdbcTemplate;

public class UserDao {
	
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void add() {
		//得到jdbc模版对象
		String sql = "insert into t_user2 values(?,?,?,?)";
		jdbcTemplate.update(sql, 2,"harry","111","中国");
	}
}
