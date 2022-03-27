package shuZu;

import java.util.*;

/**
 *date：2022-03-04
 *
 * message :  2104. 子数组范围和
 *
 * work : 给你一个整数数组 nums 。nums 中，子数组的 范围 是子数组中最大元素和最小元素的差值。
 *
 * 返回 nums 中 所有 子数组范围的 和 。
 *
 * 子数组是数组中一个连续 非空 的元素序列。
 *
 *
 */
public class shuZuOneHundredFortyEight20220304 {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            int[] nums = new int[n];
            for (int j = 0;j < n;j++)
                nums[j] = scanner.nextInt();
           long result = subArrayRanges(nums);
           System.out.print(result + " ");
        }

    }

    static   public long subArrayRanges(int[] nums) {
        long sum = 0;
        for(int i= 0;i<nums.length;i++){
            int min = nums[i];
            int max = nums[i];
            for(int j = i + 1 ;j < nums.length;j++){
                min = Math.min(min,nums[j]);
                max = Math.max(max,nums[j]);
                sum += (max - min);
            }
        }
        return sum;

    }
}
