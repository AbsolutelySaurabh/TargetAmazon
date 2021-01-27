/**
 * @author AbsolutelySaurabh
 */
package LL;

import java.util.Stack;

public class AddingNumbers {
    /*
    Add two numbers represented by LL
     */

    class Node{
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void addNumbers(Node head1, Node head2){

        /*
        Algo1:
        using stack data structure
         */
        Stack<Integer> stack1 = new Stack<Integer>();
        Stack<Integer> stack2 = new Stack<Integer>();
        while(head1!=null && head2!=null){
            stack1.push(head1.data);
            stack2.push(head2.data);
            head1 = head1.next;
            head2 = head2.next;
        }

        //of uneven size
        while(head1!=null){
            stack1.push(head1.data);
            head1 = head1.next;
        }
        while(head2!=null){
            stack2.push(head2.data);
            head2 = head2.next;
        }

        Node newTail = null, temp = null;
        int carry = 0;
        while(stack1!=null && stack2!=null){
            int sum = stack1.pop() + stack2.pop() + carry;
            int res = sum%10;
            carry = sum/10;
            Node curr = new Node(res);
            if(newTail == null){
                newTail = curr;
                temp = newTail;
            }else{
                curr.next = temp;
                temp = curr;
            }
        }
        Node newHead = temp;
        //created a LL
        //handle the case when one of the stack is non empty

        if(!stack1.isEmpty()){
            //add carry
            //pop
            //add in front of res LL
        }

    }

}
