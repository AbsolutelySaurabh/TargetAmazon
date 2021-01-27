/**
 * @author AbsolutelySaurabh
 */
package sort;

public class MergeSort {

    public static void merge(int arr[], int s, int mid, int e){
        //TODO

    }

    public static void mergeSort(int arr[], int s, int e){

        if(s >= e){
            return;
        }

        int mid = (s + e)/2;
        mergeSort(arr, s, mid);
        mergeSort(arr, mid+1, e);

        merge(arr, s, mid, e);
    }

}