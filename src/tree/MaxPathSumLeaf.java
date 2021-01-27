/**
 * @author AbsolutelySaurabh
 */
package tree;

public class MaxPathSumLeaf {

    public class Node{
        int data;
        Node left, right;
    }

    int maxSum = Integer.MIN_VALUE;
    int maxPathSum(Node node){
        if(node == null)
            return 0;

        return node.data + Math.max(maxPathSum(node.left) , maxPathSum(node.right));
    }
}