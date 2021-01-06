package graphs_1;

/*
Given an undirected graph G(V, E) and two vertices v1 and v2(as integers), find and print the path from v1 to v2 (if exists). Print nothing if there is no path between v1 and v2.
Find the path using BFS and print the shortest path available.
V is the number of vertices present in graph G and vertices are numbered from 0 to V-1.
E is the number of edges present in graph G.
Print the path in reverse order. That is, print v2 first, then intermediate vertices and v1 at last.
Note : Save the input graph in Adjacency Matrix.
*/

import java.util.*;

public class GetPath_BFS {

	private static boolean print_BFS(int[][] edges, int n, int sv, int ev, boolean[] visited, HashMap<Integer, Integer> hm) {
	    // It is similar to level order traversal in tree
	    Queue<Integer> pendingVertices = new LinkedList<>();
	    pendingVertices.add(sv);
	    visited[sv] = true;
	    while(!pendingVertices.isEmpty()) {
	        int currentVertex = pendingVertices.peek();
	        pendingVertices.poll();
	        for(int i = 0; i < n; i++) {
	            if(i == currentVertex) {
	                continue;
	            }
	            if(edges[currentVertex][i] == 1 && !visited[i]) {
	                hm.put(i, currentVertex);
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
	private static boolean BFS(int[][] edges, int n, int sv, int ev, HashMap<Integer, Integer> hm) {
	    boolean[] visited = new boolean[n];
	    for(int i = 0; i < n; i++) {
	        visited[i] = false;
	    }
	    boolean getPath = print_BFS(edges, n, sv, ev, visited, hm);
	    return getPath;
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
		
	    int v1 = sc.nextInt(), v2 = sc.nextInt();
	    HashMap<Integer, Integer> hm = new HashMap<>();
	    int i = v2;
	    if(BFS(edges, n, v1, v2, hm)) {
	        while(i != v1) {
	            System.out.print(i + " ");
	            i = hm.get(i);
	        }
	        System.out.println(v1);;
	    }
	}

}
