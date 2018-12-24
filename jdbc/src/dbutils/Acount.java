package dbutils;

public class Acount {
	private int id;
	private String username;
	private int salary;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public Acount(int id, String username, int salary) {
		super();
		this.id = id;
		this.username = username;
		this.salary = salary;
	}
	public Acount() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Acount [id=" + id + ", username=" + username + ", salary=" + salary + "]";
	}
	
}
