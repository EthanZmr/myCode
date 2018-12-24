package cn.ethan.ioc;

public class PropertyDemo {
	private String pname;

	public void setPname(String pname) {
		this.pname = pname;
	}
	
	public void test1() {
		System.out.println("Property:"+pname);
	}
}
