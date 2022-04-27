package shuZu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *date：2022-04-27
 *
 * message :417. 太平洋大西洋水流问题
 *
 * work :有一个 m × n 的矩形岛屿，与 太平洋 和 大西洋 相邻。“太平洋”处于大陆的左边界和上边界，而 “大西洋” 处于大陆的右边界和下边界。
 *
 * 这个岛被分割成一个由若干方形单元格组成的网格。给定一个 m x n 的整数矩阵heights，
 * heights[r][c]表示坐标 (r, c) 上单元格 高于海平面的高度 。
 *
 * 岛上雨水较多，如果相邻单元格的高度 小于或等于 当前单元格的高度，
 * 雨水可以直接向北、南、东、西流向相邻单元格。水可以从海洋附近的任何单元格流入海洋。
 *
 * 返回 网格坐标 result的 2D列表 ，其中result[i] = [ri, ci]
 * 表示雨水可以从单元格 (ri, ci) 流向 太平洋和大西洋 。
 *
 *
 */
public class shuZuTwoHundredNinetySeven20220427 {
    public static void main(String[] args){
    }

    static int[][] flag;//1 : 太平洋  2 ： 大西洋  3 ：两者都可
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        List<List<Integer>> list = new ArrayList<>();
        flag = new int[n][m];
        for(int i = 0;i < n;i++){
            for (int j = 0;j < m;j++){
                if(i == 0 || j == 0) dfs(heights,i,j,1);
                if(i == n - 1 || j == m - 1) dfs(heights,i,j,2);
            }
        }
        for(int i = 0;i < n;i++){
            for (int j = 0;j < m;j++){
                if(flag[i][j] == 3){
                    List<Integer> list1 = new ArrayList<>();
                    list1.add(i);
                    list1.add(j);
                    list.add(list1);
                }
            }
        }
        return list;
    }
    public void dfs(int[][] heights ,int row,int col,int num){
        int n = heights.length;
        int m = heights[0].length;
        if(row < 0 || col < 0 || row >= n || col >= m || flag[row][col] == 3 || heights[row][col] == - 1)
            return;
        if(flag[row][col] == 0)
            flag[row][col] = num;
        else if(flag[row][col] == num)
            return;
        else
            flag[row][col] = 3;
        int x = heights[row][col];
        heights[row][col] = - 1;//代表此次深搜已经遍历过这个点
        if(row - 1 >= 0 && heights[row - 1][col] >= x) dfs(heights,row - 1,col,num);
        if(row + 1 < n && heights[row + 1][col] >= x)  dfs(heights,row + 1,col,num);
        if(col - 1 >= 0 && heights[row][col - 1] >= x) dfs(heights,row,col - 1,num);
        if(col+ 1 < m && heights[row][col + 1] >= x)   dfs(heights,row ,col + 1,num);
        heights[row][col] = x;
    }
}
