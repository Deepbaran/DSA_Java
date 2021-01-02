import java.util.Stack;

public class StackCollections {

	public static void main(String[] args) {
		
		Stack<Integer> stack = new Stack<>();
		// top() -> peek()
		
		int arr[] = {5, 2, 8, 1};
		for(int i = 0; i < arr.length; i++) {
			stack.push(arr[i]);
		}
		
		System.out.println(stack.size());
		while(!stack.isEmpty()) {
//			System.out.print(stack.pop() + " "); // pop() returns the element before removing
			System.out.print(stack.peek() + " ");
			stack.pop();
		}
		System.out.println();
		System.out.println(stack.size());

	}

}
