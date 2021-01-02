import java.util.LinkedList;
import java.util.Queue;

public class QueueCollections {
	public static void main(String[] args) {
		/*
		 * Queue<T> is actually an interface.
		 * So, we will need to implement all the methods of Queue manually.
		 * But, the LinkedList<T> class implements all the methods of Queue<T> for us
		 * 
		 * As Queue is an interface so we cannot create it's object but we can use its reference.
		 * We need to make the reference of Queue point to the object of the LinkedList class.
		 */
		Queue<Integer> queue = new LinkedList<>();
		
		// enqueue() -> add()
		queue.add(10); 
		queue.add(20);
		
		// dequeue() -> poll()
		System.out.println(queue.poll());
		
		// size() -> size()
		System.out.println(queue.size());
		
		// front() -> peek()
		System.out.println(queue.peek());
		
		// isEmpty() -> isEmpty()
		System.out.println(queue.isEmpty());
		
	}
}
