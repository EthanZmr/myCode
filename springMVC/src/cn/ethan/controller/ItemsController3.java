package cn.ethan.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.ethan.model.Items;

/* 注解开发适配器
 * 商品处理器
 */
@Controller
public class ItemsController3{
	//商品查询\
	//一般建议将url和方法名写成一样
	@RequestMapping("/queryItems")
	public ModelAndView queryItems() throws Exception{
		//调用service查询数据库，查询商品列表，这里使用静态数据模拟
		List<Items> list = new ArrayList<Items>();
		Items items_1 = new Items();
		items_1.setName("联想笔记本");
		items_1.setPrice(6000f);
		items_1.setDetail("ThinkPad T430 联想笔记本！");
		
		Items items_2 = new Items();
		items_2.setName("苹果手机");
		items_2.setPrice(5000f);
		items_2.setDetail("iphone6苹果手机！");
		
		list.add(items_1);
		list.add(items_2);
		//创建modelAndView准备填充数据，设置视图
		ModelAndView modelAndView = new ModelAndView();
		//填充数据
		modelAndView.addObject("itemsList",list);
		//视图
		//下边的路径如果在视图解析器中配置前缀和后缀，可以修改为
//		modelAndView.setViewName("/WEB-INF/jsp/items/itemsList.jsp");
		modelAndView.setViewName("items/itemsList");
		return modelAndView;
	}
	
	//商品添加
	

	/*@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//调用service查询数据库，查询商品列表，这里使用静态数据模拟
		List<Items> list = new ArrayList<Items>();
		Items items_1 = new Items();
		items_1.setName("联想笔记本");
		items_1.setPrice(6000f);
		items_1.setDetail("ThinkPad T430 联想笔记本！");
		
		Items items_2 = new Items();
		items_2.setName("苹果手机");
		items_2.setPrice(5000f);
		items_2.setDetail("iphone6苹果手机！");
		
		list.add(items_1);
		list.add(items_2);
		
		//创建modelAndView准备填充数据，设置视图
		ModelAndView modelAndView = new ModelAndView();
		//填充数据
		modelAndView.addObject("itemsList",list);
		//视图
		modelAndView.setViewName("/WEB-INF/jsp/items/itemsList.jsp");
		
		return modelAndView;
	}*/
}
