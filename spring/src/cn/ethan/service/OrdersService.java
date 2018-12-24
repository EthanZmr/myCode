package cn.ethan.service;

import cn.ethan.dao.OrdersDao;

public class OrdersService {
	
	private OrdersDao ordersDao;

	public void setOrdersDao(OrdersDao ordersDao) {
		this.ordersDao = ordersDao;
	}
	//转账
	public void transferAccount(String username1,String username2) {
		//小王少一千
		ordersDao.changeAccount(username1, -1000);
		int i = 10/0;
		//小马多一千
		ordersDao.changeAccount(username2, 1000);
	}
}
