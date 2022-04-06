package Dynamic;

import java.util.Scanner;

/**
 *date：2022-01-06
 *
 * message :  买卖股票的最佳时机
 *
 * work : 给定一个数组 prices ，它的第i 个元素prices[i] 表示一支给定股票第 i 天的价格。
 *
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 *
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 *
 */
public class DynamicSeventyEight20220106 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] prices = new int[n];
            for (int i = 0; i < n; i++)
                prices[i] = scanner.nextInt();
            int result = maxProfit1(prices);
            System.out.println(result);
        }
    }
    //贪心--取最左最小值和最右最大值
    static public int maxProfit1(int[] prices) {
        int minS = prices[0];
        int result = 0;
        for(int i = 0;i < prices.length;i++){
            minS = Math.min(minS,prices[i]);
            result = Math.max(result,prices[i] - minS);
        }
        return result;

    }

    /** 动态规划
     // 2.1 确定dp数组（dp table）以及下标的含义 :dp[i][0] 表示第i天持有股票所得最多现金 ，
                                            dp[i][1] 表示第i天不持有股票所得最多现金
     //  2.2 确定递推公式 :dp[0] = Math.max(left[0],left[1]) + Math.max(right[0],right[1]);
     dp[1] = left[0]+ right[0] + root.val;
     //  2.3 dp数组如何初始化
     //  2.4 确定遍历顺序：后序遍历
     */
    static public int maxProfit2(int[] prices) {
        //该题需要注意的是，只能买卖一次    -price
        if (prices == null || prices.length == 0) return 0;
        int[][] dp = new int[prices.length][2];
        dp[0][0] = -prices[0];
        for(int i = 1;i < prices.length;i++){
            int price = prices[i];
            dp[i][0] = Math.max(dp[i - 1][0],-price);
            //dp[i - 1][0] + price ----相当于卖出股票
            dp[i][1] = Math.max(dp[i - 1][1],dp[i - 1][0] + price);
        }
        //经过prices.length - 1 天后，最后肯定是卖出了股票，所以返回的是不持有股票的最大值
        return dp[prices.length - 1][1];
    }

}
