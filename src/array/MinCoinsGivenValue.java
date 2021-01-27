/**
 * @author AbsolutelySaurabh
 */
package array;

import java.util.Scanner;

public class MinCoinsGivenValue {

    /*
    Recursive: Time complexity - Exponential
    O(n^V)

    n: length(arr) , V = amount
    Each node in recursive tree had V nodes.
     */
    public static int minCoins(int arr[], int V){

        if(V == 0){
            return 0;
        }
        int res = Integer.MAX_VALUE;

        for(int i = 0; i<arr.length; i++){
            if(arr[i] <= V){
                int subres = minCoins(arr, V-arr[i]);
                res = Math.min(res, 1+subres);
            }
        }
        return res;
    }

    /*
    DP approach: O(n^2)
     */
    public static int minCoins_dp(int arr[], int V){

        int memo[] = new int[V+1];
        memo[0] = 0;
        for(int i =1; i<=V; i++){
            memo[i] = Integer.MAX_VALUE;
        }
        for(int i = 1; i<=V; i++){
            for(int j = 0 ; j< arr.length; j++){
                if(arr[j] <= i) {
                    memo[i] = Math.min(memo[i], memo[i - arr[j]] + 1);
                }
            }
        }
        return memo[V];
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int test = s.nextInt();
        while(test > 0){

            int n = s.nextInt();
            int arr[] = new int[n];

            for(int i = 0; i<n; i++){
                arr[i]  =s.nextInt();
            }

            int V = s.nextInt();
            System.out.println(minCoins(arr, V));
            System.out.println(minCoins_dp(arr, V));

            test--;
        }
    }
}
