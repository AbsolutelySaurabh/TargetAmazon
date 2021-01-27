/**
 * @author AbsolutelySaurabh
 */
package swiggy;

public class Lca {

    public class Node {

        int data;
        Node left, right;

        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static Node lcaUtil(Node node, int a, int b){
        if(node == null){
            return null;
        }

        if(node.data == a || node.data == b){
            return node;
        }

        Node left = lcaUtil(node.left, a, b);
        Node right = lcaUtil(node.right, a, b);

        if(left!=null && right!=null){
            return node;
        }
        if(left != null && right == null){
            return left;
        }
        return right;
    }

    public static Node lca(Node node, int a, int b){
        return lcaUtil(node, a, b);
    }

}
