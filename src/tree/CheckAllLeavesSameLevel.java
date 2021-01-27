/**
 * @author AbsolutelySaurabh
 */
package tree;

public class CheckAllLeavesSameLevel {
    /*
    Check if all leaves are at same level.
    Time complexity : O(N)
     */
    static int level = -1;
    public static boolean checkSameLevel(Node node, int l){

        if(node == null){
            return true;
        }
        if(node.left == null && node.right == null){
            if(level == -1){
                level = l;
                return true;
            }else{
                if(l!=level){
                    return false;
                }
            }
        }
        //  O(N) algorithm
        /*

        '&&' , '||' complexity time = N
        '+' complexity time = exponential

         */
        return checkSameLevel(node.left, l+1) && checkSameLevel(node.right, l+1);
    }
}