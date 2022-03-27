package jingsai;

import java.util.List;

/**
 *date：2022-03-27
 *
 * message :5269. 从栈中取出 K 个硬币的最大面值和（困难）
 *
 * work : 一张桌子上总共有 n个硬币 栈。每个栈有 正整数个带面值的硬币。
 *
 * 每一次操作中，你可以从任意一个栈的 顶部取出 1 个硬币，从栈中移除它，并放入你的钱包里。
 *
 * 给你一个列表piles，其中piles[i]是一个整数数组，分别表示第 i个栈里 从顶到底的硬币面值。同时给你一个正整数k，
 * 请你返回在恰好进行k次操作的前提下，你钱包里硬币面值之和最大为多少。
 */
public class eleven20220327 {
    public static void main(String[] args) {}

    /** 分组dp
     // 2.1 确定dp数组（dp table）以及下标的含义 : dp[j]:装满容量为j的背包，最大价值为dp[j]
     //  2.2 确定递推公式 : dp[j] += dp[j - coins[i]];
     //  2.3 dp数组如何初始化  dp[0] = 1
     //  2.4 确定遍历顺序：先遍历物品，再遍历背包容量    (每个物品的数量是无限的)完全背包问题：
     内层背包容量循环：正序遍历
     */
    static public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        //dp[i][j] 为 考虑前i个栈，有j次操作的最大钱币数值总和。--01背包问题
        int[][] dp = new int[piles.size() + 1][k + 1];
        for (int i = 1;i <= piles.size();i++){
            List<Integer> list = piles.get(i - 1);
            //每个栈最多操作次数
            int max = Math.min(list.size(),k);
            //计算前缀和（因为每次只能从栈顶取值）
            int[] sum = new int[max + 1];
            for (int j = 0;j < max;j++){
                sum[j + 1] = sum[j] + list.get(j);
            }
            for (int m = 1;m <= k;m++){
                //Math.min(m,list.size())：目前背包容量为m时，该栈的最多操作次数
                for (int n = 0;n <= Math.min(m,list.size());n++)
                    dp[i][m] = Math.max(dp[i][m],dp[i - 1][m -n] + sum[n]);
            }
        }
        return dp[piles.size()][k];

    }
}
