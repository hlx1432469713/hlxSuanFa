package hash;


/**
 *date：2022-04-01
 *
 * message : 1493. 删掉一个元素以后全为 1 的最长子数组
 *
 * work :给你一个二进制数组 nums ，你需要从中删掉一个元素。
 *
 * 请你在删掉元素的结果数组中，返回最长的且只包含 1 的非空子数组的长度。
 *
 * 如果不存在这样的子数组，请返回 0 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-subarray-of-1s-after-deleting-one-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *

 *
 */
public class hashTwoHundredFourteen20220401 {
    public static void main(String args[]){}

    static public int longestSubarray(int[] nums) {
        int sum = 1;
        int left = 0;
        int right = 0;
        int max = 0;
        while(left <= right && right < nums.length){
            if(nums[right] == 0){
                sum--;
            }
            while(sum < 0){
                if(nums[left] == 0){
                    sum++;
                }
                left++;
            }
            if(nums[left] == 1 || nums[right] == 1)
                max = Math.max(max,right - left);
            right++;
        }
        return max;

    }
}
