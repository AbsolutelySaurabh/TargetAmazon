/**
 * @author AbsolutelySaurabh
 */
package tree;

import java.util.Scanner;

public class KthDisNode {

    public static void kthDisNode(Node root, int k){

        if(root == null){
            return;
        }
        if(k == 0){
            //print root.data;
            return;
        }
        kthDisNode(root.left, k-1);
        kthDisNode(root.right, k-1);
    }

    public static void main(String[] args){

        Scanner s = new Scanner(System.in);
        kthDisNode(null, 1);
        //print ans.data;
    }

}
