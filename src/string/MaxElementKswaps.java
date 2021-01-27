/**
 * @author AbsolutelySaurabh
 */
package string;

import javax.swing.*;

import java.util.Scanner;

import static java.lang.String.valueOf;

public class MaxElementKswaps {

    /*
    Find max number formed after atmost K swaps
    eg: 7599, K=2 -> 9975
    Time complexity - O(n^k)
     */

    static int maxNum;

    public static void maxElement(char arr[], int k, int index){

        if(k == 0){
            //get the number
            if(Integer.parseInt(String.valueOf(arr)) > maxNum){
                maxNum = Integer.parseInt(valueOf(arr));
                System.out.println("maxSum: " + maxNum);
            }
            return;
        }

        //find max for each index
        //swap
        //swapback

        String str = String.valueOf(arr);
        System.out.println("str: " + str);
        for(int i = index; i<str.length()-1; i++){

            //find max after str[i];
            int max = str.charAt(i);
            int maxIndex = -1;

            System.out.println("max:" + max + " maxindex: " + maxIndex);
            for(int j = i+1; j<str.length(); j++){
                if(Integer.parseInt(String.valueOf(arr[j])) > max){
                    max = Integer.parseInt(String.valueOf(arr[j]));
                    maxIndex = j;
                }
            }

            System.out.println("max:" + max + " maxindex: " + maxIndex);

            if(maxIndex == -1){
                //largestNum found
                maxNum = Integer.parseInt(String.valueOf(str));
                return;
            }

            //swap
            char temp = arr[maxIndex];
            arr[maxIndex] = arr[i];
            arr[i] = temp;

            //repeat this k times
            maxElement(arr, k-1, i+1);

            //swap back
            //swap
            temp = arr[maxIndex];
            arr[maxIndex] = arr[i];
            arr[i] = temp;

        }

    }

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        int k = s.nextInt();
        System.out.println("s: " + str + " k: " + k);
        maxElement(str.toCharArray(), k, 0);
        System.out.println("ans: " + maxNum);
    }

}
