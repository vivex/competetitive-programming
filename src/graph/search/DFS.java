package graph.search;

import graph.Graph;

public class DFS {
    private int[][] graph;

    private int V;
    public DFS(int[][] g) {
        graph = g;
        V = g.length;
    }

    int minDistance(int dist[], Boolean sptSet[]) {
        // Initialize min value
        int min = Integer.MAX_VALUE, minIndex = -1;
        for (int v = 0; v < V; v ++) {
            if (sptSet[v] == false && dist[v] <= min) {
                min = dist[v];
                minIndex = v;
            }
        }
        return minIndex;
    }

    void printSolution (int dist[], int n) {
        System.out.println("Vertex Distance from Source");
        for(int i = 0; i< V; i ++) {
            System.out.println(i + "tt " + dist[i]);
        }
    }

    void dijkstra (int graph[][], int src) {
        int dist[] = new int[V];

        // sptSet[i] will be true if vertext i is included in shortest path
        // tree or shortest distance from src to i is finalized
        Boolean sptSet[] = new Boolean[V];

        for (int i=0; i < V; i ++){
            dist[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }

        // distance of source vertext from itself
        dist[src] = 0;

        // find shortest path for all vertices

        for (int count = 0; count < V-1; count ++ ) {
            // Pick the minimum distance vertex from the set of vertices
            // not yet processed. u is always equal  to src in first iteration

            int u = minDistance(dist, sptSet);

            // Mark the picked vertext as processed
            sptSet[u] = true;

            // Update dist value of the adjacent vertices of the picked vertex
            for (int v = 0; v < V; v ++){
                // Update dist[v] only if is not in sptSet, there is an
                // edge from u to v, and total weight of path from src to  v through u
                // is smaller than current value of dist[v]


            }
        }
    }
}
