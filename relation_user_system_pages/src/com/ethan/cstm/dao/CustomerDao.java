package com.ethan.cstm.dao;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.ethan.cstm.domain.Customer;
import com.ethan.cstm.domain.PageBean;

import cn.itcast.jdbc.TxQueryRunner;

public class CustomerDao {
	private QueryRunner qr = new TxQueryRunner();
	/*
	 * 添加客户
	 */
	public void addCustomer(Customer customer) throws SQLException, UnsupportedEncodingException {
		String sql = "insert into t_customer values(?,?,?,?,?,?,?)";
		Object[] params = {customer.getCid(),customer.getCname(),customer.getGender(),
				customer.getBirthday(),customer.getCellphone(),customer.getEmail(),
				customer.getDescription()};
		qr.update(sql,params);
	}
	
	public PageBean<Customer> findAll(int pageCode, int pageSize) throws SQLException {
		/*
		 * 1.创建PageBean对象
		 * 2.这是pageBean的pc和ps
		 * 3.得到totalRecord，设置给pageBean
		 * 4.得到beanList，设置给pageBean
		 * 5.返回pageBean
		 */
		PageBean<Customer> pageBean = new PageBean<Customer>();
		pageBean.setPageCode(pageCode);
		pageBean.setPageSize(pageSize);
		/*
		 * 得到totalRecord
		 */
		String sql = "select count(*) from t_customer";
		Number number = (Number) qr.query(sql, new ScalarHandler());
		int totalRecord = number.intValue();
		pageBean.setTotalRecord(totalRecord);
		/*
		 * 得到beanList
		 */
		sql = "select * from t_customer order by cname limit ?,?";
		List<Customer> beanList = qr.query(sql, 
				new BeanListHandler<Customer>(Customer.class),
				(pageCode-1)*pageSize,pageSize);
		pageBean.setBeanList(beanList);
		return pageBean;
	}
	
	public Customer findByCid(String cid) throws SQLException {
		String sql = "select * from t_customer where cid=?";
		Object[] param = {cid};
		return qr.query(sql, new BeanHandler<Customer>(Customer.class),cid);
	}

	public void edit(Customer cstm) throws SQLException {
		String sql = "update t_customer set cname=?, gender=?, birthday=?, cellphone=?, email=?, description=? where cid=?";
		Object[] params = {cstm.getCname(),cstm.getGender(),cstm.getBirthday(),
				cstm.getCellphone(),cstm.getEmail(),cstm.getDescription(),cstm.getCid()};
		qr.update(sql,params);
	}

	public void delete(String cid) throws SQLException {
		String sql = "delete from t_customer where cid=?";
		Object[] param = {cid};
		qr.update(sql, param);
	}

//	public PageBean<Customer> search(Customer customer) throws SQLException {
//		/*
//		 * 1.给出sql语句前半部
//		 */
//		StringBuilder sql = new StringBuilder("select * from t_customer where 1=1");
//		
//		List<Object> arrlist = new ArrayList<Object>();
//		/*
//		 * 2.判断条件，完成向sql中追加where子句
//		 */
//		String cname = customer.getCname();
//		if(cname != null&& !cname.trim().isEmpty()) {
//			sql.append(" and cname like ?");
//			arrlist.add("%" + cname + "%");
//		}
//		
//		String gender = customer.getGender();
//		if(gender != null&& !gender.trim().isEmpty()) {
//			sql.append(" and gender=?");
//			arrlist.add(gender);
//		}
//		
//		String cellphone = customer.getCellphone();
//		if(cellphone != null&& !cellphone.trim().isEmpty()) {
//			sql.append(" and cellphone like ?");
//			arrlist.add("%" +cellphone + "%");
//		}
//		
//		String email = customer.getEmail();
//		if(email != null && !email.trim().isEmpty()) {
//			sql.append(" and email like ?");
//			arrlist.add("%" + email + "%");
//		}
//		
//		Object[] params = arrlist.toArray();
//		String sql_ = sql.toString();
//		List<Customer> list = qr.query(sql_, new BeanListHandler<Customer>(Customer.class),params);
//		return list;
//	}
	public PageBean<Customer> search(Customer customer, int pageCode, int pageSize) throws SQLException {
		/*
		 * 1.创建pageBean对象
		 * 2.设置已有属性 pageCode和pageSize
		 * 3.得到totalRecord
		 * 4.得到BeanList
		 */
		PageBean<Customer> pageBean = new PageBean<Customer>();
		pageBean.setPageCode(pageCode);
		pageBean.setPageSize(pageSize);
		
		StringBuilder cntSql = new StringBuilder("select count(*) from t_customer");
		StringBuilder whereSql = new StringBuilder(" where 1=1");
		
		List<Object> arrlist = new ArrayList<Object>();
		/*
		 * 2.判断条件，完成向sql中追加where子句
		 */
		String cname = customer.getCname();
		if(cname != null&& !cname.trim().isEmpty()) {
			whereSql.append(" and cname like ?");
			arrlist.add("%" + cname + "%");
		}
		
		String gender = customer.getGender();
		if(gender != null&& !gender.trim().isEmpty()) {
			whereSql.append(" and gender=?");
			arrlist.add(gender);
		}
		
		String cellphone = customer.getCellphone();
		if(cellphone != null&& !cellphone.trim().isEmpty()) {
			whereSql.append(" and cellphone like ?");
			arrlist.add("%" +cellphone + "%");
		}
		
		String email = customer.getEmail();
		if(email != null && !email.trim().isEmpty()) {
			whereSql.append(" and email like ?");
			arrlist.add("%" + email + "%");
		}
		
		Object[] params = arrlist.toArray();
		String sql_ = cntSql.append(whereSql).toString();
		
		Number number = (Number)qr.query(sql_, new ScalarHandler(),params);
		int totalRecord = number.intValue();
		pageBean.setTotalRecord(totalRecord);
		
		/*
		 * 得到BeanList
		 */
		StringBuilder sql = new StringBuilder("select * from t_customer");
		StringBuilder limitSql = new StringBuilder(" limit ?,?");
		arrlist.add((pageCode - 1)*pageSize);
		arrlist.add(pageSize);
		Object[] _params = arrlist.toArray();
		String _sql = sql.append(whereSql).append(limitSql).toString();
		
		List<Customer> beanList = qr.query(_sql, new BeanListHandler<Customer>(Customer.class),_params);
		pageBean.setBeanList(beanList);
		return pageBean;
	}

}
