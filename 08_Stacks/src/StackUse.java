
public class StackUse {

	public static void main(String[] args) throws StackFullException {
		// TODO Auto-generated method stub
		StackUsingArray stack = new StackUsingArray();
		for(int i = 1; i <= 5; i++) {
			stack.push(i);
		}
		
		while(!stack.isEmpty()) {
			try {
				System.out.print(stack.pop() + " ");
			} catch (StackEmptyException e) {
				// Never reach here
			}
		}
		System.out.println();
	}

}
