
public class QueueUse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QueueUsingArray queue = new QueueUsingArray();
		for(int i = 1; i <= 5; i++) {
			try {
				queue.enqueue(i);
			} catch (QueueFullException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		while(!queue.isEmpty()) {
			try {
				System.out.println(queue.dequeue());
			} catch (QueueEmptyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		QueueUsingLL<Integer> queuell = new QueueUsingLL<>();
		for(int i = 1; i <= 5; i++) {
			queuell.enqueue(i);
		}
		
		while(!queuell.isEmpty()) {
			try {
				System.out.println(queuell.dequeue());
			} catch (QueueEmptyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
