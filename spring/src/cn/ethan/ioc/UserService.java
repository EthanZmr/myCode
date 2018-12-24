package cn.ethan.ioc;

public class UserService {
	
	private UserDao userdao;
	
	public void setUserdao(UserDao userdao) {
		this.userdao = userdao;
	}



	public void add() {
		System.out.println("service......");
		userdao.add();
	}
}
