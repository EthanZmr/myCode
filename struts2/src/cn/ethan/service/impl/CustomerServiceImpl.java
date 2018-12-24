package cn.ethan.service.impl;

import java.util.List;

import cn.ethan.dao.CustomerDao;
import cn.ethan.dao.impl.CustomerDaoImpl;
import cn.ethan.model.Customer;
import cn.ethan.service.CustomerService;

public class CustomerServiceImpl implements CustomerService{
	private CustomerDao customerDao = new CustomerDaoImpl();

	public List<Customer> findAll() {
		return customerDao.findAll();
	}
	
}
