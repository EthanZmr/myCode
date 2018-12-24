package dbutils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

public class QR<T> {
	private DataSource dataSource;
	
	public QR() {
		super();
	}
	
	public QR(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	/*
	 *	做insert 、update、delete
	 */
	public int update(String sql,Object... params) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = dataSource.getConnection();//通过连接池得到连接对象
			ps = conn.prepareStatement(sql);//使用sql创建ps
			initParams(ps, params);//设置参数
			return ps.executeUpdate();//执行
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			try {
				if(conn != null) conn.close();
				if(ps != null) ps.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
	}
	
	private void initParams(PreparedStatement ps, Object... params) throws SQLException {
		for (int i = 0; i < params.length; i++) {
			ps.setObject(i+1, params[i]);
		}
	}

	public T query(String sql,RsHandler<T> rs,Object... params) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rst = null;
		try {
			conn = dataSource.getConnection();
			ps = conn.prepareStatement(sql);
			initParams(ps,params);
			rst = ps.executeQuery();
			return rs.handle(rst);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			try {
				if(conn != null) conn.close();
				if(ps != null) ps.close();
				if(rst != null) rst.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
	}
}

//用来把结果集转换成需要的类型
interface RsHandler<T> {
	public T handle(ResultSet rs) throws SQLException;
}
