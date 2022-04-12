package Dynamic;

import java.util.Arrays;

/**
 *date：2022-04-12
 *
 * message :674. 最长连续递增序列
 *
 * work :给定一个未经排序的整数数组，找到最长且 连续递增的子序列，并返回该序列的长度。
 *
 * 连续递增的子序列 可以由两个下标 l 和 r（l < r）确定，如果对于每个 l <= i < r，
 * 都有 nums[i] < nums[i + 1] ，那么子序列 [nums[l], nums[l + 1], ..., nums[r - 1], nums[r]] 就是连续递增子序列。
 *

 *
 *
 *
 *
 */
public class DynamicTwoHundredForty20220412 {
    public static void main(String[] args){}

    /**
     // 2.1 确定dp数组（dp table）以及下标的含义 :dp[i]:代表以长度为i的数组的最长连续递增序列的长度为dp[i]
     //  2.2 确定递推公式 :
     //  2.3 dp数组如何初始化
     //  2.4 确定遍历顺序：后序遍历
     */
    static  public int findLengthOfLCIS(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return 1;
        int[] dp = new int[n + 1];
        int result = 0;
        Arrays.fill(dp,1);
        for(int i = 2;i <= n;i++){
            if (nums[i - 1] > nums[i - 2]){
                dp[i] =dp[i - 1] + 1;
                result = Math.max(result,dp[i]);
            }
        }
        return dp[n];
    }


    static  public int findLengthOfLCIS2(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return 1;
        int maxLength = 1;
        int ans = 1;
        for(int i = 1;i < n;i++){
            if (nums[i] > nums[i - 1]){
                ans++;
                maxLength = Math.max(maxLength,ans);
            }else{
                ans = 1;
            }
        }
        return maxLength;
    }
}
