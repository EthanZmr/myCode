package com.ethan.cstm.test;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import com.ethan.cstm.dao.CustomerDao;
import com.ethan.cstm.domain.Customer;

import cn.itcast.commons.CommonUtils;

public class Demo {
	@Test
	public void fun() throws UnsupportedEncodingException, SQLException {
		CustomerDao customerDao = new CustomerDao();
		for (int i = 1; i <= 300; i++) {
			Customer customer = new Customer();
			customer.setCid(CommonUtils.uuid());
			customer.setCname("cstm_" + i);
			customer.setBirthday("8021-12-18");
			customer.setGender(i%2==0?"男":"女");
			customer.setCellphone("159"+i);
			customer.setEmail("cstm_" + i + "@163.com");
			customer.setDescription("我是客户" + i);
			customerDao.addCustomer(customer);
		}
	}
}
