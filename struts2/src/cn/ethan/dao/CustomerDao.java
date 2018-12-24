package cn.ethan.dao;

import java.util.List;

import cn.ethan.model.Customer;

public interface CustomerDao {

	public List<Customer> findAll();

}
