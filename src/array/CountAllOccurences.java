/**
 * @author AbsolutelySaurabh
 */
package array;

import java.util.Scanner;

public class CountAllOccurences {

    public static int searchLeft(int arr[], int s, int e, int x){

        if(s >= e){
            return Integer.MAX_VALUE;
        }

        int mid = (s+e)/2;
        if(arr[mid] == x){
            //search left
            if(mid == 0){
                return mid;
            }
            return Math.min(mid, searchLeft(arr, s, mid, x));
        }
        if(arr[mid] > x){
            //search left
            return searchLeft(arr, s, mid, x);
        }
        //search right
        return searchLeft(arr, mid+1, e, x);
    }

    public static int searchRight(int arr[], int s, int e, int x){


        if(s >= e){
            return Integer.MIN_VALUE;
        }

        int mid = (s+e)/2;
        if(arr[mid] == x){
            //search left
            if(mid == arr.length-1){
                return mid;
            }
            return Math.max(mid, searchRight(arr, mid+1, e, x));
        }
        if(arr[mid] > x){
            //search left
            return searchRight(arr, s, mid, x);
        }
        //search right
        return searchRight(arr, mid+1, e, x);

    }

    public static int allOccurences(int arr[], int n, int x){

        int left = searchLeft(arr, 0, n, x);
        int right = searchRight(arr, 0, n, x);

        return right - left + 1;

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
            System.out.println(allOccurences(arr, n, x));
            test--;
        }

    }

}
