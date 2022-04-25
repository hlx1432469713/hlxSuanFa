package shuZu;

import java.util.HashSet;
import java.util.Set;

/**
 *date：2022-04-24
 *
 * message :剑指 Offer 03. 数组中重复的数字
 *
 * work :找出数组中重复的数字。
 *
 *
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，
 * 但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。

 *
 */
public class shuZuTwoHundredEightyFive20220424 {
    public static void main(String[] args){}
    public int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int x : nums){
            if(set.contains(x))
                return x;
            set.add(x);
        }
        return 0;
    }
    //根据数组的特性之间在数组上面进行修改
    public int findRepeatNumber2(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < n;i++){
            int x = nums[i];
            if(nums[i] < 0){
                x = nums[i] + n;
            }
            if(nums[x] < 0)
                return x;
            nums[x] = nums[x] - n;
        }
        return 0;
    }
}
