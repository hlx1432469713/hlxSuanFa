import java.util.Scanner;

/**
 *date：2021-12-06
 *
 * message : 不同路径
 *
 * work : 一个机器人位于一个 m x n网格的左上角 （起始点在下图中标记为 “Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 *
 * 问总共有多少条不同的路径？
 *
 *
 *
 */
public class DynamicSixtyOne20211206 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int m = scanner.nextInt();
            int n = scanner.nextInt();
            int result = uniquePaths2(m,n);
            System.out.println(result);
        }

    }
    static  public int uniquePaths(int m, int n) {
        int[][] num = new int[m][n];
        for(int i = 0;i < m;i++)
            num[i][0] = 1;
        for(int i = 0;i < n;i++)
            num[0][i] = 1;
        for(int k = 1;k < m;k++)
            for(int j = 1;j < n;j++)
                num[k][j] = num[k - 1][j] + num[k][j - 1];
        return num[m - 1][n - 1];

    }

    //动态规划
    // 2.1 确定dp数组（dp table）以及下标的含义 : dp[i][j] :代表从（0,0）到达（i,j）位置，共有dp[i][j]条路径
    //  2.2 确定递推公式 :dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
    //  2.3 dp数组如何初始化dp[0 ~ m][0] = 1,dp[0][0 ~ n] = 1
    //  2.4 确定遍历顺序
    //  2.5 举例推导dp数组
    static  public int uniquePaths2(int m, int n){
        int[][] dp = new int[m][n];
        for (int i = 0;i < m;i++)
            dp[i][0] = 1;
        for (int j = 0;j <n;j++)
            dp[0][j] = 1;
        for (int i = 1;i < m;i++)
            for (int j = 1;j < n;j++)
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
        return dp[m - 1][n - 1];
    }
}
