/**
 * @author AbsolutelySaurabh
 */
package string;

import java.util.Scanner;

public class LongestPallindrome {

    /*
        Find the longest length pallindromic substring
        Algorithm: find all the max(even, odd) length pallindromic substrings
     */

    public static String longestPallindrome(String string){

        int n = string.length();

        int s = 0, e = s+1;
        int index = 0;
        String even = "";
        String odd = "";
        while(index < n){

            //even
            s = index;
            e = s+1;
            while(s>=0 && e<n && string.charAt(s) == string.charAt(e)){
                //expand that
                even = (even.length() < string.substring(s, e+1).length())?string.substring(s, e+1):even;
                s--;
                e++;
            }
//            System.out.println("even: " + even);

            s = index;
            e = s+2;

            while(s>=0 && e<n && string.charAt(s) == string.charAt(e)){
                //expand that
                odd = (odd.length() < string.substring(s, e+1).length())?string.substring(s, e+1):odd;
                s--;
                e++;
            }
//            System.out.println("odd: " + odd);

            index++;
        }
        return even.length() > odd.length()?even:odd;
    }

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int test = s.nextInt();
        s.nextLine();
        while(test > 0){

            String str = s.nextLine();
            System.out.println(longestPallindrome(str));
            test--;
        }

    }

}
