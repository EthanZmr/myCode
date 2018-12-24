package reflect_Arraylist;

import java.lang.reflect.Field;

public class Tool {
	public void setProperty(Object obj, String propertyName, Object value) {
		Class c = obj.getClass();
		try {
			Field field = c.getDeclaredField(propertyName);
			field.setAccessible(true);
			field.set(obj, value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
