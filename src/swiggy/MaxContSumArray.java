/**
 * @author AbsolutelySaurabh
 */
package swiggy;

import java.util.Scanner;

public class MaxContSumArray {

    static int t[];
    public static int maxSum(int arr[], int n){

        int temp[] = new int[n];
        temp[0] = arr[0];
        int max = Integer.MIN_VALUE;
        for(int i = 1; i<n; i++){
            temp[i] = Math.max(arr[i], arr[i] + temp[i-1]);
            if(temp[i] >= max){
                max = temp[i];
            }
        }
        t = temp;
        return max;
    }

    public static void printArray(int arr[], int n, int temp[]){

        //   [-2, -3, 4, -1, -2, 1, 5, -3]
        //   [-2, -3, 4, 3, 1, 2, 7, 4]

        int start = 0;
        int s = 0, end = 0;

        temp[0] = arr[0];
        int maxSum = Integer.MIN_VALUE;
        for(int i = 1; i<n; i++){
            temp[i] = Math.max(arr[i], arr[i] + temp[i-1]);
            if(temp[i] > maxSum){
                maxSum = temp[i];
                end = i;
                start = s;
            }
            if(temp[i] < 0){
                s = i+1;
            }
        }

        //print array
        for(int i = start; i<=end; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static Scanner s = new Scanner(System.in);
    public static void main(String[] args) {
        int n = s.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i<n; i++){
            arr[i] = s.nextInt();
        }
        System.out.println(maxSum(arr, n));
        printArray(arr, n, t);
    }

}