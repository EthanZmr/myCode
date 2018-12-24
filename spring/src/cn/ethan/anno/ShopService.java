package cn.ethan.anno;

import javax.annotation.Resource;

public class ShopService {
	
	//得到shopDao和OrdersDao对象
	@Resource(name="shopDao")
	private ShopDao shopDao;
	
	@Resource(name="ordersDao")
	private OrdersDao ordersDao;
	
	public void add() {
		System.out.println("service......");
		shopDao.shop();
		ordersDao.buy();
	}
}
