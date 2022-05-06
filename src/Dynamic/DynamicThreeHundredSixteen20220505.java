package Dynamic;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 *date：2022-05-05
 *
 * message :542. 01 矩阵
 *
 * work :给定一个由 0 和 1 组成的矩阵 mat，请输出一个大小相同的矩阵，其中每一个格子是 mat 中对应位置元素到最近的 0 的距离。
 *
 * 两个相邻元素间的距离为 1 。
 *
 *
 */
public class DynamicThreeHundredSixteen20220505 {
    public static void main(String[] args){}

    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] dp = new int[n][m];
        if(mat[0][0] == 1)
            dp[0][0] = 10001;
        for(int i = 0;i < n;i++){
            for(int j = 0;j < m;j++){
                if(mat[i][j] == 1){
                    if(i == 0 && j == 0)
                        continue;
                    else if(i == 0){
                        dp[i][j] = dp[i][j - 1] + 1;
                    }else if(j == 0){
                        dp[i][j] = dp[i - 1][j] + 1;
                    }else
                        dp[i][j] = Math.min(dp[i - 1][j],dp[i][j - 1]) + 1;
                }
            }
        }
        for(int i = n - 1;i >= 0;i--){
            for(int j = m - 1;j >= 0;j--){
                if(mat[i][j] == 1){
                    if(i == n - 1 && j == m - 1)
                        continue;
                    else if(i == n - 1){
                        dp[i][j] = Math.min(dp[i][j + 1] + 1,dp[i][j]);
                    }else if(j == m - 1){
                        dp[i][j] = Math.min(dp[i + 1][j] + 1,dp[i][j]);
                    }else
                        dp[i][j] = Math.min(dp[i][j],Math.min(dp[i + 1][j],dp[i][j + 1]) + 1);
                }
            }
        }
        return dp;
    }

    int[][] list = {{-1,0},{1,0},{0,-1},{0,1}};
    public int[][] updateMatrix2(int[][] mat){
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0;i < mat.length;i++){
            for(int j = 0;j < mat[0].length;j++){
                if(mat[i][j] == 0)
                    queue.add(new int[]{i,j});
                else
                    mat[i][j] = -1;
            }
        }
        while(!queue.isEmpty()){
            for(int[] l :list){
                int x = queue.poll()[0];
                int y = queue.poll()[1];
                int newX = x + l[0];
                int newY = y + l[1];
                if(newX >= 0 && newY >= 0 && newX < mat.length && newY < mat[0].length){
                    if(mat[newX][newY] == - 1){
                        mat[newX][newY] = mat[x][y] + 1;
                        queue.add(new int[]{newX,newY});
                    }
                }
            }
        }
        return mat;
    }
}
