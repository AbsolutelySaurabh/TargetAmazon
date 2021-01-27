/**
 * @author AbsolutelySaurabh
 */
package tree;

import java.util.Stack;

public class GivenPathSum {

    class Node{
        int data;
        Node left, right;
    }

    Stack<Integer> stack = new Stack();
    boolean givenPathSum(Node node, int sumTillNow, int reqSum){
        if(node == null){
            if(sumTillNow == reqSum){
                return true;
            }
            return false;
        }
        boolean left = givenPathSum(node.left, sumTillNow+node.data, reqSum);
        if(!left){
            boolean right = givenPathSum(node.right, sumTillNow + node.data, reqSum);
            if(right){
                stack.push(node.data);
            }
            return right;
        }
        stack.push(node.data);
        return left;
    }

}
