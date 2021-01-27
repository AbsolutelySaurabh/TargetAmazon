/**
 * @author AbsolutelySaurabh
 */
package tree;

public class BtToDll {

    class DLLNode{
        int data;
        DLLNode prev;
        DLLNode next;
    }

    DLLNode prev, next;
    DLLNode head;
    DLLNode curr;
    public void convert(Node root){

        if(root == null ){
            return;
        }

        convert(root.left);
        if(prev != null) {
            prev.next = curr;
        }
        if(head == null){
            head = curr;
        }
        curr.data = root.data;
        curr.prev = prev;
        prev = curr;
        convert(root.right);
    }

}
