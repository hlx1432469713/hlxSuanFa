package Dynamic;

import java.util.Scanner;

/**
 *date：2022-04-11
 *
 * message :188. 买卖股票的最佳时机 IV
 *
 * work :给定一个整数数组prices ，它的第 i 个元素prices[i] 是一支给定的股票在第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
 *
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 *
 */
public class DynamicTwoHundredThirtySeven20220411 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] list = new int[n];
            for (int i = 0;i < n;i++)
                list[i] = scanner.nextInt();
           // int result = maxProfit(list);
            //System.out.println(result);

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
    static public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if(k == 0 || n <= 1)
            return 0;
        int[]dp = new int[2 * k];
        for(int i = 0;i < 2 * k;i = i + 2){
            dp[i] = -prices[0];
        }
        for (int i = 1;i < n;i++){
            dp[0] = Math.max(dp[0],-prices[i]);
            dp[1] = Math.max(dp[1],dp[0] + prices[i]);
            for (int j = 2;j < 2 *k;j = j + 2){
                dp[j] = Math.max(dp[j],dp[j - 1] - prices[i]);
                dp[j + 1] = Math.max(dp[j + 1],dp[j] + prices[i]);
            }
        }
        return dp[2 * k - 1];
    }
}
