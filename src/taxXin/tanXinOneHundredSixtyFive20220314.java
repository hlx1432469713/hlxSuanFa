package taxXin;

import java.util.Arrays;

/**
 *date：2022-03-14
 *
 * message ：714. 买卖股票的最佳时机含手续费
 *
 * work :给定一个整数数组prices，其中 prices[i]表示第i天的股票价格 ；整数fee 代表了交易股票的手续费用。
 *
 * 你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
 *
 * 返回获得利润的最大值。
 *
 * 注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。
 */
public class tanXinOneHundredSixtyFive20220314 {
    public static void main(String[] args){}

    //自己写的--没有通过
    static  public int maxProfit(int[] prices, int fee) {
        int[] index = new int[prices.length - 1];
        int maxSum = 0;
        int flagSum = 0;
        for(int i = 1;i < prices.length;i++){
            index[i - 1] = prices[i] - prices[i - 1];
        }
        for (int j = 0;j < index.length;j++){
            flagSum += index[j];
            if (flagSum > fee){
                maxSum += (flagSum -fee);
                flagSum = flagSum - fee;
            }else if (flagSum < 0){
                flagSum = 0;
            }
        }
        return maxSum;
    }

    static  public int maxProfit2(int[] prices, int fee) {
        int min = prices[0];//买入价格
        int sum = 0;
        for (int i = 1;i < prices.length;i++){
            if (min > prices[i])
                min = prices[i];
            //当天的价格 = 当天股票价格 - 减去手续费
            int todayPrice = prices[i] -fee;
            if (todayPrice > min ){
                //利润 = 当天价格(已经减去手续费) - 买入价格
                sum += todayPrice - min ;
                min = todayPrice;//相当于当天买入股票
            }
        }
        return sum;
    }
}
