/**
 * @author AbsolutelySaurabh
 */
package array;

import java.util.Scanner;

public class Flip0sMaxConseq1s {
    /*
    Algo: Using sliding window approach
    Time compl : O(n);
     */

    public static int[] flipMaxConseq(int arr[], int m, int n){

        int index = 0;
        int zeroCount = 0;
        int maxWindow = -1;
        int start = 0;
        int maxWindowStart = 0, maxWindowEnd = n;
        while(index < n){

            if(arr[index] == 0){
                if(zeroCount == m){
                    //get the window
                    if(n - index > maxWindow){
                        maxWindow = index-start;
                        maxWindowStart = start;
                        maxWindowEnd = index;
                    }

                    //expand the window/start
                    while(arr[start]!=0){
                        start++;
                    }
                    start+=1;

                }else {
                    zeroCount++;
                    System.out.println("index: " + index);
                }
            }
            index++;
        }
//        if(zeroCount <= m){
//            //just get the 0 indices
//
//        }
        int ans[] = new int[zeroCount];
        int j = 0;
        //add the 0 indices in array between maxWindowStart and end;
        for(int i = maxWindowStart; i<maxWindowEnd; i++){
            if(arr[i] == 0){
                ans[j] = i;
                j++;
            }
        }
        return ans;
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
            int m = s.nextInt();
            int ans[] = flipMaxConseq(arr, m, n);
            for(int i = 0; i<ans.length; i++){
                System.out.print(ans[i] + " ");
            }
            System.out.println();
            test--;
        }
    }

}
