package com.ethan.demo;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.ethan.domain.City;
import com.ethan.domain.Person;
import com.ethan.domain.Province;
import com.thoughtworks.xstream.XStream;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class Demo {
	
	public List<Province> getProvinceList(){
		Province p1 = new Province();
		p1.setName("北京");
		p1.addCity(new City("东城区", "DongChengQu"));
		p1.addCity(new City("昌平区", "ChangPingQu"));
		
		Province p2 = new Province();
		p2.setName("辽宁");
		p2.addCity(new City("沈阳", "shenYang"));
		p2.addCity(new City("葫芦岛", "huLuDao"));
		
		List<Province> provinceList = new ArrayList<Province>();
		provinceList.add(p1);
		provinceList.add(p2);
		
		return provinceList;
		
	}
	@Test
	public void xstream() {
		List<Province> list = getProvinceList();
		XStream xstream = new XStream();
		//给List类型指定别名为china
		xstream.alias("china", List.class);
		//给Province类型指定别名为province
		xstream.alias("province", Province.class);
		//给City类型指定别名为city
		xstream.alias("city", City.class);
		//把Province类型的name属性，生成<province>的name属性
		xstream.useAttributeFor(Province.class, "name");
		//去除Province类的名为cities的List类型属性
		xstream.addImplicitCollection(Province.class, "cities");
		//让city类的，名为description属性不生成对应的xml元素
		xstream.omitField(City.class, "description");
		String xml = xstream.toXML(list);
		System.out.println(xml);
		
	}
	
	/**
	 * 演示JSON-lib工具
	 */
	@Test
	public void testJson() {
		JSONObject map = new JSONObject();
		map.put("name", "张三");
		map.put("age", 18);
		map.put("sex", "male");
		String str = map.toString();
		System.out.println(str);
	}
	
	//把对象转换成JSONObject对象
	@Test
	public void testJsonPerson() {
		Person p = new Person("lisi",32,"female");
		JSONObject map = JSONObject.fromObject(p);
		System.out.println(map.toString());
	}
	/*
	 * JSONArray
	 */
	@Test
	public void testJsonArray() {
		Person p1 = new Person("zhangsan",23,"male");
		Person p2 = new Person("lisi",32,"female");
		JSONArray list = new JSONArray();
		list.add(p1);
		list.add(p2);
		System.out.println(list.toString());
	}
	
	/*
	 * 原来就有一个list，我们需要把list转换成JSONArray
	 */
	@Test
	public void listToJsonArray() {
		Person p1 = new Person("zhangsan",23,"male");
		Person p2 = new Person("lisi",32,"female");
		List<Person> list = new ArrayList<Person>();
		list.add(p1);
		list.add(p2);
		JSONArray jsonList = JSONArray.fromObject(list);
		System.out.println(jsonList.toString());
	}
}
