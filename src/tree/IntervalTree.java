package tree;

class IntervalNode {

    public int startTime;
    public int endTime;
    public int max;
    public IntervalNode parent;
    public IntervalNode left;
    public IntervalNode right;

    @Override
    public String toString() {
        return "{Start: " + startTime + ", End: " + endTime + ", Max: " + max;
    }
}
public class IntervalTree {

    public static IntervalNode root = null;

    public void addInterval (int startTime, int endTime) {
        if (startTime > endTime)
        {
            System.out.println("Start time can not be greater than End Time");
            return;
        }
        IntervalNode temp = new IntervalNode();
        temp.startTime = startTime;
        temp.endTime = endTime;
        temp.max = endTime;

        if (root == null) {
            // add first node
            temp.parent = null;
            root = temp;
            return;
        }

        IntervalNode currentNode  = root;

        boolean breakloop = true;
        while(breakloop) {
            if (temp.startTime < currentNode.startTime) {
                if (currentNode.left == null) {
                    currentNode.left = temp;
                    temp.parent = currentNode;
                    breakloop = false;
                } else {
                    currentNode = currentNode.left;
                }
            } else {
                if (currentNode.right == null) {
                    currentNode.right = temp;
                    temp.parent = currentNode;
                    breakloop = false;
                } else {
                    currentNode = currentNode.right;
                }
            }
        }

        //Update Max
        while(currentNode != null && currentNode.parent !=null && currentNode.max > currentNode.parent.max) {
            currentNode.parent.max = currentNode.max;
            currentNode = currentNode.parent;
        }

    }

    private static boolean doOverlap(IntervalNode a, IntervalNode b) {
        if (a.startTime <= b.endTime && b.startTime <= a.endTime)
            return true;
        else
            return false;
    }
    public static IntervalNode checkIntervalCollision(int startTime, int endTime, IntervalNode node) {
        if (startTime > endTime)
        {
            System.out.println("Start time can not be greater than End Time");
        }

        // base case, tree is empty
        if (node == null) return null;

        IntervalNode tempNode = new IntervalNode();
        tempNode.startTime = startTime;
        tempNode.endTime = endTime;

        // if given interval overlaps with root
        if (doOverlap(tempNode, node))
        {
            System.out.println("Overlaps with" + node);
            return node;
        }

        if (node.left != null && node.left.max >= tempNode.startTime)
            return checkIntervalCollision(startTime, endTime, node.left);

        // else interval can only overlap with right
        return checkIntervalCollision(startTime, endTime, node.right);
    }

    public void display(IntervalNode intervalNode) {
        if ( intervalNode != null ) {
            System.out.println("{Start: " + intervalNode.startTime + ", END: " + intervalNode.endTime + ", MAX: "+ intervalNode.max + "}");
            display(intervalNode.left);
            display(intervalNode.right);
        }
    }


}
