package jdbc;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

public class TxQueryRunner extends QueryRunner{

	@Override
	public int[] batch(String sql, Object[][] params) throws SQLException {
		/*
		 * 1.得到连接
		 * 2.执行父类方法
		 * 3.释放连接
		 * 4.返回值
		 */
		Connection conn = JdbcUtilsVersion3.getConnection();
		int[] result = super.batch(conn, sql, params);
		JdbcUtilsVersion3.releaseConnection(conn);
		return result;
	}

	@Override
	public <T> T query(String sql, Object param, ResultSetHandler<T> rsh) throws SQLException {
		Connection conn = JdbcUtilsVersion3.getConnection();
		T result = super.query(conn, sql, param, rsh);
		JdbcUtilsVersion3.releaseConnection(conn);
		return result;
	}

	@Override
	public <T> T query(String sql, Object[] params, ResultSetHandler<T> rsh) throws SQLException {
		Connection conn = JdbcUtilsVersion3.getConnection();
		T result = super.query(conn, sql, params, rsh);
		JdbcUtilsVersion3.releaseConnection(conn);
		return result;
	}

	@Override
	public <T> T query(String sql, ResultSetHandler<T> rsh, Object... params) throws SQLException {
		Connection conn = JdbcUtilsVersion3.getConnection();
		T result = super.query(conn, sql, rsh, params);
		JdbcUtilsVersion3.releaseConnection(conn);
		return result;
	}

	@Override
	public <T> T query(String sql, ResultSetHandler<T> rsh) throws SQLException {
		Connection conn = JdbcUtilsVersion3.getConnection();
		T result = super.query(conn, sql, rsh);
		JdbcUtilsVersion3.releaseConnection(conn);
		return result;
	}

	@Override
	public int update(String sql) throws SQLException {
		Connection conn = JdbcUtilsVersion3.getConnection();
		int result = super.update(conn, sql);
		JdbcUtilsVersion3.releaseConnection(conn);
		return result;
	}

	@Override
	public int update(String sql, Object param) throws SQLException {
		Connection conn = JdbcUtilsVersion3.getConnection();
		int result = super.update(conn, sql, param);
		JdbcUtilsVersion3.releaseConnection(conn);
		return result;
	}

	@Override
	public int update(String sql, Object... params) throws SQLException {
		Connection conn = JdbcUtilsVersion3.getConnection();
		int result = super.update(conn, sql, params);
		JdbcUtilsVersion3.releaseConnection(conn);
		return result;
	}
	
}