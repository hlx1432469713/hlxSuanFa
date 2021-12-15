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

}
