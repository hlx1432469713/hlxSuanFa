package shuZu;

import java.util.LinkedList;
import java.util.Queue;

/**
 *date：2022-05-06
 *
 * message :1034. 边界着色
 *
 * work :给你一个大小为 m x n 的整数矩阵 grid ，表示一个网格。另给你三个整数row、col 和 color 。
 * 网格中的每个值表示该位置处的网格块的颜色。
 *
 * 两个网格块属于同一 连通分量 需满足下述全部条件：
 *
 * 两个网格块颜色相同
 * 在上、下、左、右任意一个方向上相邻
 * 连通分量的边界 是指连通分量中满足下述条件之一的所有网格块：
 *
 * 在上、下、左、右任意一个方向上与不属于同一连通分量的网格块相邻
 * 在网格的边界上（第一行/列或最后一行/列）
 * 请你使用指定颜色color 为所有包含网格块grid[row][col] 的 连通分量的边界 进行着色，并返回最终的网格grid
 *
 */
public class shuZuThreeHundredNineteen20220506 {
    public static void main(String[] args){}
    //BFS---广度优先搜索
    int[][] list = {{-1,0},{1,0},{0,-1},{0,1}};
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        int n = grid.length,m = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visit = new boolean[n][m];
        queue.add(new int[]{row,col});
        visit[row][col] = true;
        int c = grid[row][col];
        while(!queue.isEmpty()){
            int[] s = queue.poll();
            int x = s[0],y = s[1];
            //作为连通分量边界条件之一：在网格的边界上（第一行/列或最后一行/列）
            if(x == 0 || x == n - 1 || y == 0 || y == m - 1)
                grid[x][y] = color;
            for(int[] l : list){
                int nx = x + l[0];
                int ny = y + l[1];
                if(nx < 0 || ny < 0 || nx >= n || ny >= m || visit[nx][ny])
                    continue;
                //作为连通分量边界条件之二：在上、下、左、右任意一个方向上与不属于同一连通分量的网格块相邻（相邻两个网络快的颜色不同）
                if(grid[nx][ny] != grid[x][y])
                    grid[x][y] = color;
                if(grid[nx][ny] == c){
                    queue.add(new int[]{nx,ny});
                    visit[nx][ny] = true;
                }

            }
        }
        return grid;
    }

}
