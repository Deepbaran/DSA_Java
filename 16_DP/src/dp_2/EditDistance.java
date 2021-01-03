package dp_2;

/*
Given two strings s and t of lengths m and n respectively, find the Edit Distance between the strings. Edit Distance of two strings is minimum number of steps required to make one string equal to other. In order to do so you can perform following three operations only :
1. Delete a character

2. Replace a character with another one

3. Insert a character
*/

import java.util.Scanner;

public class EditDistance {

	// Brute Force: Time Complexity -> O(3 ^ n)
	private static int editDistance(String s, String t) {
	    if(s.isEmpty() || t.isEmpty()) {
	        return s.length() + t.length();
	    }
	    if(s.charAt(0) == t.charAt(0)) {
	        return editDistance(s.substring(1), t.substring(1));
	    }else {
	        // Insert
	        int x = editDistance(s.substring(1), t) + 1;
	        // Delete
	        int y = editDistance(s, t.substring(1)) + 1;
	        // Replace
	        int z = editDistance(s.substring(1), t.substring(1)) + 1;
	        return Math.min(x, Math.min(y, z));
	    }
	}

	// Memoization
	private static int editDistance_mem_helper(String s, String t, int[][] output) {
	    int m = s.length();
	    int n = t.length();
	    if(s.isEmpty() || t.isEmpty()) {
	        output[m][n] = s.length() + t.length(); 
	        return output[m][n];
	    }
	    if(output[m][n]!=-1) {
	        return output[m][n];
	    }

	    if(s.charAt(0) == t.charAt(0)) {
	        return editDistance_mem_helper(s.substring(1), t.substring(1), output);
	    }else {
	        // Insert
	        int x = editDistance_mem_helper(s.substring(1), t, output) + 1;
	        // Delete
	        int y = editDistance_mem_helper(s, t.substring(1), output) + 1;
	        // Replace
	        int z = editDistance_mem_helper(s.substring(1), t.substring(1), output) + 1;
	        output[m][n] = Math.min(x, Math.min(y, z));
	        return output[m][n];
	    }
	}
	private static int editDistance_mem(String s, String t) {
		int m = s.length();
		int n = t.length();
	    int[][] output = new int[m + 1][];
	    for(int i = 0; i <= m; i++) {
	        output[i] = new int[n + 1];
	        for(int j = 0; j <= n; j++) {
	            output[i][j] = -1;
	        }
	    }
	    int ans = editDistance_mem_helper(s, t, output);
	    return ans;
	}

	// Tabulation
	private static int editDistance_DP(String s, String t) {
	    int m = s.length();
		int n = t.length();
		int[][] output = new int[m+1][];
		for(int i = 0; i <= m; i++) {
			output[i] = new int[n+1];
		}

		// Fill 1st row
		for(int j = 0; j <= n; j++) {
			output[0][j] = j;
		}

		// Fill 1st col
		for(int i = 1; i <= m; i++) {
			output[i][0] = i;
		}

		for(int i = 1; i <= m; i++) {
			for(int j = 1; j <= n; j++) {
				if(s.charAt(i - 1) == t.charAt(j - 1)) {
					output[i][j] = output[i-1][j-1];
				}
				else {
					int a = output[i-1][j];
					int b = output[i][j-1];
					int c = output[i-1][j-1];
					output[i][j] = Math.min(a, Math.min(b, c)) + 1;
				}
			}
		}

		return output[m][n];
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		String t = sc.next();
	    System.out.println(editDistance(s, t));
	    System.out.println(editDistance_mem(s, t));
	    System.out.println(editDistance_DP(s, t));
	}

}
