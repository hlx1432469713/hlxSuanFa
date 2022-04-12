package Dynamic;

import java.util.Arrays;
import java.util.Scanner;

/**
 *date：2022-04-12
 *
 * message :300. 最长递增子序列
 *
 * work :给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 *
 * 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。
 * 例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 *
 */
public class DynamicTwoHundredThirtyEight20220412 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] nums = new int[n];
            for (int i = 0;i < n;i++)
                nums[i] = scanner.nextInt();
            int result = lengthOfLIS(nums);
            System.out.println(result);
        }
    }

    /**
     // 2.1 确定dp数组（dp table）以及下标的含义 :dp[i]:代表以nums[i]结尾的最长子序列长度为dp[i]
     //  2.2 确定递推公式 : for (int j = 0;j < i;j++){
     //                if (nums[i] > nums[j])
     //                    dp[i] = Math.max(dp[i],dp[j] + 1);
     //            }
     //  2.3 dp数组如何初始化:Arrays.fill(dp,1);
     //  2.4 确定遍历顺序:正序遍历
     */
    static  public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return 1;
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        int result = 1;
        for (int i = 1;i <n;i++){
            for (int j = 0;j < i;j++){
                if (nums[i] > nums[j])
                    dp[i] = Math.max(dp[i],dp[j] + 1);
            }
            result = Math.max(result,dp[i]);
        }
        return result;
    }
}
