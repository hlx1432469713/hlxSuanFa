package shuZu;

/**
 *date：2022-04-22
 *
 * message :200. 岛屿数量
 *
 * work :给你一个由'1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 *
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 *
 * 此外，你可以假设该网格的四条边均被水包围。
 *
 */
public class shuZuTwoHundredSeventyEight20220422 {
    public static void main(String[] args){}

    //网格的DFS 基本
    static  public int numIslands(char[][] grid) {
        int sum = 0;
        for (int i = 0;i < grid.length;i++){
            for (int j = 0;j < grid[0].length;j++){
                if (grid[i][j] == 1){
                    sum++;
                    dfs(grid,i,j);
                }
            }
        }
        return sum;
    }
    //网格的DFS 基本遍历框架
    static void dfs(char[][] grid,int row,int col){
        if (!isCorrect(grid,row,col))
            return;
        //如果此时位置不是，未遍历过的  陆地，就直接返回
        if(grid[row][col] != 1)
            return;
        //代表 该陆地 已经被遍历过
        grid[row][col] = 2;
        dfs(grid,row - 1,col);//上
        dfs(grid,row + 1,col);//下
        dfs(grid,row,col - 1);//左
        dfs(grid,row,col + 1);//右
    }

    //判断网格位置是否越界
    static boolean isCorrect(char[][] grid,int row,int col){
        int n = grid.length;
        int m = grid[0].length;
        if(row < 0 || row >= n ||col < 0 || col >= m)
            return false;
        return true;
    }
}
