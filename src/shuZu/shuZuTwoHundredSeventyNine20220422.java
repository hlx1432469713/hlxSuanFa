package shuZu;

/**
 *date：2022-04-22
 *
 * message :463. 岛屿的周长
 *
 * work :给定一个 row x col 的二维网格地图 grid ，其中：grid[i][j] = 1 表示陆地， grid[i][j] = 0 表示水域。
 *
 * 网格中的格子 水平和垂直 方向相连（对角线方向不相连）。整个网格被水完全包围，但其中恰好有一个岛屿（
 * 或者说，一个或多个表示陆地的格子相连组成的岛屿）。
 *
 * 岛屿中没有“湖”（“湖” 指水域在岛屿内部且不和岛屿周围的水相连）。格子是边长为 1 的正方形。网格为长方形，且宽度和高度均不超过 100 。
 * 计算这个岛屿的周长。
 *
 *
 */
public class shuZuTwoHundredSeventyNine20220422 {
    public static void main(String[] args){
        int[][] grid = {{0,1,0,0}, {1,1,1,0},{0,1,0,0},{1,1,0,0}};
        int result = islandPerimeter(grid);
        System.out.println(result);
    }

    static int sum = 0;
    static public int islandPerimeter(int[][] grid) {
        for (int i = 0;i < grid.length;i++){
            for (int j = 0;j < grid[0].length;j++){
                if (grid[i][j] == 1){
                    dfs(grid,i,j);
                    break;
                }
            }
        }
        return sum;
    }

    static public int  dfs(int[][] grid,int row,int col){
        if (!isCorrect(grid,row,col) || grid[row][col] == 0)
            return 1;
        if (grid[row][col] == 2)
            return 0;
        grid[row][col] = 2;
        int up = dfs(grid,row - 1,col);
        int down = dfs(grid,row + 1,col);
        int left = dfs(grid,row ,col - 1);
        int right = dfs(grid,row ,col + 1);
        sum += (up + down + left + right );
        return  0;
    }

    static boolean isCorrect(int[][] grid ,int row,int col){
        int n = grid.length;
        int m = grid[0].length;
        if(row < 0 || row >= n || col < 0 || col >= m)
            return false;
        return true;
    }

}
