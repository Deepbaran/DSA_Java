import java.util.ArrayList;

public class ArrayListDemo {

	public static void main(String[] args) {
		
		// Dynamic Array
		ArrayList<Integer> list1 = new ArrayList<>();
		/*
		 * In ArrayList first an empty array with a certain capacity(Capacity is Increased to 1.5 times as it is filled) 
		 * Initially the size of the internal array is zero (as it is empty)
		 */
		
		// Size of the ArrayList
		System.out.println(list1.size()); // Array's size is 0
		
		// add element
		list1.add(15);
		list1.add(20);
		list1.add(25);
		System.out.println(list1.size());
		
		// get an element from the list
		System.out.println(list1.get(2)); // 25
		
		// add an element in the array list to a specific index with shifting later elements
		list1.add(2, 50); // 50 will be put in 2nd index and 25 which was in the 2nd position will be shifted to 3rd position
		
		// for each loop
		for(var x:list1) {
			System.out.print(x + " ");
		}
		System.out.println();
		
		// Delete an element in a specific index
		list1.remove(1); // element at index 1 i.e. 20 will be deleted
		
		for(var x:list1) {
			System.out.print(x + " ");
		}
		System.out.println();
		
		// add an element in the array list to a specific index with overwriting that index's current element
		list1.set(1, 100); // Changing the value at index 1
		
		for(var x:list1) {
			System.out.print(x + " ");
		}
		System.out.println();
		
	}

}
