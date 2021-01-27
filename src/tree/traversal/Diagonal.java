/**
 * @author AbsolutelySaurabh
 */
package tree.traversal;

import tree.Node;

import java.util.HashMap;
import java.util.Map;

public class Diagonal {

    static Map<Integer, Node> map = new HashMap();

    public static void diagonalTraversal(Node root, int level) {

        if (root == null) {
            return;
        }
        map.put(level, root);
        diagonalTraversal(root.left, level + 1);
        diagonalTraversal(root.right, level);
    }
}