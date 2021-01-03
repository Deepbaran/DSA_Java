package dp_1;

import java.util.Scanner;

/*
Given a positive integer n, find the minimum number of steps s, that takes n to 1. You can perform any one of the following 3 steps.
1.) Subtract 1 from it. (n= n - ­1) ,
2.) If its divisible by 2, divide by 2.( if n%2==0, then n= n/2 ) ,
3.) If its divisible by 3, divide by 3. (if n%3 == 0, then n = n / 3 ). 
The time complexity of your code should be O(n).
*/

public class MinSteps {

	// Brute-force
	private static int minSteps(int n) {
	    // Base case
	    if(n <= 1) {
	        return 0;
	    }

	    // recursive call
	    int x = minSteps(n - 1);
	    int y = Integer.MAX_VALUE;
	    int z = Integer.MAX_VALUE;
	    if(n % 2 == 0) {
	        y = minSteps(n / 2);
	    }
	    if(n % 3 == 0) {
	        z = minSteps(n / 3);
	    }

	    // calculate final output
	    int ans = Math.min(x, Math.min(y, z));
	    return 1 + ans;
	}

	// MEMOIZATION
	private static int minStepsHelper(int n, int[] ans) {
		// Base case
		if(n <= 1) {
			return 0;
		}

		// Check if output already exists
		if(ans[n] != -1) {
			return ans[n];
		}

		// Calculate output
		int x = minStepsHelper(n - 1, ans);

		int y = Integer.MAX_VALUE, z = Integer.MAX_VALUE;
		if(n % 2 == 0) {
			y = minStepsHelper(n/2, ans);
		}

		if(n % 3 == 0) {
			z = minStepsHelper(n/3, ans);
		}

		int output = Math.min(x, Math.min(y, z)) + 1;

		// Save output for future use
		ans[n] = output;

		return output;

	}

	private static int minSteps_2(int n) {
		int[] ans = new int[n+1];

		for(int i = 0; i <= n; i++) {
			ans[i] = -1;
		}

		return minStepsHelper(n, ans);
	}


	// DP
	private static int minSteps_3(int n) {
	    int[] ans = new int[n + 1];
	    ans[1] = 1;
	    ans[2] = 1;
	    ans[3] = 1;
	    for(int i = 4; i <= n; i++) {
	        int x = ans[i - 1];
	        int y = Integer.MAX_VALUE;
	        int z = Integer.MAX_VALUE;
	        if(i % 2 == 0) {
	            y = ans[i/2];
	        }
	        if(i % 3 == 0) {
	            z = ans[i/3];
	        }
	        ans[i] = Math.min(x, Math.min(y, z)) + 1;        
	    }
	    return ans[n];
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
	    System.out.println(minSteps_3(n));
	}

}
