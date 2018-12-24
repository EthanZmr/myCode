package cn.ethan.ioc;

public class Book {
	private String bookname;

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	
	public void printBook() {
		System.out.println("Book:" + bookname);
	}
}
