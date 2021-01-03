package dp_1;

import java.util.Scanner;

/*
A child is running up a staircase with n steps and can hop either 1 step, 2 steps or 3 steps at a time. 
Implement a method to count how many possible ways the child can run up to the stairs. You need to return all possible number of ways.
Time complexity of your code should be O(n).
*/

public class StairCase {
	
	private static long staircase(int n){
	    long[] ans = new long[n + 1];
	    ans[0] = 1;
	    if(n > 0)
	        ans[1] = 1;
	    if(n > 1)
	        ans[2] = 2;
	    if(n > 3)
	        ans[3] = 4;
	    for(int i = 4; i <= n; i++) {
	        ans[i] = ans[i - 1] + ans[i - 2] + ans[i - 3];
	    }
	    return ans[n];
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		System.out.println(staircase(n));
	}

}
