/**
 * @author AbsolutelySaurabh
 */
package sort;

import org.w3c.dom.html.HTMLQuoteElement;

import java.util.Scanner;

public class SelecBubbInser {

    public static void insertionSort(int arr[]){

        int n = arr.length;
        for(int i = 1; i<n; i++){
            for(int j = i-1; j>=0; j--){
                //check
                if(arr[j] > arr[i]){
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
    }

    public static void bubbleSort(int arr[]){

        int n = arr.length;
        for(int i = 0; i<n; i++){
            for(int j = i+1; j<n-1; j++){
                if(arr[j] > arr[j+1]){
                    //swap
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    public static void selectionSort(int arr[]){

        //take one min
        int n = arr.length;
        for(int i = 0; i<n-1; i++){
            int min = arr[i];
            int minIndex = i;
            for(int j = i+1; j<n; j++){
                if(arr[j]  < min){
                    min = arr[j];
                    minIndex = j;
                }
            }
            //swap
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }

    }

    public static void print(int arr[]){
        for(int i = 0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i<n; i++){
            arr[i] = s.nextInt();
        }
        int selec[] = arr;
        int bubbl[] = arr;
        int inser[] = arr;
        int quick[] = arr;

        selectionSort(selec);
        print(selec);

        bubbleSort(bubbl);
        print(bubbl);

        insertionSort(inser);
        print(inser);

        QuickSort.quickSort(quick, 0, quick.length);
        print(quick);
    }
}