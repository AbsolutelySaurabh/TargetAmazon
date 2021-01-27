/**
 * @author AbsolutelySaurabh
 */
package string;

import java.util.Scanner;

/*
Min flips to make binary string alternate
00110 -> 10101 --> 1 + 1 + 1 = 3
 */
public class MinFlipsBinaryAlternate {

    private static int getFlips(String str, char expected){

        int count = 0;
        for(int i = 0; i<str.length(); i++){

            if(str.charAt(i)!=expected){
                count++;
            }
            expected = (expected == '0')?'1':'0';
        }
        return count;
    }

   private static int minFlips(String str){

       return Math.min(getFlips(str, '0'), getFlips(str, '1'));

   }

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        System.out.println(minFlips(str));

    }

}
