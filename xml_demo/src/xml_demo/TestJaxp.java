package xml_demo;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/*
 * jaxp操作xml
 */
public class TestJaxp {
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		//查询所有name元素的值
		/*
		 * 1.创建解析器工厂
		 * 2.根据解析器工厂创建解析器
		 * 3.解析xml返回document
		 */
		//创建解析器工厂
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		//创建解析器
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		//解析xml
		Document document = builder.parse("src/person.xml");
		//得到name元素
		NodeList list = document.getElementsByTagName("name");
		for (int i = 0; i < list.getLength(); i++) {
			Node nodeName = list.item(i);
			System.out.println(nodeName.getTextContent());
		}
	}
	/*
	 * 查询xml中第一个name元素的值
	 */
	@Test
	public void new_test() throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		Document document = builder.parse("src/person.xml");
		Node node = document.getElementsByTagName("name").item(0);
		String name = node.getTextContent();
		System.out.println(name);
	}
	/*
	 * jaxp增加节点
	 */
	@Test
	public void addNode() throws ParserConfigurationException, SAXException, IOException, TransformerException {
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		Document document = builder.parse("src/person.xml");
		Node node = document.getElementsByTagName("p1").item(0);
		Element sex = document.createElement("sex");
		Text text = document.createTextNode("nv");
		sex.appendChild(text);
		node.appendChild(sex);
		//回写xml
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		transformer.transform(new DOMSource(document), new StreamResult("src/person.xml"));
	}
	/*
	 * jaxp修改节点
	 * 修改第一个p1下面的sex内容是nan
	 */
	@Test
	public void updateNode() throws ParserConfigurationException, SAXException, IOException, TransformerException {
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		Document document = builder.parse("src/person.xml");
		Node node = document.getElementsByTagName("sex").item(0);
		node.setTextContent("nan");
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		transformer.transform(new DOMSource(document), new StreamResult("src/person.xml"));
	}
	/*
	 * jaxp删除sex节点
	 */
	@Test
	public void deleteNode() throws ParserConfigurationException, SAXException, IOException, TransformerException {
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		Document document = builder.parse("src/person.xml");
		NodeList list  = document.getElementsByTagName("sex");
		for (int i = 0; i < list.getLength(); i++) {
			Node nodeSex = list.item(i);
			Node removeNode = nodeSex.getParentNode().removeChild(nodeSex);
			System.out.println(removeNode.getNodeName());
		}
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		transformer.transform(new DOMSource(document), new StreamResult("src/person.xml"));
	}
	/*
	 * jaxp遍历节点
	 */
	@Test
	public void printAllNode() throws SAXException, IOException, ParserConfigurationException {
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		Document document = builder.parse("src/person.xml");
		//编写一个方法实现遍历操作
		listAll(document);
	}
	private void listAll(Node node) {
		if(Node.ELEMENT_NODE == node.getNodeType()) {
			System.out.println(node.getNodeName());
		}
		NodeList list = node.getChildNodes();
		for (int i = 0; i < list.getLength(); i++) {
			Node getNode = list.item(i);
			listAll(getNode);
		}
	}
	/*
	 * sax解析xml
	 */
	@Test
	public void analyzeXml() throws ParserConfigurationException, SAXException, IOException {
		SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
		SAXParser parser = saxParserFactory.newSAXParser();
		//执行parse方法
		parser.parse("src/p1.xml", new MyDefaultHandler());
	}
	/*
	 * 获取所有name元素的值
	 */
	@Test
	public void getName() throws ParserConfigurationException, SAXException, IOException {
		SAXParserFactory saxFactory = SAXParserFactory.newInstance();
		SAXParser saxParser = saxFactory.newSAXParser();
		saxParser.parse("src/p1.xml", new GetNameDefaultHandler());
	}
	/*
	 * 获取第一个name元素的值
	 */
	@Test
	public void getFirstName() throws ParserConfigurationException, SAXException, IOException {
		SAXParserFactory saxFactory = SAXParserFactory.newInstance();
		SAXParser parser = saxFactory.newSAXParser();
		parser.parse("src/p1.xml", new GetFirstNameHandler());
	}
}
class GetFirstNameHandler extends DefaultHandler {
	boolean flag = false;
	int index = 1;
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if(qName.equals("name")) {
			flag = true;
		}
	}
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if(qName.equals("name")) {
			flag = false;
			index++;
		}
	}
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		if(flag&&index==1) {
			System.out.println(new String(ch,start,length));
		}
	}
}


class MyDefaultHandler extends DefaultHandler{
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		System.out.print("<" + qName + ">");
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		System.out.print("</" + qName + ">");
	}
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		System.out.print(new String(ch,start,length));
	}
}

class GetNameDefaultHandler extends DefaultHandler {
	boolean flag = false;
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if(qName.equals("name")) {
			flag = true;
		}
	}
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if(qName.equals("name")) {
			flag = false;
		}
	}
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		if(flag) {
			System.out.println(new String(ch,start,length));
		}
	}
}