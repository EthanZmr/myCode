package cn.ethan.dao;

import java.io.FileOutputStream;
import java.io.IOException;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import cn.ethan.model.User;

public class UserDao {
	private String path = "/Users/ethan/eclipse-workspace/regist_login/src/users.xml";
	
	public User findByUserName(String username) {
		SAXReader reader = new SAXReader();
		try {
			Document document = reader.read(path);
			Element element = (Element) document.selectSingleNode("//user[@username='" + username + "']");
			if(element == null) {
				return null;
			}
			User user = new User();
			String attrUsername = element.attributeValue("username");
			String attrPassword = element.attributeValue("password");
			user.setUsername(attrUsername);
			user.setPassword(attrPassword);
			return user;
		} catch (DocumentException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	public void add(User user) {
		SAXReader reader = new SAXReader();
		XMLWriter writer = null;
		try {
			Document document = reader.read(path);
			Element root = document.getRootElement();
			Element userEle = root.addElement("user");
			userEle.addAttribute("username", user.getUsername());
			userEle.addAttribute("password", user.getPassword());
			OutputFormat format = OutputFormat.createPrettyPrint();
			writer = new XMLWriter(new FileOutputStream(path),format);
			writer.write(document);
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			if(writer != null) {
				try {
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
