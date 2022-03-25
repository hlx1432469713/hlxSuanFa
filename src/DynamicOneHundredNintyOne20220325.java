import java.util.LinkedList;
import java.util.Scanner;

/**
 *date：2022-03-25
 *
 * message : 322. 零钱兑换
 *
 * work ： 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 *
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回-1 。
 *
 * 你可以认为每种硬币的数量是无限的。
 *
 */
public class DynamicOneHundredNintyOne20220325 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int n = scanner.nextInt();
            int[] nums = new int[n];
            for (int i = 0;i < n;i++)
                nums[i] = scanner.nextInt();
            int k = scanner.nextInt();
            int result = coinChange(nums,k);
            System.out.println(result);
        }

    }
    /**
     // 2.1 确定dp数组（dp table）以及下标的含义 : dp[j]:装满容量为j的背包，最少硬币数量为dp[j]
     //  2.2 确定递推公式 :  dp[j] = Math.min(dp[j],dp[j - coins[i]] + 1);
     //  2.3 dp数组如何初始化dp[0] = 0,其他都置为Integer.MAX_VALUE
     //  2.4 确定遍历顺序：先遍历物品，再遍历背包容量    //(每个物品的数量是无限的)完全背包问题：内层背包容量循环：正序遍历
     */
    static public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        int max = Integer.MAX_VALUE;
        dp[0] = 0;
        for(int i = 1;i < dp.length;i++)
            dp[i] = Integer.MAX_VALUE;
        for(int i = 0;i < coins.length;i++){
            for(int j = coins[i];j <= amount;j++){
                if(dp[j - coins[i]] != max)
                    dp[j] = Math.min(dp[j],dp[j - coins[i]] + 1);
            }
        }
        if(dp[amount] == max)
            return -1;
        return dp[amount];

    }
}
