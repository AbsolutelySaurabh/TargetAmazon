/**
 * @author AbsolutelySaurabh
 */
package sort;

import java.util.Scanner;

public class QuickSort {

    public static int findPivot(int arr[], int low, int high){

        int pivot = arr[high-1];
        int i = low-1;

        for(int j = 0; j<high; j++){
            if(arr[j] < pivot){
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i+1];
        arr[i+1] = arr[high-1];
        arr[high-1] = temp;

        return i+1;
    }

    public static void quickSort(int arr[], int s, int e){

        if(s >= e){
            return;
        }

        int pivotIndex = findPivot(arr, s, e);
        quickSort(arr, s, pivotIndex);
        quickSort(arr, pivotIndex+1, e);
    }
}