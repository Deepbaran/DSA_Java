package graphs_2;

import java.util.*;

public class Prims_Algorithm {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
	    int e = sc.nextInt();
	    int[][] edges = new int[n][n];

	    for(int i = 0; i < e; i++) {
	        int f = sc.nextInt(), s = sc.nextInt(), weight = sc.nextInt();
	        edges[f][s] = weight;
	        edges[f][s] = weight;
	    }
	    prims(edges, n);
	}

	private static void prims(int[][] edges, int n) {
	    int[] parent = new int[n];
	    int[] weights = new int[n];
	    boolean[] visited = new boolean[n];

	    for(int i = 0; i < n; i++) {
	        visited[i] = false;
	        weights[n] = Integer.MAX_VALUE;
	    }
	    parent[0] = -1;
	    weights[0] = 0;

	    for(int i = 0; i < n; i++) {
	        // Find Min Vertex
	        int minVertex = findMinVertex(weights, visited, n);
	        // minVertex is visited
	        visited[minVertex] = true;
	        // Explore un-visited neighbors
	        for(int j = 0; j < n; j++) {
	            if(edges[minVertex][j] != 0 && !visited[j]) {
	                if(edges[minVertex][j] < weights[j]) {
	                    weights[j] = edges[minVertex][j];
	                    parent[j] = minVertex;
	                }
	            }
	        }
	    }

	    System.out.println();
	    for(int i = 1; i < n; i++) {
	        if(parent[i] < i) {
	        	System.out.println(parent[i] + " " + i + " " + weights[i]);
	        } else {
	        	System.out.println(i + " " + parent[i] + " " + weights[i]);
	        }
	    }
	}
	
	private static int findMinVertex(int[] weights, boolean[] visited, int n) {
	    int minVertex = -1;
	    for(int i = 0; i < n; i++) {
	        if(!visited[i] && (minVertex==-1 || weights[i] < weights[minVertex])) {
	            minVertex = i;
	        }
	    }
	    return minVertex;
	}

}

/*
Time Complexity of findMinVertex: O(n^2) [n times findMinVertex is called which in turn has O(n) time complexity]
Time complexity for exploring un-visited neighbors: O(n^2)
n is number of vertices

We are doing redundant work at exploring un-visited neighbors. To find neighbors, because of using adjacency matrix, we are required to traverse all the columns in a row matrix to find if there is an edge or not. We can save time here by using adjacency list here instead of adjacency matrix.

We can also reduce time for finding minimum vertex by using Priority Queue with the priority on weight. By using priority queue, we can find the minimum vertex faster (O(logn)). But we will need to customize the priority queue as the weights of the vertices might change dusing exploring the un-visited vertices. So, we will need to make changes to our priority queues at that time too.

So, after using priority queue and adjacency list we will get the time complexity O((E + n)logn) from O(n^2)
*/

/*
Prim's is a Greedy algorithm
*/
