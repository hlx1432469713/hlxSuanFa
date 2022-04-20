package Dynamic;

import java.util.Scanner;

/**
 *date：2022-04-20
 *
 * message :221. 最大正方形
 *
 * work :在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
 * 提示：
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 300
 * matrix[i][j] 为 '0' 或 '1'
 */
public class DynamicTwoHundredSixtyEight20220420 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        char[][] list = {{'1','1','1','1','0'}, {'1','1','1','1','0'},
                {'1','1','1','1','1'}, {'1','1','1','1','1'}, {'0','0','1','1','1'}};
        int result = maximalSquare(list);
        System.out.println(result);
    }

    /**
     // 2.1 确定dp数组（dp table）以及下标的含义 :dp[i][j]:以i,j为右下角的，所能构成的最大正方形面积
     //  2.2 确定递推公式  if (matrix[i][j] == '1') {
     //                   if(i == 0 || j == 0)
     //                       dp[i][j] =1;
     //                    else {
     //                        int x = Math.min(dp[i - 1][j - 1],Math.min(dp[i - 1][j],dp[i][j - 1]));
     //                        x = (int) Math.sqrt(x);
     //                        dp[i][j] = (x + 1) * (x + 1);
     //                    }
     //                    max = Math.max(max, dp[i][j]);
     //                }
     //  2.3 dp数组如何初始化
     //  2.4 确定遍历顺序：后序遍历
     */
    static public int maximalSquare(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];
        int max = 0;
        for(int i = 0;i < n;i++){
            for (int j = 0;j < m;j++) {
                //只有‘1’才能构成正方形
                if (matrix[i][j] == '1') {
                    //在两个边缘，只能构成面积为1的正方形
                   if(i == 0 || j == 0)
                       dp[i][j] =1;
                    else {
                        //以（i，j）为右下角的正方形最大面积，只能是（i - 1,j）,(i,j - 1)，和(i ,j)三者中最小的正方形面积来决定
                        int x = Math.min(dp[i - 1][j - 1],Math.min(dp[i - 1][j],dp[i][j - 1]));
                        x = (int) Math.sqrt(x);//原正方形的边长
                        dp[i][j] = (x + 1) * (x + 1);
                    }
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max;
    }
}
