package cn.ethan.ioc;

public class User {
	private String name;
	public void add() {
		System.out.println("add()....");
	}
	public User(String name) {
		this.name = name;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
