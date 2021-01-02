
public class CheckSorted {

	/*
	 * Steps of approach:
	 * 1. Base Case
	 * 2. Either Processing or Smaller problem solving
	 * 3. Either Smaller problem solving or Processing
	 * 
	 * Processing and Smaller Problem Solving are different. Processing is the work that we are doing in the current recurrence of the function.
	 * We can do it either before the Smaller Problem solving or after it. It depends on the question
	 */
	
	public static boolean checkSorted(int input[]) {
		if(input.length <= 1) {
			return true;
		}
		
		int smallInput[] = new int[input.length - 1];
		for(int i = 1; i < input.length; i++) {
			smallInput[i - 1] = input[i];
		}
		
		// Smaller problem solving
		boolean smallAns = checkSorted(smallInput);
		if(!smallAns) {
			return false;
		}
		
		// processing
		if(input[0] <= input[1]) {
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean checkSorted_2(int input[]) {
		if(input.length <= 1) {
			return true;
		}
		
		// Processing
		if(input[0] > input[1]) {
			return false;
		}
		
		int smallInput[] = new int[input.length - 1];
		for(int i = 1; i < input.length; i++) {
			smallInput[i - 1] = input[i];
		}
		
		// Smaller problem solving
		boolean smallAns = checkSorted_2(smallInput);
		return smallAns;
	}
	
	// This function checks if the array is sorted from startIndex to end
	private static boolean checkSortedBetter(int input[], int startIndex) { // This is our helper function
		if(startIndex >= input.length - 1) {
			return true;
		}
		if(input[startIndex] > input[startIndex + 1]) {
			return false;
		}
		// changing the startIndex for each recurrence is called changing window
		// We are not changing the array. We are changing the window. It saves space
		return checkSortedBetter(input, startIndex + 1);
	}
	
	// function overloading is taking place here
	public static boolean checkSortedBetter(int input[]) {
		return checkSortedBetter(input, 0);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int input[] = {1, 2, 3, 6, 9};
		System.out.println(checkSorted(input));
		System.out.println(checkSorted_2(input));
		System.out.println(checkSortedBetter(input));
	}

}

// Doing dry run at the end is always helpful
