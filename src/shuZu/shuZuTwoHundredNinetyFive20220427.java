package shuZu;

import java.util.Scanner;

/**
 *date：2022-04-27
 *
 * message :剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
 *
 * work :输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有奇数在数组的前半部分，所有偶数在数组的后半部分。
 *
 */
public class shuZuTwoHundredNinetyFive20220427 {
    public static void main(String[] args){
    }

    static public int[] exchange(int[] nums) {
        int left = 0,right = nums.length - 1;
        while(left < right){
            if(nums[left] % 2 == 0) {
                while (left < right) {
                    if (nums[right] % 2 == 1) {
                        int x = nums[right];
                        nums[right] = nums[left];
                        nums[left] = x;
                        right--;
                        break;
                    } else {
                        right--;
                    }
                }
            }
            left++;
        }
        return nums;
    }
    static public int[] exchange2(int[] nums) {
        int left = 0,right = nums.length - 1;
        while(left < right){
           if((nums[left] & 1) == 1){
               left++;
               continue;
           }
           if((nums[right] & 1) == 0){
               right--;
               continue;
           }
           int tmp = nums[right];
           nums[right] = nums[left];
           nums[left] = tmp;
        }
        return nums;
    }

}
