package Dynamic;

import java.util.Scanner;

/**
 *date：2022-04-20
 *
 * message :1277. 统计全为 1 的正方形子矩阵
 *
 * work :给你一个 m * n 的矩阵，矩阵中的元素不是 0 就是 1，请你统计并返回其中完全由 1 组成的 正方形 子矩阵的个数。
 */
public class DynamicTwoHundredSixtyNine20220420 {
    public static void main(String[] args){}
    /**
     // 2.1 确定dp数组（dp table）以及下标的含义 :dp[i][j]:以i,j为右下角的，所能构成正方形的最大边长为dp[i][j]
                                                （即以该边长组成的正方形的子矩阵个数也为dp[i][j]   ）
     //  2.2 确定递推公式： if (matrix[i][j] == 1){
     //                    if(i == 0 || j == 0){
     //                        max++;
     //                        dp[i][j] = 1;
     //                    }
     //                    else{
     //                        int x = Math.min(dp[i - 1][j - 1],Math.min(dp[i - 1][j],dp[i][j - 1]));
     //                        dp[i][j] = x + 1;
     //                        max += dp[i][j];
     //                    }
     //                }
     //  2.3 dp数组如何初始化
     //  2.4 确定遍历顺序：后序遍历
     */
    static  public int countSquares(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];
        int max = 0;
        for(int i = 0;i <n;i++){
            for (int j = 0;j < m;j++){
                if (matrix[i][j] == 1){
                    if(i == 0 || j == 0){
                        max++;
                        dp[i][j] = 1;
                    }
                    else{
                        int x = Math.min(dp[i - 1][j - 1],Math.min(dp[i - 1][j],dp[i][j - 1]));
                        dp[i][j] = x + 1;
                        max += dp[i][j];
                    }
                }
            }
        }
        return max;
    }
}
