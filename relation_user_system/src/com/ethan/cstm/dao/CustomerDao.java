package com.ethan.cstm.dao;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.ethan.cstm.domain.Customer;

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
	
	public List<Customer> findAll() throws SQLException {
		String sql = "select * from t_customer";
		List<Customer> list = qr.query(sql, new BeanListHandler<Customer>(Customer.class));
		return list;
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

	public List<Customer> search(Customer customer) throws SQLException {
		/*
		 * 1.给出sql语句前半部
		 */
		StringBuilder sql = new StringBuilder("select * from t_customer where 1=1");
		
		List<Object> arrlist = new ArrayList<Object>();
		/*
		 * 2.判断条件，完成向sql中追加where子句
		 */
		String cname = customer.getCname();
		if(cname != null&& !cname.trim().isEmpty()) {
			sql.append(" and cname like ?");
			arrlist.add("%" + cname + "%");
		}
		
		String gender = customer.getGender();
		if(gender != null&& !gender.trim().isEmpty()) {
			sql.append(" and gender=?");
			arrlist.add(gender);
		}
		
		String cellphone = customer.getCellphone();
		if(cellphone != null&& !cellphone.trim().isEmpty()) {
			sql.append(" and cellphone like ?");
			arrlist.add("%" +cellphone + "%");
		}
		
		String email = customer.getEmail();
		if(email != null && !email.trim().isEmpty()) {
			sql.append(" and email like ?");
			arrlist.add("%" + email + "%");
		}
		
		Object[] params = arrlist.toArray();
		String sql_ = sql.toString();
		List<Customer> list = qr.query(sql_, new BeanListHandler<Customer>(Customer.class),params);
		return list;
	}
}
