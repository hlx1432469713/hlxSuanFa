package Dynamic;

import java.util.Scanner;

/**
 *date：2021-12-06
 *
 * message :  爬楼梯
 *
 * work : 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数。
 *
 */
public class DynamicFiftyNine20211206 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int n = scanner.nextInt();
            int x = climbStairs(n);
            int y = climbStairs(n);
            System.out.println(x + " " + y);
        }

    }

    //递归（超出时间限制）
    static int climbStairs(int n) {
        if (n < 1) return 0;
        if(n == 1) return 1;
        if (n == 2) return 2;
        return climbStairs(n -1) + climbStairs(n - 2);
    }

    //优化迭代（压缩空间状态）
    static  int climbStairs2(int n) {
        if (n < 1) return 0;
        if(n == 1) return 1;
        if (n == 2) return 2;
        int per = 1,cur = 2;
        int temp = 0;
        for(int i = 3;i <= n;i++){
            temp = cur;
            cur = per + cur;
            per = temp;
        }
        return cur;

    }

    //动态规划
    // 2.1 确定dp数组（dp table）以及下标的含义 : dp[i] : 代表 到第i阶楼梯 有dp[i]种方法
    //  2.2 确定递推公式 : dp[i] = dp[i - 1] + dp[i -2]
    //  2.3 dp数组如何初始化dp[0] = 0,dp[1] = 1 dp[2] = 2
    //  2.4 确定遍历顺序
    //  2.5 举例推导dp数组
    static int climbStairs3(int n){
        if (n <= 2)
            return n;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i -2];
        }
        return dp[n];
    }

}
