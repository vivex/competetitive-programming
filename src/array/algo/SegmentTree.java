package array.algo;

public class SegmentTree{
    int st[]; //The array that stores segment tree nodes;

    public SegmentTree(int arr[], int n) {
        // Allocate memory for segment tree
        // Height of segment tree
        int x = (int) (Math.ceil(Math.log(n) / Math.log(2)));
        System.out.println("Height of tree is: " + x);

        // Maximum size of segment tree
        int maxSize = 2* (int) Math.pow(2,x) - 1;
        st = new int[maxSize];
        constructSTUtil(arr, 0, n - 1, 0);
    }

    // a util function to get the middle index from corner indexes

    int getMid(int start, int end) {
        return start + (end-start) /2;
    }

    /**
     *  A recursive function to get the sum of values in given range
     *  of the array the following are parameters for this function
     *
     *  st: Pointer to segment tree
     *  si: Index of current node in the segment tree.
     *      Initially 0 is passed as root is always at index 0
     *  ss & se: Starting and ending indexes of segment
     *           represented by current node, i.e. st[si]
     *
     *  qs & qe: Starting and ending indexes of query range
     */

    public int getSumUtil(int ss, int se, int qs, int qe, int si) {
        // if Segment of this node is a part of given range then
        // return the sum of the segment
        if (qs <= ss && qe >=se)
            return st[si];
        // if segment of this node is outside the given range
        if (se < qs || ss > qe)
            return 0;

        // If a part of this segment overlaps with the given range

        int mid = getMid(ss, se);
        return getSumUtil(ss, mid, qs, qe, 2*si +1) +
                getSumUtil(mid + 1, se, qs, qe, 2* si +2);
    }


    /**
     * A recursive function to update the nodes which have the given index
     * in their range. The following are parameters:
     * st, si, ss and se are same as getSumUtil
     *
     * i: index of the element to be updated. This index is in input array
     * diff: value to be added to all nodes which have i in range
     *
     */

    void updateValueUtil(int ss, int se, int i, int diff, int si){

        // Base case: if the input index lies outside the range of this segment

        if (i < ss || i > se)
            return ;
        // if the input index is in range of this node,
        // then update the value of the node and its children
        st[si] = st[si] + diff;
        if (se != ss) {
            int mid = getMid(ss, se);
            updateValueUtil(ss, mid, i , diff, 2 *si + 1);
            updateValueUtil(mid+1, se, i , diff, 2 * si + 2);

        }
    }


    // The function to update a value in input array and segment tree
    // it uses updateValueUtil() to update the value in segment tree

    public void updateValue(int arr[], int n, int i, int new_val) {
        // check for erroneous input index
        if (i < 0 || i > n - 1) {
            System.out.println("Invalid input");
            return;
        }
        // Get the difference between new value and old value
        int diff = new_val - arr[i];

        arr[i] = new_val;

        // Update the values of nodes in segment tree
        updateValueUtil(0, n -1, i, diff, 0);
    }

    // REturn sum of elements in range from index qs (query start)
    // to qe (query end). It mainly uses getSumUtil

    public int getSum(int n, int qs, int qe) {
        // check for erroneous input values
        if (qs < 0 || qe > n-1 || qs > qe) {
            System.out.println("invalid input");
            return -1;
        }

        return getSumUtil(0, n-1, qs, qe, 0);
    }

    // A recursive function that constructs segment tree for array[ss..se]
    // si is index of current node in segment tree st

    int constructSTUtil (int arr[], int ss, int se, int si) {
        // if there is one element in array, store it in current node of
        // segment tree and return

        if (ss == se) {
            st[si] = arr[ss];
            return arr[ss];
        }

        // If there are more than one elements, than recur for left and
        // right subtrees and store the sum of values in this node

        int mid = getMid(ss, se);
        st[si] = constructSTUtil(arr, ss, mid, si *2 + 1) +
                constructSTUtil(arr, mid +1, se, si * 2+ 2);
        return st[si];
    }
}
