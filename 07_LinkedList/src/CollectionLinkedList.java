import java.util.LinkedList;

public class CollectionLinkedList {

	public static void main(String[] args) {
		
		// Doubly Linked List Collection
		LinkedList<Integer> list = new LinkedList<Integer>();
		System.out.println(list.size()); // currently list is empty
		
		// add elements at the tail of the doubly linked list
		list.add(10);
		list.add(30);
		list.addLast(40); // add() and addLast() effectively do the same work
		
		// add() by default adds element at the tail of the list
		// But we can add elements at any position we want using add()
		
		// add elements at a specific position in the list
		list.add(2,55);
		
		// add elements at the head of the doubly linked list
		list.addFirst(0);
		
		System.out.println(list.size());
		
		// Print the list
		for(int i=0;i<list.size();i++) {
			System.out.print(list.get(i) + " "); // 0 10 30 55 40
		}
		System.out.println();
		
		System.out.println(list.isEmpty()); // false
		
		/*
		 * Functions for removing elements:
		 * 1. remove(index) <- removes element at a specific position
		 * 2. removeLast() <- removes the tail
		 * 3. removeFirst() <- removes the head
		 * 
		 * Function to convert the doubly Linked List:
		 * 1. toArray()
		 * 2. toString()
		 */
	}

}
