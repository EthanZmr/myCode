package cn.ethan.ioc;

public class Preperty {
	private String name;
	public Preperty(String name) {
		this.name = name;
	}
	
	public void add() {
		System.out.println("preperty:" + name);
	}
}
