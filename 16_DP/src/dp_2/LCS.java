package dp_2;

/*LCS: Longest Common Substring*/

import java.util.Scanner;

public class LCS {

	// Brute Force
	private static int lcs(String s, String t) {
	    if(s.isEmpty() || t.isEmpty()) {
	        return 0;
	    }
	    if(s.charAt(0) == t.charAt(0)) 
	        return 1 + lcs(s.substring(1), t.substring(1));
	    int a = lcs(s.substring(1), t);
	    int b = lcs(s, t.substring(1));
	    int c = lcs(s.substring(1), t.substring(1));
	    return Math.max(a, Math.max(b, c));
	}

	// Memoization: Time and Space Complexity -> O(m * n)
	private static int lcs_mem_helper(String s, String t, int[][] output) {
	    if(s.isEmpty() || t.isEmpty()) {
	        return 0;
	    }
	    int m = s.length();
	    int n = t.length();
	    int ans;
	    if(output[m][n] != -1) {
	        return output[m][n];
	    }
	    if(s.charAt(0) == t.charAt(0)) {
	        ans = 1 + lcs_mem_helper(s.substring(1), t.substring(1), output);
	    } else {
	        int a = lcs_mem_helper(s.substring(1), t, output);
	        int b = lcs_mem_helper(s, t.substring(1), output);
	        int c = lcs_mem_helper(s.substring(1), t.substring(1), output);
	        ans = Math.max(a, Math.max(b, c));
	    }
	    output[m][n] = ans;
	    return output[m][n];
	}
	private static int lcs_mem(String s, String t) {
	    int m = s.length();
	    int n = t.length();
	    int[][] output = new int[m + 1][]; // m + 1 Rows
	    for(int i = 0; i <= m; i++) {
	        output[i] = new int[n + 1]; // n + 1 Columns
	        for(int j = 0; j <= n; j++) {
	            output[i][j] = -1;
	        }
	    }
	    int ans = lcs_mem_helper(s, t, output);
	    return ans;
	}

	// Tabulation
	private static int lcs_DP(String s, String t) {
	    int m = s.length();
	    int n = t.length();
	    int[][] output = new int[m + 1][]; // m + 1 Rows
	    for(int i = 0; i <= m; i++) {
	        output[i] = new int[n + 1]; // n + 1 Columns
	        for(int j = 0; j <= n; j++) {
	            output[i][j] = -1;
	        }
	    }
	    output[0][0] = 0;
	    // Fill first row
	    for(int j = 1; j <= n; j++) {
	        output[0][j] = 0;
	    }
	    // FIll first column
	    for(int i = 1; i <= m; i++) {
	        output[i][0] = 0;
	    }
	    for(int i = 1; i <= m; i++) {
	        for(int j = 1; j <= n; j++) {
	            // Check if first character matches
	            if(s.charAt(i - 1) == t.charAt(j - 1)) {
	                output[i][j] = 1 + output[i - 1][j - 1];
	            }else {
	                int a = output[i - 1][j];
	                int b = output[i][j - 1];
	                int c = output[i - 1][j - 1];
	                output[i][j] = Math.max(a, Math.max(b, c));
	            }
	        }
	    }
	    int ans = output[m][n];
	    return ans;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String s = sc.next();
		String t = sc.next();
		System.out.println(lcs(s, t));
		System.out.println(lcs_mem(s, t));
		System.out.println(lcs_DP(s, t));
	}

}
