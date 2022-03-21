import java.util.Scanner;

/**
 *date：2022-03-21
 *
 * message :  746. 使用最小花费爬楼梯
 *
 * work :给你一个整数数组 cost ，其中 cost[i] 是从楼梯第 i 个台阶向上爬需要支付的费用。一旦你支付此费用，即可选择向上爬一个或者两个台阶。
 *
 * 你可以选择从下标为 0 或下标为 1 的台阶开始爬楼梯。
 *
 * 请你计算并返回达到楼梯顶部的最低花费。
 */
public class DynamicOneHundredEightyThree20220321 {
    public static void main(String[] args){
       Scanner scanner = new Scanner(System.in);
       while(scanner.hasNext()){
           int n = scanner.nextInt();
           int[] nums = new int[n];
           for (int i = 0;i < n;i++)
               nums[i] = scanner.nextInt();
           int flag = minCostClimbingStairs(nums);
           System.out.println(flag);
       }
    }

    //动态规划
    // 2.1 确定dp数组（dp table）以及下标的含义 : dp[i] : 代表 到第i阶楼梯 最低花费为dp[i]
    //  2.2 确定递推公式 : dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
    //  2.3 dp数组如何初始化dp[0] = 0,dp[1] = 0
    //  2.4 确定遍历顺序
    //  2.5 举例推导dp数组
    static  public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;//代表总共有n个台阶
        int[] dp = new int[n + 1];
        if (n == 2)
            return Math.min(cost[0],cost[1]);
        //可以以 0 花费 站在 0号 或者 1 号台阶
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2;i <= n;i++){
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[n];

    }

}
