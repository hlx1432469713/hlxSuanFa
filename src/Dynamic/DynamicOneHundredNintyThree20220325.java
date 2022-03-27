package Dynamic;

import java.util.Scanner;

/**
 *date：2022-03-25
 *
 * message : 377. 组合总和 Ⅳ
 *
 * work ：给你一个由 不同 整数组成的数组 nums ，和一个目标整数 target 。请你从 nums 中找出并返回总和为 target 的元素组合的个数。
 *
 * 题目数据保证答案符合 32 位整数范围。
 *
 * 请注意，顺序不同的序列被视作不同的组合
 */
public class DynamicOneHundredNintyThree20220325 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int n = scanner.nextInt();
            int[] nums = new int[n];
            for (int i = 0;i < n;i++)
                nums[i] = scanner.nextInt();
            int k = scanner.nextInt();
            int result = combinationSum4(nums,k);
            System.out.println(result);
        }

    }
    /**
     // 2.1 确定dp数组（dp table）以及下标的含义 : dp[j]:装满容量为j的背包，共有dp[j]种组合(排列)
     //  2.2 确定递推公式 :   dp[i] += dp[i - nums[j]];
     //  2.3 dp数组如何初始化  dp[0] = 1
     //  2.4 确定遍历顺序：由于顺序不同的序列被视为不同的组合，因此这个算是一个排列问题
                        排列问题：先遍历背容量，再遍历物品
                        (每个物品的数量是无限的)完全背包问题：内层背包容量循环：正序遍历
     */
    static public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for(int i = 1;i<=target;i++){
            for(int j = 0;j <nums.length;j++){
                if(i < nums[j])
                    continue;
                dp[i] += dp[i - nums[j]];
            }
        }
        return dp[target];

    }
}
