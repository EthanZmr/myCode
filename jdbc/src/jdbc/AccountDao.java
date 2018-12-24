package jdbc;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

public class AccountDao {
	public static void update(String name, double money) throws SQLException {
		QueryRunner qr = new QueryRunner();
		String sql = "update account set balance=? where name=?";
		Object[] params = {money, name};
		Connection conn = JdbcUtils.getConnection();
		qr.update(conn,sql,params);
		JdbcUtilsVersion3.releaseConnection(conn);
		
	}
}
