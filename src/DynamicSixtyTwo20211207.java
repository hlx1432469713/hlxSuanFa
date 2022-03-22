import java.util.Scanner;

/**
 *date：2021-12-07
 *
 * message : 不同路径II
 *
 * work : 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 *

 *
 *
 */
public class DynamicSixtyTwo20211207 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int m = scanner.nextInt();
            int n = scanner.nextInt();
            int[][] obstacleGrid = new int[m][n];
            for(int i = 0;i < m;i++)
                for(int j = 0;j < n;j++)
                    obstacleGrid[i][j] = scanner.nextInt();
            int result = uniquePathsWithObstacles(obstacleGrid);
            System.out.println(result);
        }


    }
    static  public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        int[][] dp = new int[row][col];//默认都为0
        for(int i = 0;i < row;i++){
            if(obstacleGrid[i][0] == 1 ) break;
            else dp[i][0] = 1;
        }
        for(int i = 0;i < col;i++){
            if(obstacleGrid[0][i] == 1) break;
            else dp[0][i] = 1;
        }
        for (int j = 1;j < row;j++){
            for(int k = 1;k < col;k++){
                if(obstacleGrid[j][k] == 1) continue;
                else dp[j][k] = dp[j - 1][k] + dp[j][k - 1];
            }
        }
        return dp[row - 1][col - 1];

    }

    //动态规划
    // 2.1 确定dp数组（dp table）以及下标的含义 : dp[i][j] :代表从（0,0）到达（i,j）位置，共有dp[i][j]条路径
    //  2.2 确定递推公式 :dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
    //  2.3 dp数组如何初始化dp[0 ~ m][0] = 1,dp[0][0 ~ n] = 1,遇到石头就置为0
    //  2.4 确定遍历顺序从左到右，从上到下
    //  2.5 举例推导dp数组
    static  public int uniquePathsWithObstacles2(int[][] obstacleGrid){
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][]dp = new int[m][n];
        for (int i = 0;i < m;i++){
            if(obstacleGrid[i][0] == 1) break;
            dp[i][0] = 1;
        }
        for (int j = 0;j < n;j++){
            if(obstacleGrid[0][j] == 1) break;
            dp[0][j] = 1;
        }
        for (int i = 1;i < m;i++)
            for (int j = 1;j < n;j++){
                if (obstacleGrid[i][j] == 1)
                    dp[i][j] = 0;
                else{
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        return dp[m - 1][n - 1];

    }

}
