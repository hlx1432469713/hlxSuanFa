package Dynamic;

import java.util.Scanner;

/**
 *date：2021-12-06
 *
 * message : 最小路径和
 *
 * work : 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *
 * 说明：每次只能向下或者向右移动一步。
 *
 *
 */
public class DynamicSixty20211206 {
    public static void main(String[] args){
       Scanner scanner = new Scanner(System.in);
       while(scanner.hasNext()){
           int m = scanner.nextInt();
           int n = scanner.nextInt();
           int[][] grid = new int[m][n];
           for(int i = 0;i < m;i++)
               for (int j = 0;j < n;j++)
                   grid[i][j] = scanner.nextInt();
           int x = minPathSum(grid);
           System.out.println(x);
       }

    }
    static public int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] dp = new int[row][col];
        dp[0][0] = grid[0][0];
        for(int i = 1;i < row;i++){
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for(int i = 1;i < col;i++){
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }

        for (int j = 1;j < row;j++){
            for (int k = 1;k < col;k++){
                dp[j][k] = Math.min(dp[j -1][k],dp[j][k-1]) + grid[j][k];
            }
        }
        return dp[row - 1][col - 1];
    }

}
