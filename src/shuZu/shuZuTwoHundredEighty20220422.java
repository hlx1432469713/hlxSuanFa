package shuZu;

/**
 *date：2022-04-22
 *
 * message :695. 岛屿的最大面积
 *
 * work :给你一个大小为 m x n 的二进制矩阵 grid 。
 *
 * 岛屿是由一些相邻的1(代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在 水平或者竖直的四个方向上 相邻。
 * 你可以假设grid 的四个边缘都被 0（代表水）包围着。
 *
 * 岛屿的面积是岛上值为 1 的单元格的数目。
 *
 * 计算并返回 grid 中最大的岛屿面积。如果没有岛屿，则返回面积为 0 。

 *
 *
 */
public class shuZuTwoHundredEighty20220422 {
    public static void main(String[] args){}
    int max = 0;
    int sum = 0;
    public int maxAreaOfIsland(int[][] grid) {
        for (int i = 0;i < grid.length;i++){
            for (int j = 0;j < grid[0].length;j++){
                if(grid[i][j] == 1){
                    sum = 0;
                    dfs(grid,i,j);
                    max = Math.max(sum,max);
                }
            }
        }
        return max;
    }
    public void dfs(int[][] grid,int row,int col){
        int n = grid.length;
        int m = grid[0].length;
        if(row < 0 || col < 0 || row >= n || col >= m)
            return;
        if (grid[row][col] != 1)
            return;
        grid[row][col] = 2;
        sum++;
        dfs(grid,row - 1,col);
        dfs(grid,row + 1,col);
        dfs(grid,row,col - 1);
        dfs(grid,row,col + 1);
    }
}
