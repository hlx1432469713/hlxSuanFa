package shuZu;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

/**
 *date：2021-10-30
 *
 * message ：双指针法（移除元素）
 *
 * work:给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 *

 *
 *
 */
public class shuZuEight20211030 {
    public static void main(String[] args){
        Scanner scanner  = new Scanner(System.in);
        int n = scanner.nextInt();
        int nums[] = new int[n];
        int result[] = new int[n];
        for(int i = 0;i < n;i++)
            nums[i] = scanner.nextInt();
         result = sortedSquares(nums);
    }

    static public int[] sortedSquares(int[] nums){
        for(int i = 0;i<nums.length;i++)
            nums[i] = nums[i]*nums[i];
        Arrays.sort(nums);
        return nums;

    }
    //双指针方法
    static public int[] sortedSquares2(int[] nums){
        int length = nums.length -1;
        int result[] = new int[length+1];
        int first = 0,end = nums.length-1;
        for(;first <= end;){
            if(nums[first]*nums[first]>nums[end]*nums[end]){
                result[length--] = nums[first]*nums[first];
                first++;
            }else{
                result[length--] = nums[end]*nums[end];
                end--;
            }
        }
        return result;
    }
}
