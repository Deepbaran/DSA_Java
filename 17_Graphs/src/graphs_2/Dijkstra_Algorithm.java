package graphs_2;

import java.util.*;

public class Dijkstra_Algorithm {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int e = sc.nextInt();
		int[][] edges = new int[n][n];

		for (int i = 0; i < e; i++) {
			int f = sc.nextInt(), s = sc.nextInt(), weight = sc.nextInt();
			edges[f][s] = weight;
			edges[s][f] = weight;
		}
		System.out.println();
		dijkstra(edges, n);
	}
	
	private static void dijkstra(int[][] edges, int n){
		int[] distance = new int[n];
		boolean[] visited = new boolean[n];

		for(int i = 0; i < n; i++){
			distance[i] = Integer.MAX_VALUE;
			visited[i] = false;
		}

		distance[0] = 0;

		for(int i = 0; i < n - 1; i++){ // As we don't need to check the neighbors of our destination so, we can run it n-1 times
			int minVertex = findMinVertex(distance, visited, n);
			visited[minVertex] = true;
			for(int j = 0; j < n; j++){	
				if(edges[minVertex][j] != 0 && !visited[j]){
					int dist = distance[minVertex] + edges[minVertex][j];
					if(dist < distance[j]){
						distance[j] = dist;
					}
				}
			}
		}

		for(int i = 0; i < n; i++){
			System.out.println(i + " " + distance[i]);
		}
		
	}

	private static int findMinVertex(int[] distance, boolean[] visited, int n){

		int minVertex = -1;
		for(int i = 0; i < n; i++){
			if(!visited[i] && (minVertex == -1 ||  distance[i] < distance[minVertex])){
				minVertex = i;
			}
		}
		return minVertex;
	}

}


/*
Time Complexity: O(n^2)

We can improve it. If we use adjacency list, then we will only go to the neighbors and not unnecessarily travel through all the vertices that we are doing because we are using adjacency matrices.

Second optimizes is to use priority queue in the case of findMinVertex with the distance being the priority. We will need to customize the priority queue so that the priority queue automatically heapifies as we change the distance of the minVertex and get updated.

So, improved time complexity: O((n + E)logn)
*/
