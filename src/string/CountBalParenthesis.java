/**
 * @author AbsolutelySaurabh
 */
package string;

import java.util.Stack;

public class CountBalParenthesis {

    public static int countBalancedPar(String str){

        Stack<Character> stack = new Stack<>();
        int start = 0;
        int count = 0;
        while(start < str.length()){
            char s = str.charAt(start);
            if(s == '{' || s == '[' || s == '('){
                stack.push(s);
            }else
                if(s == '}' || s == ']' || s == ')'){
                    if(stack.size() == 0){
                        return count;
                    }
                    char p = stack.pop();
                    if(s == '}' && p == '{'){
                        count++;
                    }else
                        if(s == ']' && p == '['){
                            count++;
                        }
                        else
                            if(s == ')' && p == '('){
                                count++;
                            }
                }
                start++;
        }
        return count;
    }

    public static void main(String[] args) {

    }
}
