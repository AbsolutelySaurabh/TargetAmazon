/**
 * @author AbsolutelySaurabh
 */
package tree.traversal;

import tree.Node;

import java.util.Stack;

public class ZigZag {
    /*
    print zigzag traversal of binary tree
     */

    public static void zigZag(Node root){
        Stack<Node> currLevel = new Stack<>();
        Stack<Node> nextLevel = currLevel;

        currLevel.push(root);
        boolean ltor = true;
        while(!currLevel.isEmpty()){
            Node curr = currLevel.pop();
            System.out.println(curr.data);
            if(ltor){
                nextLevel.push(curr.right);
                nextLevel.push(curr.left);
            }else{
                nextLevel.push(curr.left);
                currLevel.push(curr.right);
            }

            if(currLevel.isEmpty()) {
                ltor = !ltor;
                Stack<Node> temp = currLevel;
                currLevel = nextLevel;
                nextLevel = temp;
            }

        }

    }

}
