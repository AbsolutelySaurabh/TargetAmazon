/**
 * @author AbsolutelySaurabh
 */
package swiggy;

public class MaxPoints {

    /*
    go from top left to botto right iwth max points
     */
    int n;
    int dp[][] = new int[n][n];
    public static int maxPoints(int grid[][], int row, int col, int n){

        if(row == n-1 && col == n-1){
            //destn reached
            return 0;
        }
        dp[row][col] = max(fun(down), func(right));
        return dp[row][col];
    }
}