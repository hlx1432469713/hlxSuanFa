package shuZu;

import java.util.Arrays;

/**
 *date：2022-05-03
 *
 * message :498. 对角线遍历
 *
 * work :给你一个大小为 m x n 的矩阵 mat ，请以对角线遍历的顺序，用一个数组返回这个矩阵中的所有元素。
 *
 */
public class shuZuThreeHundredEleven20220503 {
    public static void main(String[] args){}
    int[] list;
    int sum = 0;
    public int[] findDiagonalOrder(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        list = new int[n * m];
        dfs(mat,0,0,true);
        return list;
    }
    public void dfs(int[][] mat,int row,int col,boolean flag){
        int n = mat.length;
        int m = mat[0].length;
        if(row < 0 || col < 0 || row >= n || col >= m || mat[row][col] == 100001)
            return;
        list[sum++] = mat[row][col];
        mat[row][col] = 100001;
        if(flag){
            dfs(mat,row - 1 ,col + 1,flag);
        }else{
            dfs(mat,row + 1 ,col - 1,flag);
        }
        if((row == 0 || row == n -1) && col < m - 1){
            dfs(mat,row ,col + 1,!flag);
        }else if((col == 0 || col == m - 1)&& row < n - 1){
            dfs(mat,row  + 1 ,col,!flag);
        }
    }
}
