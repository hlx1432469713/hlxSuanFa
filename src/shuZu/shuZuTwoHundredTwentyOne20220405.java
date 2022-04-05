package shuZu;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *date：2022-04-05
 *
 * message : 剑指 Offer 42. 连续子数组的最大和
 *
 * work : 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 *
 * 要求时间复杂度为O(n)。
 *。
 */
public class shuZuTwoHundredTwentyOne20220405 {
    public static void main(String args[]){}
    //哈希表 + 线性映射
    static public int maxSubArray(int[] nums) {
        int sum = nums[0];
        int ans = 0;
        for (int i = 0;i < nums.length;i++){
            ans += nums[i];
            sum = Math.max(sum,ans);
            if (ans < 0)
                ans = 0;
        }
        return sum;
    }

}
