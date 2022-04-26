package shuZu;

import java.util.Scanner;

/**
 *date：2022-04-26
 *
 * message :883. 三维形体投影面积
 *
 * work :在n x n的网格grid中，我们放置了一些与 x，y，z 三轴对齐的1 x 1 x 1立方体。
 *
 * 每个值v = grid[i][j]表示 v个正方体叠放在单元格(i, j)上。
 *
 * 现在，我们查看这些立方体在 xy、yz和 zx平面上的投影。
 *
 * 投影就像影子，将 三维 形体映射到一个 二维 平面上。从顶部、前面和侧面看立方体时，我们会看到“影子”。
 *
 * 返回 所有三个投影的总面积 。
 *
     提示：
     n == grid.length == grid[i].length
     1 <= n <= 50
     0 <= grid[i][j] <= 50
 *
 */
public class shuZuTwoHundredNinetyTwo20220426 {
    public static void main(String[] args){}

    static  public int projectionArea(int[][] grid) {
        int sum = 0;
        int xz = 0;
        int yz = 0;
        for(int i = 0;i < grid.length;i++){
            int x = grid[i][0];
            int s = grid[0][i];
            for(int j = 0;j < grid[0].length;j++){
                if(grid[i][j] != 0)
                    sum++;
                x = Math.max(x,grid[i][j]);
                s = Math.max(s,grid[j][i]);
            }
            xz += x;
            yz += s;
        }
        sum += xz  + yz;
        return sum;
    }
}
