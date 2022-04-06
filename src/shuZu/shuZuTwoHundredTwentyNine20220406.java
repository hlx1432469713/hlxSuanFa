package shuZu;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

/**
 *date：2022-04-06
 *
 * message : 581. 最短无序连续子数组
 *
 * work :给你一个整数数组 nums ，你需要找出一个 连续子数组 ，
 * 如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
 *
 * 请你找出符合题意的 最短 子数组，并输出它的长度。
 *
 *
 *
 */
public class shuZuTwoHundredTwentyNine20220406 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            int  n = scanner.nextInt();
            int[] nums = new int[n];
            for (int i = 0;i < n;i++){
                nums[i] =scanner.nextInt();
            }
            int result = findUnsortedSubarray(nums);
            System.out.println(result);
        }
    }
    static public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return 0;
        Stack<Integer> stack = new Stack<>();
        int left = Integer.MAX_VALUE;
        int right = 0;
        stack.push(0);
        for (int i = 1;i < n;i++){
            if (!stack.isEmpty() && nums[i] < nums[stack.peek()]){
                for (int j = stack.size() - 1;j >=0 ;j--){
                    if (nums[i] >= nums[stack.get(j)])
                        break;
                    left = Math.min(left,stack.get(j));
                    right = i;
                }
            }else
                stack.push(i);
        }
        if (left == Integer.MAX_VALUE)
            return 0;
        return right - left + 1;
    }
}
