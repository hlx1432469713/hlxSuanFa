package shuZu;

import java.util.HashMap;
import java.util.Map;

/**
 *date：2022-05-05
 *
 * message :713. 乘积小于 K 的子数组
 *
 * work :给你一个整数数组 nums 和一个整数 k ，请你返回子数组内所有元素的乘积严格小于 k 的连续子数组的数目。
 *
 */
public class shuZuThreeHundredFifteen20220505 {
    public static void main(String[] args){}
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k == 0)
            return 0;
        int sum = 0;
        int left = 0,right = 0;
        int all = 1;
        while(right < nums.length){
            all *= nums[right++]; //每次相乘后，就将right进行+ 1，这样可以用来计算以right为边界（不包括right）的子数组的数目
            while(left < right && all >= k){
                all /= nums[left++];
            }
            //求连续子数组数目，每次 都加上  以right为边界（不包括right）的子数组的数目
            sum += right - left;
        }
        return sum;
    }
}
