/**
 * @author AbsolutelySaurabh
 */
package string;

import java.util.Scanner;

public class WaysToDecode {

    /*
        input string  = 121 = 1, 2, 1 ; 12, 1 ; 1,21 ==> 3
     */

    //iterative approace --> O(2^n)
    public static int waysToDecode(String digits, int index){

        if(index == 0 || index == 1){
            return 1;
        }

        if(digits.charAt(0) == '0'){
            return 0;
        }

        int count = 0;
        if(digits.charAt(index-1) > '0'){
            count = waysToDecode(digits, index-1);
        }

        if((digits.charAt(index-2) == '1' || digits.charAt(index-2) == '2') && digits.charAt(index-1) < '7'){
            count += waysToDecode(digits, index-2);
        }
        return count;
    }

    //dynamic-programming approach
    public static int dp(char digits[]){

        int n = digits.length;
        int memo[] = new int[n+1];

        memo[0] = 1;
        memo[1] = 1;

        if(digits[0] == '0'){
            return 0;
        }

        for(int i = 2; i<n; i++){

            memo[i] = 0;

            if(digits[i-1] > '0'){
                memo[i] = memo[i-1];
            }

            if((digits[i-2] == '1' || digits[i-2] == '2') && digits[i-1] < '7'){
                memo[i] += memo[i-2];
            }
        }

        return memo[n];
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int test = s.nextInt();
        s.nextInt();
        while(test > 0){

            String str = s.nextLine();
            System.out.println(waysToDecode(str, str.length()));
            test--;
        }

    }

}
