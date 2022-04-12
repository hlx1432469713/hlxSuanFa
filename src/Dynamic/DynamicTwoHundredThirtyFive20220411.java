package Dynamic;

import java.util.Scanner;

/**
 *date：2022-04-11
 *
 * message :309. 最佳买卖股票时机含冷冻期
 *
 * work :给定一个整数数组prices，其中第prices[i]表示第i天的股票价格 。
 *
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 *
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 */
public class DynamicTwoHundredThirtyFive20220411 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] list = new int[n];
            for (int i = 0;i < n;i++)
                list[i] = scanner.nextInt();
            int result = maxProfit(list);
            System.out.println(result);

        }
    }

    /**
     // 2.1 确定dp数组（dp table）以及下标的含义 :   //dp[i][0] 代表第i天买入股票所获得的最大利润
                                                //dp[i][1] 代表第i天的冷冻期之前就卖出了股票，今天保持卖出股票状态
                                                //dp[i][2] 代表第i天卖出股票所获得最大利润(就在第i天卖出)
                                                //dp[i][3] 代表第i天为冷冻期
     //  2.2 确定递推公式 :dp[i][0] = max(dp[i - 1][0],dp[i - 1][3] - price,dp[i - 1][1] - price)
                        dp[i][1] = max(dp[i - 1][1],dp[i - 1][3])
                        dp[i][2] = dp[i - 1][0] + price
                        dp[i][3] = dp[i - 1][2]
     //  2.3 dp数组如何初始化
     //  2.4 确定遍历顺序：后序遍历
     */
    static public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n == 1)
            return 0;
        int[][] dp = new int[n][4];
        dp[0][0] = -prices[0];
        for(int i = 1;i < n;i++){
            dp[i][0] = Math.max(dp[i - 1][0],Math.max(dp[i - 1][3] - prices[i],dp[i - 1][1] - prices[i]));
            dp[i][1] = Math.max(dp[i - 1][1],dp[i - 1][3]);
            dp[i][2] = dp[i - 1][0] + prices[i];
            dp[i][3] = dp[i - 1][2];
        }
        return Math.max(dp[n - 1][1],Math.max(dp[n - 1][2],dp[n - 1][3]));
    }

    /**
     // 2.1 确定dp数组（dp table）以及下标的含义 :   //dp[0] 代表买入股票所获得的最大利润
                                                 //dp[1] 代表冷冻期之前就卖出了股票，今天保持卖出股票状态
                                                 //dp[2] 代表卖出股票所获得最大利润
                                                 //dp[3] 代表冷冻期时的最大利润
     //  2.2 确定递推公式 :dp[0] = max(dp[0],dp[3] - price,dp[1] - price)
                         dp[1] = max(dp[1],dp[3])
                         dp[2] = dp[0] + price
                         dp[3] = dp[2]
     //  2.3 dp数组如何初始化
     //  2.4 确定遍历顺序：后序遍历
     */
    static public int maxProfit2(int[] prices) {
        int n = prices.length;
        if(n == 1)
            return 0;
        int[] dp = new int[4];
        dp[0] = -prices[0];
        for(int i = 1;i < n;i++){
            int temp = dp[0];
            int temp1 = dp[2];
            dp[0] = Math.max(dp[0],Math.max(dp[1] ,dp[3]) - prices[i]);
            dp[1] = Math.max(dp[1],dp[3]);
            dp[2] = temp + prices[i];//依赖于上一个dp[0]
            dp[3] = temp1;//依赖于上一个dp[2]
        }
        return Math.max(dp[1],Math.max(dp[2],dp[3]));
    }
}
