package cn.ethan.anno_dao;

import org.springframework.jdbc.core.JdbcTemplate;

public class OrdersDao {
	
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	//更改账户数据
	public void changeAccount(String username,int money) {
		String sql = "update account set salary = salary+? where username=?";
		jdbcTemplate.update(sql, money,username);
	}
}
