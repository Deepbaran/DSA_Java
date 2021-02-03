
public class StackUsingArray {
	
	private int data[];
	private int top; // is the index of topmost element of stack
	
	public StackUsingArray() {
		data = new int[10];
		top = -1;
	}
	
	public StackUsingArray(int capacity) {
		data = new int[capacity];
		top = -1;
	}
	
	public boolean isEmpty() { // O(1)
		return top == -1;
	}
	
	public int size() { // o(1)
		return top + 1;
	}
	
	public int top() throws StackEmptyException { // O(1)
		if(size() == 0) {
			// StackEmptyException
			StackEmptyException e = new StackEmptyException("Stack is Empty!!!");
			throw e;
		}
		return data[top];
	}
	
	private void doubleCapacity() {
		int temp[] = data;
		data = new int[2 * temp.length];
		for(int i = 0; i <= top; i++) {
			data[i] = temp[i];
		}
	}
	
	public void push(int elem) throws StackFullException { // O(n)
		/* if(size() == data.length) { // with constant capacity
			// Stack Full
			StackFullException e = new StackFullException();
			throw e;
		} */
		
		// Double Capacity of Stack:
		doubleCapacity(); // O(n) for double capacity
		
		top++;
		data[top] = elem;
	}

	public int pop() throws StackEmptyException { // O(1)
		if(size() == 0) {
			// StackEmptyException
			StackEmptyException e = new StackEmptyException();
			throw e;
		}
		int temp = data[top];
		top--;
		return temp;
	}
	
}
