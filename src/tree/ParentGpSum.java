/**
 * @author AbsolutelySaurabh
 */
package tree;

public class ParentGpSum {
    /*
    Print all nodes whose parent + grandParent sum is = x
     */
    public static void printNodes(Node root, Node p, Node gp, int x){
        if(root == null) {
            return;
        }
        if(root.data + p.data + gp.data == x){
            System.out.println(root.data);
            return;
        }
        printNodes(root.left, root, p, x);
        printNodes(root.right, root, p, x);
    }
}