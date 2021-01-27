/**
 * @author AbsolutelySaurabh
 */
package array;

public class SearchVHSortedMatrix {

    /*
    Algorithm: time complexity O(n)
     */

    public static int[] search(int arr[][], int key){

        int col = arr.length-1;
        int row = 0;
        int ans[] = new int[2];
        while(col>=0 && row<arr.length){

            if(arr[row][col] == key){
                ans[0] = row;
                ans[1] = col;
                return ans;
            }else
            if(arr[row][col] > key){
                col--;
            }else{
                row++;
            }
        }
        int a[] = {-1};
        return a;
    }

    public static void main(String[] args) {

    }
}
