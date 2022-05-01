package shuZu;

import TreeNode.TreeNode;

import java.util.Arrays;

/**
 *date：2022-04-30
 *
 * message :908. 最小差值 I
 *
 * work :给你一个整数数组 nums，和一个整数 k 。
 *
 * 在一个操作中，您可以选择 0 <= i < nums.length 的任何索引 i 。将 nums[i] 改为 nums[i] + x ，
 * 其中 x 是一个范围为 [-k, k] 的整数。对于每个索引 i ，最多 只能 应用 一次 此操作。
 *
 * nums的分数是nums中最大和最小元素的差值。
 *
 * 在对 nums 中的每个索引最多应用一次上述操作后，返回nums 的最低 分数
 *
 *
 */
public class shuZuThreeHundredFive20220430 {
    public static void main(String[] args){}

    public int smallestRangeI(int[] nums, int k) {
        if(nums.length == 1)
            return 0;
        Arrays.sort(nums);
        int max = nums[nums.length - 1] - k;
        int min = nums[0] + k;
        return max - min < 0 ? 0 : max - min;
    }
}
