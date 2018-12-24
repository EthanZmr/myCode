package reflect;

public class NewReflectDemo {
	private static String string;
	
	public static void main(String[] args) {
		try {
			setString("reflect.Person");
			@SuppressWarnings("unchecked")
			Class<Person> clazz = (Class<Person>) Class.forName(getString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String getString() {
		return string;
	}

	public static void setString(String string) {
		NewReflectDemo.string = string;
	}
	
	
}
