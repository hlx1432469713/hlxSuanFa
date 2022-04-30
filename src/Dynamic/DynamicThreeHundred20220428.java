package Dynamic;

/**
 *date：2022-04-28
 *
 * message :剑指 Offer 47. 礼物的最大价值
 *
 * work :在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。
 * 你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。
 * 给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
 *
 *
 */
public class DynamicThreeHundred20220428 {
    public static void main(String[] args){}

    public int maxValue(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        for(int i = 1;i < n;i++)
            grid[i][0] += grid[i - 1][0];
        for(int j = 1;j < m;j++)
            grid[0][j] += grid[0][j - 1];
        for(int i = 1;i < n;i++){
            for(int j = 1;j < m;j++)
                grid[i][j] = Math.max(grid[i - 1][j],grid[i][j - 1]) + grid[i][j];
        }
        return grid[n - 1][m - 1];
    }
}
