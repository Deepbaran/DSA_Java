package graphs_1;

import java.util.*;

/*
Given an undirected graph G(V,E), find and print all the connected components of the given graph G.
V is the number of vertices present in graph G and vertices are numbered from 0 to V-1.
E is the number of edges present in graph G.
You need to take input in main and create a function which should return all the connected components. And then print them in the main, not inside function.
Print different components in new line. And each component should be printed in increasing order (separated by space). Order of different components doesn't matter.
*/

public class AllConnectedComponents {

	private static List<Integer> print_DFS(int[][] edges, int n, int sv, boolean[] visited, List<Integer> vec) {
	    vec.add(sv);
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
	            print_DFS(edges, n, i, visited, vec);
	        }
	    }
	    return vec;
	}
	
	private static List<List<Integer>> DFS(int[][] edges, int n) {
	    boolean[] visited = new boolean[n];
	    for(int i = 0; i < n; i++) {
	        visited[i] = false;
	    }
	    List<List<Integer>> v = new ArrayList<>();
	    for(int i = 0; i < n; i++) {
	        if(!visited[i]) {
	        	List<Integer> temp = new ArrayList<>();
	            v.add(print_DFS(edges, n, i, visited, temp));
	            temp.clear();
	        }
	    }
	    return v;
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
	    
	    List<List<Integer>> ans = DFS(edges, n);
	    for(int i = 0; i < ans.size(); i++) {
	        Collections.sort(ans.get(i));
	        for(int j = 0; j < ans.get(i).size(); j++) {
	            System.out.println(ans.get(i).get(j) + " ");
	        }
	        System.out.println();
	    } 
	}

}
