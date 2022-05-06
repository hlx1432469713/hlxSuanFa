package Dynamic;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 *date：2022-05-05
 *
 * message :1162. 地图分析
 *
 * work :你现在手里有一份大小为n x n的 网格 grid，上面的每个 单元格 都用0和1标记好了。其中0代表海洋，1代表陆地。
 *
 * 请你找出一个海洋单元格，这个海洋单元格到离它最近的陆地单元格的距离是最大的，并返回该距离。如果网格上只有陆地或者海洋，请返回-1。
 *
 * 我们这里说的距离是「曼哈顿距离」（Manhattan Distance）：(x0, y0) 和(x1, y1)这两个单元格之间的距离是|x0 - x1| + |y0 - y1|。
 *
 *
 *
 */
public class DynamicThreeHundredSeventeen20220505 {
    public static void main(String[] args){}
    public int maxDistance(int[][] grid) {
        int n = grid.length;
        int[][] dp = new int[n][n];
        int sum = 0;
        if(grid[0][0] == 0){
            dp[0][0] = 10001;
        }
        int max = -1;
        for(int i = 0;i < n;i++){
            for(int j = 0;j < n;j++){
                if(grid[i][j] != 0){
                    sum++;
                    continue;
                }
                if(i == 0 && j == 0)
                    continue;
                else if(i == 0) dp[i][j] = dp[i][j - 1] + 1;
                else if(j == 0) dp[i][j] = dp[i - 1][j] + 1;
                else dp[i][j] = Math.min(dp[i - 1][j],dp[i][j - 1]) + 1;
            }
        }
        max = dp[n - 1][n - 1];//要等第二次遍历的时候，再去根据dp数组的值去更新max的值
        for(int i = n - 1;i >= 0;i--){
            for(int j = n - 1;j >= 0;j--){
                if(grid[i][j] != 0)
                    continue;
                if(i == n - 1 && j == n - 1)
                    continue;
                else if(i == n - 1) dp[i][j] = Math.min(dp[i][j],dp[i][j + 1] + 1);
                else if(j == n - 1) dp[i][j] = Math.min(dp[i][j],dp[i + 1][j] + 1);
                else dp[i][j] = Math.min(dp[i][j],Math.min(dp[i + 1][j],dp[i][j + 1]) + 1);
                max = Math.max(max,dp[i][j]);
            }
        }
        return sum == 0 || sum == n*n ? -1 : max;
    }

    //BFS--采用队列

    int[][] list = {{-1,0},{1,0},{0,-1},{0,1}};
    public int maxDistance2(int[][] grid){
        int n = grid.length;
        int max = -1;
        Queue<int[]> queue = new ArrayDeque<>();
        for(int i = 0;i < n;i++){
            for(int j = 0;j < n;j++){
                if(grid[i][j] == 1) {
                    queue.add(new int[]{i, j});
                    grid[i][j] = 0;
                }else{
                    grid[i][j] = -1;
                }
            }
        }
        while(!queue.isEmpty()){
            int[] s = queue.poll();
            int x = s[0],y = s[1];
            for(int[] l : list){
                int newX = x + l[0];
                int newY = y + l[1];
                if(newX < 0 || newY < 0 || newX >= n || newY >= n)
                    continue;
                if(grid[newX][newY] == -1){
                    grid[newX][newY] = grid[x][y] + 1;
                    queue.add(new int[]{newX,newY});
                    max = Math.max(grid[newX][newY],max);
                }
            }
        }
        return max;
    }
}
