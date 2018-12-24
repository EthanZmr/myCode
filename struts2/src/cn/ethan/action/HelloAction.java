package cn.ethan.action;
/*
 * 1.访问Servlet时，都会执行service方法
 * 2.访问action时，都会默认执行execute方法
 * 		配置action访问路径
 * 3.action的编写方式
 * 		1.创建普通类 这个类不继承任何类 不实现任何接口
 * 		2.常见类 实现Action接口
 * 		3.创建类 继承ActionSupport类
 */
public class HelloAction {
	public String execute() {
		return "hello";
	}
}
