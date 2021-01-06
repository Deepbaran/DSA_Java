package graphs_1;

/*
Given an undirected graph G(V, E) and two vertices v1 and v2(as integers), find and print the path from v1 to v2 (if exists). Print nothing if there is no path between v1 and v2.
Find the path using DFS and print the first path that you encountered.
V is the number of vertices present in graph G and vertices are numbered from 0 to V-1.
E is the number of edges present in graph G.
Print the path in reverse order. That is, print v2 first, then intermediate vertices and v1 at last.
Note : Save the input graph in Adjacency Matrix.
*/

import java.util.*;

public class GetPath_DFS {

	private static List<Integer> DFS(int[][] edges, int n, int sv, int ev, boolean[] visited) {
		List<Integer> vec = new ArrayList<>();
	    visited[sv] = true;
	    if(sv == ev) {
	        vec.add(sv);
	        return vec;
	    }
	    for(int i = 0; i < n; i++) {
	        if(i == sv) {
	            continue;
	        } else {
	    		if(edges[sv][i] == 1 && !visited[i]) {
	                vec = DFS(edges, n, i, ev, visited);
	                if(vec.size() != 0) {
	                    vec.add(sv);
	                    return vec;
	                }
	            }
	        }
	    }
	    return vec;
	}

	private static List<Integer> getPath(int[][] edges, int n) {
		Scanner sc = new Scanner(System.in);
	    boolean[] visited = new boolean[n];
	    for(int i = 0; i < n; i++) {
	        visited[i] = false;
	    }
	    int v1 = sc.nextInt(), v2 = sc.nextInt();
	    List<Integer> vec = DFS(edges, n, v1, v2, visited);
	    return vec;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt(), E = sc.nextInt(), tempX, tempY;
			int[][] edges = new int[V][V];
		    for(int i = 0; i < E; i++) {
		        tempX = sc.nextInt();
		        tempY = sc.nextInt();
		        edges[tempX][tempY] = 1;
		        edges[tempY][tempX] = 1;
		    }
		    
		    List<Integer> ans = getPath(edges, V);
		    for(int i = 0; i < ans.size(); i++) {
		        System.out.println(ans.get(i) + " ");
		    }
	}

}
