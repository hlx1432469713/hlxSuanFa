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
            int result = uniquePaths(m,n);
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

}
