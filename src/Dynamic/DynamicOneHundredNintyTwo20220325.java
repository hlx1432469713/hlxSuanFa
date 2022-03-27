package Dynamic;

import java.util.Scanner;

/**
 *date：2022-03-25
 *
 * message : 518. 零钱兑换 II
 *
 * work ： 给你一个整数数组 coins 表示不同面额的硬币，另给一个整数 amount 表示总金额。
 *
 * 请你计算并返回可以凑成总金额的硬币组合数。如果任何硬币组合都无法凑出总金额，返回 0 。
 *
 * 假设每一种面额的硬币有无限个。
 *
 * 题目数据保证结果符合 32 位带符号整数。

 */
public class DynamicOneHundredNintyTwo20220325 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int n = scanner.nextInt();
            int[] nums = new int[n];
            for (int i = 0;i < n;i++)
                nums[i] = scanner.nextInt();
            int k = scanner.nextInt();
            int result = change(k,nums);
            System.out.println(result);
        }

    }
    /**
     // 2.1 确定dp数组（dp table）以及下标的含义 : dp[j]:装满容量为j的背包，共有dp[j]种组合
     //  2.2 确定递推公式 : dp[j] += dp[j - coins[i]];
     //  2.3 dp数组如何初始化  dp[0] = 1
     //  2.4 确定遍历顺序：先遍历物品，再遍历背包容量    (每个物品的数量是无限的)完全背包问题：
                                                  内层背包容量循环：正序遍历
     */
    static  public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for(int i = 0;i <coins.length;i++){
            for(int j = coins[i];j<=amount;j++){
                dp[j] += dp[j - coins[i]];
            }
        }
        return dp[amount];
    }
}
