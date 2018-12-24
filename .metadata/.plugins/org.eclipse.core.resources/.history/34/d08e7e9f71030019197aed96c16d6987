package com.ethan.cstm.service;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.List;

import com.ethan.cstm.dao.CustomerDao;
import com.ethan.cstm.domain.Customer;

public class CustomerService {
	private CustomerDao customerDao = new CustomerDao();
	
	public void add(Customer c) throws SQLException, UnsupportedEncodingException {
		customerDao.addCustomer(c);
	}
	
	public List<Customer> findAll() throws SQLException {
		return customerDao.findAll();
	}
	
	public Customer findByCid(String cid) throws SQLException {
		return customerDao.findByCid(cid);
	}

	public void edit(Customer cstm) throws SQLException {
		customerDao.edit(cstm);
	}

	public void delete(String cid) throws SQLException {
		customerDao.delete(cid);
	}

	public List<Customer> search(Customer customer) throws SQLException {
		return customerDao.search(customer);
	}
}
