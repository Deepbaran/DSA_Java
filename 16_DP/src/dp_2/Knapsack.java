package dp_2;

/*
Knapsack: 
A thief robbing a store and can carry a maximal weight of W into his knapsack. There are N items and ith item weigh wi and is value vi. What is the maximum value V, that thief can take ?
Input Format :
Line 1 : N i.e. number of items
Line 2 : N Integers i.e. weights of items separated by space
Line 3 : N Integers i.e. values of items separated by space
Line 4 : Integer W i.e. maximum weight thief can carry
*/

import java.util.Scanner;

public class Knapsack {

	// Brute Force
	private static int knapsack(int[] weight, int[] values, int n, int maxWeight, int w, int v) {
	    // Base case
		if(n == 0 || maxWeight == 0) {
			return 0;
		}

		if(weight[w] > maxWeight) {
			return knapsack(weight, values, n - 1, maxWeight, w + 1, v + 1);
		}

		// Recursive calls
		int x = knapsack(weight, values, n - 1, maxWeight - weight[w], w + 1, v + 1) + values[v];
		int y = knapsack(weight, values, n - 1, maxWeight, w + 1, v + 1);

		return Math.max(x, y);
	}

	// Memoization
	private static int knapsack_mem_helper(int[] weights, int[] values, int n, int maxWeight, int[][] output) {
	    // Base case
		if(maxWeight <= 0 || n==0) {
	        if(maxWeight < 0)
	            return -values[n];
	        return 0;
	    }
	    if(output[n][maxWeight] == -1)
	        output[n][maxWeight] = Math.max((values[n - 1] + knapsack_mem_helper(weights, values, n - 1, maxWeight - weights[n - 1], output)),
	                knapsack_mem_helper(weights, values, n - 1, maxWeight, output));
	    return output[n][maxWeight];
	}
	private static int knapsack_mem(int[] weight, int[] values, int n, int maxWeight) {
	    int[][] output = new int[n + 1][];
	    for(int i = 0; i <= n; i++) {
	        output[i] = new int[maxWeight + 1];
	        for(int j = 0; j <= maxWeight; j++) {
	            output[i][j] = -1;
	        }
	    }
	    return knapsack_mem_helper(weight, values, n, maxWeight, output);
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] weight = new int[n];
		int[] values = new int[n];

		for(int i = 0; i < n; i++){
			weight[i] = s.nextInt();
		}

		for(int i = 0; i < n; i++){
			values[i] = s.nextInt();
		}

		int maxWeight = s.nextInt();

		System.out.println(knapsack(weight, values, n, maxWeight, 0, 0));
	    System.out.println(knapsack_mem(weight, values, n, maxWeight));
	}

}
