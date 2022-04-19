package shuZu;

import TreeNode.TreeNode;

import java.util.Arrays;
import java.util.Stack;

/**
 *date：2022-04-19
 *
 * message :31. 下一个排列
 *
 * work :整数数组的一个 排列 就是将其所有成员以序列或线性顺序排列。
 *
 * 例如，arr = [1,2,3] ，以下这些都可以视作 arr 的排列：[1,2,3]、[1,3,2]、[3,1,2]、[2,3,1] 。
 * 整数数组的 下一个排列 是指其整数的下一个字典序更大的排列。更正式地，
 * 如果数组的所有排列根据其字典顺序从小到大排列在一个容器中，那么数组的 下一个排列
 * 就是在这个有序容器中排在它后面的那个排列。如果不存在下一个更大的排列，
 * 那么这个数组必须重排为字典序最小的排列（即，其元素按升序排列）。
 *
 * 例如，arr = [1,2,3] 的下一个排列是 [1,3,2] 。
 * 类似地，arr = [2,3,1] 的下一个排列是 [3,1,2] 。
 * 而 arr = [3,2,1] 的下一个排列是 [1,2,3] ，因为 [3,2,1] 不存在一个字典序更大的排列。
 * 给你一个整数数组 nums ，找出 nums 的下一个排列。
 *
 * 必须 原地 修改，只允许使用额外常数空间。
 *
 *
 */
public class shuZuTwoHundredSixtyThree20220419 {
    public static void main(String[] args){}

    public void nextPermutation(int[] nums) {
        if(nums.length == 1)
            return ;
        else if(nums.length == 2){
            int x = nums[1];
            nums[1] = nums[0];
            nums[0] = x;
            return ;
        }
        int right = nums.length - 1;
        int left = right - 1;
        while(left >= 0){
            if(nums[right] > nums[left]){
                change(nums,left,nums.length - 1);
                return;
            }
            left--;
            right--;
        }
        swap(nums,0,nums.length - 1);
        return;
    }
    public void change(int[] nums,int left,int right){
        while(right > left){
            if(nums[right] > nums[left])
                break;
            right--;
        }
        int a = nums[left];
        nums[left] = nums[right];
        nums[right] = a;
        swap(nums,left + 1,nums.length - 1);
    }
    public void swap(int[] nums,int left,int right){
        while(left < right){
            int b = nums[left];
            nums[left] = nums[right];
            nums[right] = b;
            left++;
            right--;
        }
    }
}
