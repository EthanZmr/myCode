package cn.ethan.jdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MyRowMapper implements RowMapper<User>{

	public User mapRow(ResultSet rs, int num) throws SQLException {
		String username = rs.getString("username");
		String password = rs.getString("password");
		String address = rs.getString("address");
		int id = rs.getInt("uid");
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setAddress(address);
		user.setUid(id);
		return user;
	}

}
