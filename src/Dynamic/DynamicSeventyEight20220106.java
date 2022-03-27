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


}
