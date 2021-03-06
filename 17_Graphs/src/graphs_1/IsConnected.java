package graphs_1;

import java.util.Scanner;

/*
Given an undirected graph G(V,E), check if the graph G is connected graph or not.
V is the number of vertices present in graph G and vertices are numbered from 0 to V-1.
E is the number of edges present in graph G.
*/

public class IsConnected {

	private static void print_DFS(int[][] edges, int n, int sv, boolean[] visited) {
	    visited[sv] = true; // mark as visited
	    for(int i = 0; i < n; i++) {
	        if(i == sv) {
	            continue;
	        }
	        if(edges[sv][i] == 1) {
	            // Check if i is already been visied or not
	            if(visited[i]) {
	                continue;
	            }
	            // if there is an edge between the starting vertex and i then call print again with i as starting vertex
	            print_DFS(edges, n, i, visited);
	        }
	    }
	}
	private static  boolean DFS(int[][] edges, int n) {
	    boolean[] visited = new boolean[n];
	    for(int i = 0; i < n; i++) {
	        visited[i] = false;
	    }
	    print_DFS(edges, n, 0, visited);
	    boolean isConnected = true;
	    for(int i = 0; i < n; i++) {
	        if(!visited[i])
	            isConnected = false;
	    }
	    return isConnected;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // number of vertices [0...n-1]
	    int e = sc.nextInt(); // number of edges
	    // Creating the adjacency matrix
	    int[][] edges = new int[n][n];
	    // Filling the adjacency matrix with proper edges
	    for(int i = 0; i < e; i++) {
	        int f = sc.nextInt(), s = sc.nextInt(); // first and second vertices
	        // As it is a bidirectional/undirectional graph so it will have edges from first vertices to second vertices and vice-versa
	        edges[f][s] = 1;
	        edges[s][f] = 1;
	    }
	    System.out.println(DFS(edges, n));
	}

}
