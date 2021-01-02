import java.util.ArrayList;

public class Map <K, V> {
	// We can not make generic type of array in Java
	ArrayList<MapNode<K, V>> buckets; // Bucket Array
	int size; // number of entries
	int numBuckets; // number of Buckets. Maximum size the Bucket array can have
	public Map() {
		numBuckets = 5;
		buckets = new ArrayList<>();
		for (int i = 0; i < numBuckets; i++) {
			buckets.add(null);
		}
	}
	
	private int getBucketIndex(K key) {
		// Hash Function
		int hashCode = key.hashCode(); // Hash code. Java provides the inbuilt hashcode() function which gives the hash code.
		return hashCode % numBuckets; // Compression function // to keep the hashcode within the range of the number of buckets
	}
	
	public int size() {
		return size;
	}
	
	public V removeKey(K key) {
		int bucketIndex = getBucketIndex(key);
		MapNode<K, V> head = buckets.get(bucketIndex);
		MapNode<K, V> prev = null;
		while (head != null) {
			if (head.key.equals(key)) {
				size--;
				if (prev == null) {
					buckets.set(bucketIndex, head.next);
				} else {
					prev.next = head.next;
				}
				return head.value;
			}
			prev = head;
			head = head.next;
		}
		return null;
	}
	
	public V getValue(K key) {
		int bucketIndex = getBucketIndex(key);
		MapNode<K, V> head = buckets.get(bucketIndex);
		while (head != null) {
			if (head.key.equals(key)) {
				return head.value;
			}
			head = head.next;
		}
		return null;
	}

	public double loadFactor() {
		return (1.0 * size)/numBuckets;
	}
	
	private void rehash() {
		System.out.println("Rehashing: buckets" + numBuckets + " size " + size);
		ArrayList<MapNode<K, V>> temp = buckets;
		buckets = new ArrayList<>();
		for (int i = 0; i < 2*numBuckets; i++) {
			buckets.add(null);
		}
		size = 0;
		numBuckets *= 2;
		for (int i = 0; i < temp.size(); i++) {
			MapNode<K, V> head = temp.get(i);
			while (head != null) {
				K key = head.key;
				V value = head.value;
				insert(key, value);
				head = head.next;
			}
		}
	}

	public void insert(K key, V value) {
		int bucketIndex = getBucketIndex(key);
		MapNode<K, V> head = buckets.get(bucketIndex);
		while (head != null) {
			if (head.key.equals(key)) {
				head.value = value;
				return;
			}
			head = head.next;
		}
		head = buckets.get(bucketIndex);
		MapNode<K, V> newElementNode = new MapNode<K, V>(key , value);
		size++;
		newElementNode.next = head;
		buckets.set(bucketIndex, newElementNode);
		double loadFactor = (1.0*size)/numBuckets;
		if (loadFactor > 0.7) {
			rehash();
		}
	}
}

/*
 * == actually compares the memory address of two objects.
 * For String s which contains the String "abc", "abc" == s can give false if "abc" and s are not stored in the same memory.
 * That's why for comparing two objects always use .equals() method which directly compare the value and not their memory. 
 */

/*
 * Bucket Array Stores the keys.
 * 
 * Hash function gives the index where a particular key will be stored in the Bucket Array.
 * Hash function has two parts: Hash code and Compression.
 * Hash code gives the index and compression function function keeps the hash code inside a particular range, 
 * so that our bucket array does not increase too much and stays within a particular size.
 * 
 * Due to the compression function, it is likely that more than one key will go to the same index which causes collisions in the Hashmap.
 * So, we need to do collision handling. We can do it in two ways:
 * 1. Closed Hashing (Separate Chaining)
 * 2. Open Addressing
 * 
 * Closed Hashing means that both the keys will go to the same index and the bucket must be able to handle more than one entry.
 * A very easy way to implement closed hashing is by making the bucket a array of linked list. i.e, each index in the bucket points to the head of a linked list 
 * and each node of the linked list stores the key-value pairs of each new key.
 * 
 * In open addressing we find the index of the key and check if there is already a key stored at that index. If there is already a key in that address,
 * then we will find an alternate index for our key. There are many ways to find an alternate index for our key.
 * In general we can say,
 * hi(a) = hf(a) + f(i)
 * where, 
 * hi(a) means the ith attempt to relocate our key
 * hf(a) means original hash function or 0th attempt.
 * f(i) is some function of i and f(0) = 0, i.e. for 0th attempt f(i) should be zero.
 * 
 * We need to find f(i). Different kind of open addressing techniques means different f(i).
 * Some open addressing techniques are:
 * 1. Linear Probing [f(i)=i. It probes each index linearly for relocating]
 * 2. Quadratic probing [f(i)=i^2]
 * 3. Double Hashing [f(i)=i*h'(a). Where h'(i) is a different hash function]
 * 
 * In practice, separate chaining works as well as addressing technique. Separate chaining just creates linked list in each index of the bucket.
 * 
 * Load factor means how much load is there on our hashmap.
 * Load factor is defined as (n/b) which means n entries(load) in b boxes. Due to load factor, the time taken is O(n/b).
 * We should keep, n/b < 0.7. Which means that each box must not have very large number of entries.
 * As n/b < 0.7, we can assume that O(n) ~ 1. So, we can say that the time complexity of hashmap is O(1).
 * 
 * To keep n/b < 0.7, i.e. to make sure that the load on the hashmap is not more than 0.7, we need to increase the bucket(b) along with the load(n), so that the number of
 * entries in a single bucket is not much.
 * 
 * The way of making sure that n/b < 0.7, we will do Rehashing. i.e. we will double the bucket size and then again hash all the entries in our new increased size bucket.
 * This will decrease the load factor again as we must keep the load factor small, so that the time complexity remains O(1).
 * 
 * Time complexity is proportional to the size of the linked list in the boxes of the bucket. And to keep the size of the linked list we do rehashing.
 * 
 */










