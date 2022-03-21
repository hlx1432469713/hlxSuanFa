import java.util.Scanner;

/**
 *date：2022-03-03
 *
 * message ：122. 买卖股票的最佳时机 II
 * work :给定一个数组 prices ，其中prices[i] 表示股票第 i 天的价格。
 *
 * 在每一天，你可能会决定购买和/或出售股票。你在任何时候最多只能持有 一股 股票。
 * 你也可以购买它，然后在 同一天 出售。
 * 返回 你能获得的 最大 利润。
 *
 *
 *
 */
public class tanXinOneHundredFortySix20220303 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int n = scanner.nextInt();
            int[] g = new int[n];
            for (int i = 0;i < n;i++){
              g[i] = scanner.nextInt();
            }
            int result = maxProfit(g);
            System.out.println(result);
        }
    }
    static   //最大利润就是全部正利润相加
    public int maxProfit(int[] prices) {
        int maxNum = 0;
        for(int i = 1;i < prices.length;i++){
            if(prices[i] - prices[i - 1] > 0)
                maxNum += prices[i] - prices[i - 1];
        }
        return maxNum;
    }
}
