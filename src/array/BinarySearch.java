/**
 * @author AbsolutelySaurabh
 */
package array;

import java.util.Scanner;

public class BinarySearch {

    public static int binarySearch(int arr[], int s, int e, int x){

        if(s >= e){
            return -1;
        }

        int mid = (s+e)/2;
        if(arr[mid] == x){
            return mid;
        }
        if(x < arr[mid]){
            return binarySearch(arr, s, mid, x);
        }
        return binarySearch(arr, mid+1, e, x);
    }

    public static int _binarySearch(int arr[], int s, int e, int x){

        if(s > e){
            return -1;
        }

        int mid = (s+e)/2;
        if(arr[mid] == x){
            return mid;
        }
        if(x < arr[mid]){
            return _binarySearch(arr, s, mid-1, x);
        }
        return _binarySearch(arr, mid+1, e, x);
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

            int x = s.nextInt();
            System.out.println(binarySearch(arr, 0, n, x));
            System.out.println(_binarySearch(arr, 0, n-1, x));
            test--;
        }

    }

}
