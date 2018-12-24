package cn.ethan.anno;

import org.springframework.stereotype.Repository;

@Repository(value="user2")
public class User {
	
	public void add() {
		System.out.println("add()......");
	}
}
