package hashmap;

import java.util.HashMap;
import java.util.Set;

public class HashMapDemo {
	public static void main(String[] args) {
		HashMap<String,String> map = new HashMap<String, String>();
		
		map.put("it001", "马云");
		map.put("it002", "马化腾");
		map.put("it003", "乔布斯");
		map.put("it004", "张朝阳");
		map.put("it005", "裘伯君");
		map.put("it006", "比尔盖茨");
		
		Set<String> set = map.keySet();
		for (String key : set) {
			String value = map.get(key);
			System.out.println(key + ":" + value);
		}
	}
}
