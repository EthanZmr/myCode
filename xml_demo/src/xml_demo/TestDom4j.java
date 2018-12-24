package xml_demo;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.junit.Test;

public class TestDom4j {
	/**
	 * dom4j查询xml文件中所有name元素的值
	 * @throws DocumentException
	 */
	@Test
	public void getName() throws DocumentException {
		//创建解析器
		SAXReader reader = new SAXReader();
		Document document = reader.read("src/p1.xml");
		Element root = document.getRootElement();
		List<Element> list = root.elements("p1");
		for (Element element : list) {
			Element name = element.element("name");
			String content = name.getText();
			System.out.println(content);
		}
	}
	/*
	 * 查询第一个name元素的值
	 */
	@Test
	public void getFirstName() throws DocumentException {
		SAXReader reader = new SAXReader();
		Document document = reader.read("src/p1.xml");
		Element root = document.getRootElement();
		Element p1 = root.element("p1");
		Element name = p1.element("name");
		System.out.println(name.getText());
	}
	/*
	 * 查询第二个name元素的值
	 */
	@Test
	public void getSecondName() throws DocumentException {
		SAXReader reader = new SAXReader();
		Document document = reader.read("src/p1.xml");
		Element root = document.getRootElement();
		List<Element> list = root.elements("p1");
		Element p2 = list.get(1);
		Element name = p2.element("name");
		System.out.println(name.getText());
	}
	/*
	 * 在第一个p1标签末尾添加一个元素<sex>nv</sex>
	 */
	@Test
	public void addElement() throws DocumentException, IOException {
		SAXReader reader = new SAXReader();
		Document document = reader.read("src/p1.xml");
		Element root = document.getRootElement();
		Element p1 = root.element("p1");
		Element sex = p1.addElement("sex");
		sex.setText("nv");
		//回写xml
		OutputFormat format = OutputFormat.createPrettyPrint();
		XMLWriter writer = new XMLWriter(new FileOutputStream("src/p1.xml"),format);
		writer.write(document);
		writer.close();
	}
	/*
	 * 在特定位置添加元素：在第一个p1下面的age标签之前添加<school>qinghua</school>
	 */
	@Test
	public void addPoint() throws DocumentException, IOException {
		SAXReader reader = new SAXReader();
		Document document = reader.read("src/p1.xml");
		Element root = document.getRootElement();
		Element p1 = root.element("p1");
		List<Element> list = p1.elements();
		Element school = DocumentHelper.createElement("school");
		school.setText("qinghua");
		list.add(1, school);
		OutputFormat format = OutputFormat.createPrettyPrint();
		XMLWriter writer = new XMLWriter(new FileOutputStream("src/p1.xml"),format);
		writer.write(document);
		writer.close();
	}
	/*
	 * 修改第一个p1下面的age元素的值<age>30</age>
	 */
	@Test
	public void updateElement() throws DocumentException, IOException {
		SAXReader reader = new SAXReader();
		Document document = reader.read("src/p1.xml");
		Element root = document.getRootElement();
		Element p1 = root.element("p1");
		Element age = p1.element("age");
		age.setText("30");
		OutputFormat format = OutputFormat.createPrettyPrint();
		XMLWriter writer = new XMLWriter(new FileOutputStream("src/p1.xml"),format);
		writer.write(document);
		writer.close();
	}
	/*
	 * 删除第一个p1下面的<school>qinghua</school>
	 */
	@Test
	public void deleteElement() throws DocumentException, IOException {
		SAXReader reader = new SAXReader();
		Document document = reader.read("src/p1.xml");
		Element root = document.getRootElement();
		Element p1 = root.element("p1");
		Element school = p1.element("school");
		p1.remove(school);
		OutputFormat format = OutputFormat.createPrettyPrint();
		XMLWriter writer = new XMLWriter(new FileOutputStream("src/p1.xml"),format);
		writer.write(document);
		writer.close();
	}
	/*
	 * 获取第一个p1里面的属性id1的值
	 */
	@Test
	public void getAttribute() throws DocumentException {
		SAXReader reader = new SAXReader();
		Document document = reader.read("src/p1.xml");
		Element root = document.getRootElement();
		Element p1 = root.element("p1");
		String value = p1.attributeValue("id1");
		System.out.println(value);
	}
	/*
	 * XPATH：可以直接获取到某个元素
	 */
}
