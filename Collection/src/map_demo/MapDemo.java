package map_demo;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapDemo {
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("杨过", "小龙女");
		map.put("郭靖", "黄蓉");
		map.put("杨康", "穆念慈");
		
		Set<String> set = map.keySet();
		for (String key : set) {
			String value= map.get(key);
			System.out.println(key+":"+value);
		}
	}
}
