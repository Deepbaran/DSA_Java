package graphs_1;

/*
Given an undirected graph G(V, E) and two vertices v1 and v2(as integers), check if there exists any path between them or not. Print true or false.
V is the number of vertices present in graph G and vertices are numbered from 0 to V-1.
E is the number of edges present in graph G.
*/

import java.util.*;

public class HasPath {
	
	private static boolean print_BFS(int[][] edges, int n, int sv, int ev, boolean[] visited) {
	    // It is similar to level order traversal in tree
	    Queue<Integer> pendingVertices = new LinkedList<>();
	    pendingVertices.add(sv);
	    visited[sv] = true;
	    while(!pendingVertices.isEmpty()) {
	        int currentVertex = pendingVertices.peek();
	        pendingVertices.poll();
	        // cout << currentVertex << " ";
	        for(int i = 0; i < n; i++) {
	            if(i == currentVertex) {
	                continue;
	            }
	            if(edges[currentVertex][i] == 1 && !visited[i]) {
	                if(i == ev) {
	                    return true;
	                }
	                pendingVertices.add(i);
	                visited[i] = true;
	            }
	        }
	    }
	    return false;
	}
	private static boolean BFS(int[][] edges, int n, int v1, int v2) {
	    boolean[] visited = new boolean[n];
	    for(int i = 0; i < n; i++) {
	        visited[i] = false;
	    }
	    return print_BFS(edges, n, v1, v2, visited);
	}

	private static boolean check(int[][] edges, int n) {
		Scanner sc = new Scanner(System.in);
	    int v1 = sc.nextInt(), v2 = sc.nextInt();
	    boolean path = true;
	    if(edges[v1][v2] != 1) { // If v1 and v2 are not directly connected
	        path = BFS(edges, n, v1, v2);
	    }
	    return path;
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

	    System.out.println(check(edges, n));
	}

}
