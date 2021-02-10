import java.util.HashMap;
import java.util.Set;

public class MapUse {

	public static void main(String[] args) {
		
		/*
		 * Java has two inbuilt maps:
		 * 1. TreeMap [Ordered] -> It uses a self-balancing BST which has time complexity of O(logn). It is an interface.
		 * 2. HashMap [Unordered] -> It uses a Hash Table which has time complexity of O(1)
		 * 
		 * There are no duplicate keys in maps.
		 * Inserting data in the same key will overwrite the existing value corresponding to the key in the map
		 */
		
		HashMap<String, Integer> map = new HashMap<>();
		// insert
		map.put("abc", 1);
		map.put("def", 2);
		
		// size
		System.out.println("size: " + map.size());
		
		// check presence
		if(map.containsKey("abc")) {
			System.out.println("Has abc");
		}
		if(map.containsKey("abc1")) {
			System.out.println("Has abc1");
		}
		
		// get Value
		int v = map.get("abc");
		System.out.println(v);
		
		// int v = map.get("abc1"); // will give NullPointerException as key is not present
		// map.get() returns null if the key is not present.
		// and assigning an object with null to another data type or object gives NullPoiterException
		
		// To avoid this situation use the following method
		int v1 = 0;
		if(map.containsKey("abc1")) {
			v1 = map.get("abc1");
		}
		System.out.println(v1);
		
		// remove
		int s = map.remove("abc"); // returns the value of key abc while deleting it
		System.out.println(s);
		
		// Operations on value will be O(n) unlike operations on key that will be O(1)
		if(map.containsValue(2)) {
			System.out.println("has 2 as value");
		}
		
		// iterate
		// We can iterate through all the keys using keyset()
		Set<String> keys = map.keySet(); // keySet() returns all the keys in a data type called Set<T>
		for(String str: keys) { // fast iteration
			System.out.print(str + " ");
		}
		System.out.println();

		HashMap<Integer, Integer> hm = new HashMap<>();
		int[] a = {1,1,2,5,6,2,7,3,10,95};
		for(int i=0;i<a.length;i++) {
			hm.put(a[i], hm.getOrDefault(a[i], 0) + 1);
		}
		System.out.println();
		for(int key: hm.keySet()) {
			System.out.println(key + ": " + hm.get(key));
		}
	}

}
