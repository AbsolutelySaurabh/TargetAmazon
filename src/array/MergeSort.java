/**
 * @author AbsolutelySaurabh
 */
package array;

import java.util.Scanner;

public class MergeSort {

    public static void printArr(int arr[]){
        for(int i = 0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }

    public static void merge(int arr[], int s, int m, int e){

        int l = (m-s) + 1;
        int r = (e-m);

        int left[] = new int[l];
        int right[] = new int[r];

        boolean leftF = false, rightF = false;
        for(int i = 0; i<l; i++){
            left[i] = arr[i + s];
            leftF = true;
        }
        for(int i = 0; i<r; i++){
            right[i] = arr[i + m + 1];
            rightF = true;
        }

        System.out.print("s: " + s + " m: " + m + " e: " + e);

        if(leftF) {
            System.out.print("left: " );
            printArr(left);
        }
        if(rightF) {
            System.out.print("right: " );
            printArr(right);
        }
        System.out.println();


        int li = 0, ri = 0;
        int k = s;
        while(li < l && ri < r){

            if(left[li] < right[ri]){
                arr[k++] = left[li++];
            }else{
                arr[k++] = right[ri++];
            }
        }

        while(li < l){
            arr[k++] = left[li++];
        }

        while(ri < r){
            arr[k++] = right[ri++];
        }

        System.out.print(" array now: ");
        printArr(arr);

    }

    public static void sort(int arr[], int s, int e){

        if(s >= e-1){
            //no need to sort for size = 1;
            return;
        }

        int mid = (s+e)/2;
        sort(arr, s, mid);
        sort(arr, mid+1, e);

        merge(arr, s, mid, e);
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

            sort(arr ,0, n-1);

            for(int i = 0; i<n; i++){
                System.out.print(arr[i] + " ");
            }
            test--;
        }

    }

}
