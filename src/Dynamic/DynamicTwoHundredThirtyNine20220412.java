package Dynamic;

/**
 *date：2022-04-12
 *
 * message :714. 买卖股票的最佳时机含手续费
 *
 * work :给定一个整数数组prices，其中 prices[i]表示第i天的股票价格 ；整数fee 代表了交易股票的手续费用。
 *
 * 你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
 *
 * 返回获得利润的最大值。
 *
 * 注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。
 *
 *
 *
 *
 */
public class DynamicTwoHundredThirtyNine20220412 {
    public static void main(String[] args){}

    /**
     // 2.1 确定dp数组（dp table）以及下标的含义 :dp[i][0]:代表第i天买入股票最大利润
                                             dp[i][1]:代表第i天卖出股票最大利润
     //  2.2 确定递推公式 : dp[i][0] = Math.max(dp[i - 1][0],dp[i - 1][1] - prices[i]);
     //            dp[i][1] = Math.max(dp[i - 1][1],dp[i - 1][0] + prices[i] - fee);
     //  2.3 dp数组如何初始化
     //  2.4 确定遍历顺序：后序遍历
     */
    static public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        if (n == 1)
            return 0;
        int[][] dp = new int[n][2];
        dp[0][0] = -prices[0];
        for (int i = 1;i < n;i++){
            dp[i][0] = Math.max(dp[i - 1][0],dp[i - 1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1],dp[i - 1][0] + prices[i] - fee);
        }
        return Math.max(dp[n - 1][0],dp[n - 1][1]);

    }

    /**
     // 2.1 确定dp数组（dp table）以及下标的含义 :dp[0]:代表买入股票最大利润
                                             dp[1]:代表卖出股票最大利润
     //  2.2 确定递推公式 :
     //  2.3 dp数组如何初始化
     //  2.4 确定遍历顺序：后序遍历
     */
    static public int maxProfit2(int[] prices, int fee) {
        int n = prices.length;
        if (n == 1)
            return 0;
       int[] dp = new int[2];
       dp[0] = -prices[0];
       for (int i = 1;i < n;i++){
           dp[0] = Math.max(dp[0],dp[1] - prices[i]);
           dp[1] = Math.max(dp[1],dp[0] + prices[i] - fee);
       }
       return Math.max(dp[0],dp[1]);

    }

}
