package graph;

import java.util.LinkedList;

public class Graph {
    private int V; // no of vertices
    private LinkedList<Integer> adj[]; //Adjacency lists

    public Graph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i =0; i< v; i ++)
            adj[i] = new LinkedList();
    }

    // function to add an edge into graph
    public void addEdge(int v, int w) {
        adj[v].add(w);
    }


    public LinkedList<Integer> getAdjacencyList(int s) {
        return  adj[s];
    }
    public int size() {
        return this.V;
    }
}
