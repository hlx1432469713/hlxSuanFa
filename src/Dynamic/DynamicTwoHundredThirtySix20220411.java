package Dynamic;

import java.util.Scanner;

/**
 *date：2022-04-11
 *
 * message :123. 买卖股票的最佳时机 III
 *
 * work :给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成两笔交易。
 *
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 */
public class DynamicTwoHundredThirtySix20220411 {
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
     // 2.1 确定dp数组（dp table）以及下标的含义 ://dp[i][0] 代表第i天第一次买入股票所获得的最大利润
     //                                                //dp[i][1] 代表第i天的第一次卖出股票所获得的最大利润
     //                                                //dp[i][2] 代表第i天的第二次买入股票所获得的最大利润
     //                                                //dp[i][3] 代表第i天的第二次卖出股票所获得的最大利润
     //  2.2 确定递推公式 : dp[i][0] = Math.max(dp[i - 1][0],-prices[i]);
     //            dp[i][1] = Math.max(dp[i - 1][1],dp[i - 1][0] + prices[i]);
     //            dp[i][2] = Math.max(dp[i - 1][2],dp[i - 1][1] - prices[i]);
     //            dp[i][3] = Math.max(dp[i - 1][3],dp[i - 1][2] + prices[i]);
     //  2.3 dp数组如何初始化
     //  2.4 确定遍历顺序：后序遍历
     */
    static public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 1)
            return 0;
        int[][] dp = new int[n][4];
        dp[0][0] = -prices[0];
        dp[0][2] = -prices[0];//第二次买入的初始化，相当于第0天先买入 ，在卖出，在买入 = - price[0]
        for (int i = 1;i < n;i++){
            dp[i][0] = Math.max(dp[i - 1][0],-prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1],dp[i - 1][0] + prices[i]);
            dp[i][2] = Math.max(dp[i - 1][2],dp[i - 1][1] - prices[i]);
            dp[i][3] = Math.max(dp[i - 1][3],dp[i - 1][2] + prices[i]);
        }
        return  Math.max(dp[n - 1][1],Math.max(dp[n - 1][2],dp[n - 1][3]));

    }

    static public int maxProfit2(int[] prices) {
        int n = prices.length;
        if (n == 1)
            return 0;
        int[] dp = new int[4];
        dp[0] = -prices[0];
        dp[2] = -prices[0];//第二次买入的初始化，相当于第0天先买入 ，在卖出，在买入 = - price[0]
        for (int i = 1;i < n;i++){
           dp[0] = Math.max(dp[0],-prices[i]);
           dp[1] = Math.max(dp[1],dp[0] + prices[i]);
           dp[2] = Math.max(dp[2],dp[1] - prices[i]);
           dp[3] = Math.max(dp[3],dp[2] + prices[i]);
        }
        return  dp[3];

    }
}
