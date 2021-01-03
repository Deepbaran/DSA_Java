package dp_2;

/*
Given an integer matrix of size m*n, you need to find out the value of minimum cost to reach from the cell (0, 0) to (m-1, n-1).
From a cell (i, j), you can move in three directions : (i+1, j), (i, j+1) and (i+1, j+1).
Cost of a path is defined as the sum of values of each cell through which path passes.
*/

import java.util.Scanner;

public class MinCostPath {

	// Brute Force
	private static int minCostPathHelper(int[][] input, int m, int n, int i, int j) {
	    if(i == m-1 && j == n-1) {
	        return input[i][j];
	    }
	    int x = Integer.MAX_VALUE, y = Integer.MAX_VALUE, z = Integer.MAX_VALUE;
	    if(i < m - 1)
	        x = minCostPathHelper(input, m, n, i + 1, j);
	    if(j < n - 1) 
	        y = minCostPathHelper(input, m, n, i, j + 1);
	    if(i < m - 1 && j < n - 1) 
	        z = minCostPathHelper(input, m, n, i + 1, j + 1);
	    return input[i][j] + Math.min(x, Math.min(y, z));
	}

	private static int minCostPath(int[][] input, int m, int n) {
	    return minCostPathHelper(input, m, n, 0, 0);
	}


	// Memoization
	private static int minCostPath_Mem_Helper(int[][] input, int m, int n, int i, int j, int[][] output){
	    if(i == m-1 && j == n-1) {
	        return input[i][j];
	    }
	    if(i >= m || j >= n) {
	        return Integer.MAX_VALUE;
	    }
	    if(output[i][j]!=-1) {
	        return output[i][j];
	    }
	    int x = minCostPath_Mem_Helper(input, m, n, i + 1, j, output);
	    int y = minCostPath_Mem_Helper(input, m, n, i, j + 1, output);
	    int z = minCostPath_Mem_Helper(input, m, n, i + 1, j + 1, output);
	    output[i][j] = input[i][j] + Math.min(x, Math.min(y, z));
	    return output[i][j];
	}

	private static int minCostPath_Mem(int[][] input, int m, int n) {
	    int[][] output = new int[m][];
	    for(int i = 0; i < m; i++) {
	        output[i] = new int[n];
	    }
	    for(int i = 0; i < m; i++) {
	        for(int j = 0; j < n; j++) {
	            output[i][j] = -1;
	        }
	    }
	    return minCostPath_Mem_Helper(input, m, n, 0, 0, output);
	}

	// Tabulation
	private static int minCostPath_DP(int[][] input, int m, int n) {
	    int[][] output = new int[m][];
	    for(int i = 0; i < m; i++) {
	        output[i] = new int[n];
	    }
	    for(int i = 0; i < m; i++) {
	        for(int j = 0; j < n; j++) {
	            output[i][j] = -1;
	        }
	    }

	    // Fill the last cell i.e. destination
	    output[m - 1][n - 1] = input[m - 1][n - 1];
	    // FIll last row (right to left)
	    for(int j = n - 2; j >= 0; j--) {
	        output[m - 1][j] = output[m - 1][j + 1] + input[m - 1][j];
	    }
	    // Fill last column (bottom to top)
	    for(int i = m - 2; i >= 0; i--) {
	        output[i][n - 1] = output[i + 1][n - 1] + input[i][n - 1];
	    }
	    // Fill remaining cells
	    for(int i = m - 2; i >= 0; i--) {
	        for(int j = n - 2; j >= 0; j--) {
	            output[i][j] = Math.min(output[i][j + 1], Math.min(output[i + 1][j + 1], output[i + 1][j])) + input[i][j];
	        }
	    }
	    return output[0][0];
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

	    int m = s.nextInt(); // m -> row
	    int n = s.nextInt(); // n -> column
	    int[][] arr = new int[m][];
	    for(int i = 0; i < m; i++) {
	        arr[i] = new int[n];
	    }
	    for(int i = 0; i < m; i++) {
	        for(int j = 0; j < n; j++) {
	            arr[i][j] = s.nextInt();
	        }
	    }
	    System.out.println(minCostPath(arr, m, n));
	    System.out.println(minCostPath_Mem(arr, m, n));
	    System.out.println(minCostPath_DP(arr, m, n));
	}

}
