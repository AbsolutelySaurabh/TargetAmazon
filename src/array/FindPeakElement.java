/**
 * @author AbsolutelySaurabh
 */
package array;

import java.util.Scanner;

public class FindPeakElement {

    /*
    Find peak element in array O(logN)
     */
    public static int findPeakElement(int arr[], int s, int e){

        if(s > e){
            return -1;
        }

        int mid = (s+e)/2;

        //corner cases too..
        if((mid == 0 && arr[mid] > arr[mid+1]) || (mid == arr.length-1 && arr[mid] > arr[mid-1]) || (arr[mid] > arr[mid-1] && arr[mid] > arr[mid+1])){
            return arr[mid];
        }

        if(mid < arr.length-1 && arr[mid+1] > arr[mid]){
            //right
            return findPeakElement(arr, mid+1, e);
        }
        return findPeakElement(arr, s, mid);
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
            System.out.println(findPeakElement(arr, 0, n));
            test--;
        }
    }

}
