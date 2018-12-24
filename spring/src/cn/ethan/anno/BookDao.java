package cn.ethan.anno;

import org.springframework.stereotype.Repository;

@Repository(value="bookDao")
public class BookDao {
	public void add() {
		System.out.println("dao......");
	}
}
