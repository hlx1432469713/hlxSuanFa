package Dynamic;


import java.util.Scanner;

/**
 *date：2022-04-05
 *
 * message : 剑指 Offer 13. 机器人的运动范围
 *
 * work : 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。
 * 一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），
 * 也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，
 * 因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 *
 */
public class DynamicTwoHundredTwentyThree20220405 {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            int m = scanner.nextInt();
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int result = movingCount(m,n,k);
            System.out.println(result);
        }
    }
    static int sum = 0;
    static public int movingCount(int m, int n, int k) {
        dfs(m,n,k,0,0, new boolean[m][n]);
        return sum;
    }
    //用一个数组来判断这个是否在递归过程中已经访问过
    //只需要往右或者往下进行深度优先遍历即可
    static public void dfs(int m,int n,int k,int x,int y,boolean[][] list){
        if (x >= m || y >=n || getNum(x,y) > k || list[x][y] == true)
            return;
        sum++;
        list[x][y] = true;
        dfs(m,n,k,x,y + 1,list);
        dfs(m,n,k,x + 1,y,list);
    }
    static public int getNum(int x,int y){
        int sum = 0;
        while(x > 0 || y > 0){
            if (x > 0){
                sum += x % 10;
                x = x / 10;
            }
            if (y > 0){
                sum += y % 10;
                y = y / 10;
            }
        }
        return sum;
    }

}
