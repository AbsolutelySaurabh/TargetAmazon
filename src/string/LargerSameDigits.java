/**
 * @author AbsolutelySaurabh
 */
package string;

import java.util.Arrays;

public class LargerSameDigits {

    /*
        find the next Larger digit
        eg: n = 218765 --> 251678
        Time complexity = O(n) [ worst ]

        Algorithm:
        Start from very end
        Find the first smaller digit to digits[n-1] = d
        Find the smallest larger element on right side of d = L
        Swap d, L
        Sort the substring from L -> n-1

     */
    public static String nextLarger(char digits[]){

        int n = digits.length;
        int digit = digits[n-1];
        int firstSmaller = 0;
        for(int i = n-2; i>=0; i--){
            //find the next smaller
            if(digit > digits[i]) {
                firstSmaller = i;
                break;
            }
        }
        if(firstSmaller == 0){
            //not possible
            return "Not Possible";
        }

        Arrays.sort(digits, firstSmaller+1, n);
        //swap
        char temp = digits[firstSmaller+1];
        digits[firstSmaller+1] = digits[firstSmaller];
        digits[firstSmaller] = temp;

        return String.valueOf(digits);

    }

    public static void main(String[] args) {

    }
}
