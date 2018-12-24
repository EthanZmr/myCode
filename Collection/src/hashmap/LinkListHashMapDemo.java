package hashmap;

import java.util.LinkedHashMap;
import java.util.Set;
/**
 * LinkedHashMap:map接口的哈希表和链表实现
 * @author ethan
 *
 */
public class LinkListHashMapDemo {
	public static void main(String[] args) {
		LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
		
		map.put("123", "Hello");
		map.put("456", "world");
		map.put("789", "Java");
		
		Set<String> set = map.keySet();
		for (String key : set) {
			String value = map.get(key);
			System.out.println(key + ":" + value);
		}
	}
}
