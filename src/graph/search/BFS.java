package graph.search;

import graph.Graph;

import java.util.Iterator;
import java.util.LinkedList;

public class BFS {

    private Graph graph;

    public BFS(Graph g) {
        this.graph = g;
    }

    // Print BFS traversal from given source
    public void search(int source) {

        // mark all the vertices as not visited
        boolean visited[] = new boolean[this.graph.size()];

        // create a queue for BFS
        LinkedList<Integer> queue  = new LinkedList<>();

        // mark the current node as visited and enqueue it
        visited[source] = true;
        queue.add(source);

        while (queue.size() != 0) {
            // deque a vertex from queue and print it
            source = queue.poll();
            System.out.print(source + " ");

            // get all the adjacent vertices of dequeued vertex source
            // if an adjacent is not been visited then mark it visited and enqueue it
            Iterator<Integer> i = graph.getAdjacencyList(source).listIterator();
            while (i.hasNext()) {
                int nextNode = i.next();
                if (!visited[nextNode]) {
                    visited[nextNode] = true;
                    queue.add(nextNode);
                }
            }
        }
    }
}
