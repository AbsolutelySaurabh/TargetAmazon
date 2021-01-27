/**
 * @author AbsolutelySaurabh
 */
package array;

import java.util.Scanner;

public class MajorityElement {

    /*
    Majority element: fre > N/2
    {3, 3, 4, 2, 4, 4, 2, 4, 4} --> 4
     */

    public static int findMaj(int arr[], int n){

        int majority = -1;
        int count = 0;

        majority = arr[0];
        count = 1;

        for(int i = 1; i<n; i++){
            if(arr[i] == majority){
                count++;
            }else{
                count--;
            }
            if(count == 0){
                majority = arr[i];
                count = 1;
            }
        }
        return majority;
    }

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int test = s.nextInt();
        while(test > 0){

            int n = s.nextInt();
            int arr[] = new int[n];

            for(int i = 0; i<n; i++){
                arr[i] = s.nextInt();
            }

            System.out.println(findMaj(arr, n));
            test--;
        }

    }

}
