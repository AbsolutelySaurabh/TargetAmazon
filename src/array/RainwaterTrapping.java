/**
 * @author AbsolutelySaurabh
 */
package array;

import java.util.Scanner;

import static java.lang.Math.*;

public class RainwaterTrapping {

    /*
    Algorithm:
    1. Compute max from left[], right[] side arrays.
    2. water += abs(min(left[i], right[i]) - arr[i]);
     */
    public static int rainwaterTrapping(int arr[], int n){

        //max on left side
        int left[] = new int[n];
        int right[] = new int[n];

        left[0] = arr[0];
        right[n-1] = arr[n-1];

        for(int i = 1; i<n ;i++){
            left[i] = max(left[i-1], arr[i]);
        }

        for(int i = n-2; i>=0; i--){
            right[i] = max(right[i+1], arr[i]);
        }

        int water = 0;
        for(int i = 1; i<n-1; i++){
            water+=(abs(min(left[i], right[i]) - arr[i]));
        }
        return water;
    }

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int test = s.nextInt();
        while(test > 0){

            int n = s.nextInt();
            int arr[] = new int[n];

            for(int i = 0; i<n; i++){
                arr[i]  =s.nextInt();
            }
            System.out.println(rainwaterTrapping(arr, arr.length));
            test--;
        }
    }
}