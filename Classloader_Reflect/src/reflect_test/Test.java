package reflect_test;

import java.io.FileReader;
import java.util.Properties;

public class Test {
	public static void main(String[] args) {
		Properties prop = new Properties();
		try {
			FileReader fr = new FileReader("");
			prop.load(fr);
			prop.getProperty("");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
