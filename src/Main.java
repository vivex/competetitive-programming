import array.algo.SegmentTree;
import graph.Graph;
import graph.search.BFS;
import tree.IntervalTree;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        intervalTree();
    }

    public void bfsGraph() {
        Graph g  = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        BFS bfs = new BFS(g);
        bfs.search(2);
    }

    public static void segmentTree() {

        int[] arr = {1,3,5,7,9,11};
        SegmentTree s = new SegmentTree(arr, arr.length);

        System.out.println("Sum of values in given range = " + s.getSum(arr.length, 2, 3));

        // Update: set arr[1] = 10 and update corresponding segment
        // tree nodes
       // s.updateValue(arr, arr.length, 1, 10);

        // Find the sum after the value is updated

        //System.out.println("Updated sum of values in given range = " + s.getSum(arr.length,1,3));

    }

    public static void intervalTree() {
        IntervalTree t = new IntervalTree();
        t.addInterval(3,5);
        t.addInterval(7,11); // to right;
        t.addInterval(6,7); // to riht
        t.addInterval(16,19); // to riht

        t.checkIntervalCollision(13,17, t.root);
        t.display(t.root);
    }
}
