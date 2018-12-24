package reflect;
/*
 * 反射：就是通过class文件对象去使用该文件中的成员变量，构造方法，成员方法
 * 
 * class类：
 * 		成员变量：Filed
 * 		构造方法：Constructor
 * 		成员方法：Method
 */
public class ReflectDemo {
	public static void main(String[] args) {
		Person p = new Person();
		Class<? extends Person> c = p.getClass();
		
		Person p2 = new Person();
		Class<? extends Person> c2 = p2.getClass();
		
		System.out.println(p == p2); //false
		System.out.println(c == c2); //true
		
		Class<Person> p3 = Person.class;
		
		try {
			//开发时推荐使用这种
			Class c3 = Class.forName("reflect.Person");
			System.out.println(c == c3);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
