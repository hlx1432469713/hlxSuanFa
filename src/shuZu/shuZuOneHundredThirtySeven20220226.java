package shuZu;

import java.util.Scanner;

/**
 *date：2022-02-26
 *
 * message :2016. 增量元素之间的最大差值
 *
 * work : 给你一个下标从 0 开始的整数数组 nums ，该数组的大小为 n ，请你计算 nums[j] - nums[i] 能求得的 最大差值 ，
 * 其中 0 <= i < j < n 且 nums[i] < nums[j] 。
 *
 * 返回 最大差值 。如果不存在满足要求的 i 和 j ，返回 -1 。
 *
 */
public class shuZuOneHundredThirtySeven20220226 {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n =scanner.nextInt();
            int[] nums = new int[n];
            for (int i = 0;i < n;i++){
                nums[i] = scanner.nextInt();
            }
            int result = maximumDifference(nums);
            System.out.println(result);
        }


    }

    //时间复杂度为o(n ^ 2)
    static public int maximumDifference(int[] nums) {
        int right = nums.length - 1;
        int max = -1;
        while (right > 0){
            int left = 0;
            while (left < right) {
                if (nums[left] >= nums[right]) {
                    left++;
                    continue;
                }
                int flag = nums[right] - nums[left];
                max = Math.max(flag, max);
                left++;
            }
            right--;
        }
        return max;
    }

    //时间复杂度为o(n)
    static public int maximumDifference2(int[] nums) {
       int max = -1;
       int min = nums[0];
       for (int i = 1;i < nums.length;i++){
           if (nums[i] <= min)
               min = nums[i];
           else{
               max = Math.max(max,nums[i] - min);
           }
       }
       return max;
    }
}
