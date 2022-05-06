package shuZu;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 *date：2022-05-06
 *
 * message :1020. 飞地的数量
 *
 * work :给你一个大小为 m x n 的二进制矩阵 grid ，其中 0 表示一个海洋单元格、1 表示一个陆地单元格。
 *
 * 一次 移动 是指从一个陆地单元格走到另一个相邻（上、下、左、右）的陆地单元格或跨过 grid 的边界。
 *
 * 返回网格中 无法 在任意次数的移动中离开网格边界的陆地单元格的数量。
 *
 *
 */
public class shuZuThreeHundredEighteen20220506 {
    public static void main(String[] args){
        int[][] grid = {{0,0,0,1,1,1,0,1,0,0},
                        {1,1,0,0,0,1,0,1,1,1},
                        {0,0,0,1,1,1,0,1,0,0},
                        {0,1,1,0,0,0,1,0,1,0},
                        {0,1,1,1,1,1,0,0,1,0},
                        {0,0,1,0,1,1,1,1,0,1},
                        {0,1,1,0,0,0,1,1,1,1},
                        {0,0,1,0,0,1,0,1,0,1},
                        {1,0,1,0,1,1,0,0,0,0},
                        {0,0,0,0,1,1,0,0,0,1}};
        int result = numEnclaves(grid);
        System.out.println(result);
    }
    //DFS 深度优先搜索
    static public int numEnclaves(int[][] grid) {
        int sum = 0;
        for(int i = 0;i < grid.length;i++)
            for(int j = 0;j < grid[0].length;j++){
                if(i == 0 || j == 0 || i == grid.length - 1 || j == grid[0].length - 1){
                    if(grid[i][j] == 1){
                        dfs(grid,i,j);
                    }
                }
            }
        for(int i = 1;i < grid.length;i++)
            for(int j = 1;j < grid[0].length;j++){
                if(grid[i][j] == 1)
                    sum++;
            }
        return sum;
    }
    static public void dfs(int[][] grid,int row,int col){
        int n = grid.length;
        int m = grid[0].length;
        if(row < 0 || col < 0 || row >= n || col >= m || grid[row][col] != 1)
            return;
        grid[row][col] = 0;
        dfs(grid,row - 1,col);
        dfs(grid,row + 1,col);
        dfs(grid,row,col - 1);
        dfs(grid,row,col + 1);
    }

    //BFS--广度优先搜索
    static int[][] list = {{-1,0},{1,0},{0,-1},{0,1}};
    static public int numEnclaves2(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int sum = 0;
        for(int i = 0;i < n;i++)
            for(int j = 0;j < m;j++){
                if(i == 0 || j == 0 || i == n - 1 || j == m - 1){
                    if(grid[i][j] == 1){
                        queue.add(new int[]{i,j});
                        grid[i][j] = 0;
                    }
                }
            }
        while(!queue.isEmpty()){
            int[] s = queue.poll();
            int x = s[0],y = s[1];
            for(int[] l : list){
                int nx = x + l[0];
                int ny = y + l[1];
                if(nx < 0 || ny < 0 || nx >= n || ny >= m || grid[nx][ny] != 1)
                    continue;
                grid[nx][ny] = 0;
                queue.add(new int[]{nx,ny});
            }
        }
        for(int i = 0;i < n;i++)
            for(int j = 0;j < m;j++)
                if(grid[i][j] == 1)
                    sum++;
        return sum;
    }
}
