import java.util.Scanner;

/**
 *date：2021-11-03
 *
 * message ：自由选择题目(动态规划)
 *
 * work:给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 */
public class Eleven20211103 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int[] nums = new int[x];
        for (int i = 0; i < x; i++) {
            nums[i] = scanner.nextInt();
        }
        int result = maxSubArray1(nums);
        System.out.println(result);
    }
    //暴力求解--超出时间限制
    static public int maxSubArray ( int[] nums){
        int max = 0;
        for(int i = 0;i < nums.length;i++) {
            int sum = 0;
            for (int j = i ; j < nums.length; j++) {
                sum = sum + nums[j];
                if(sum > max){
                    max = sum;
                }
            }
        }
        return max;
    }
    //贪心思想
    //如果 -2 1 在一起，计算起点的时候，一定是从1开始计算，因为负数只会拉低总和，这就是贪心贪的地方！
    //局部最优：当前“连续和”为负数的时候立刻放弃，从下一个元素重新计算“连续和”，
    //          因为负数加上下一个元素 “连续和”只会越来越小。
    //全局最优：选取最大“连续和”
    //局部最优的情况下，并记录最大的“连续和”，可以推出全局最优。
    static public int maxSubArray1 ( int[] nums){
        int maxSum = Integer.MIN_VALUE;
        int index = 0;
        for (int i = 0;i < nums.length;i++){
            index += nums[i];
            maxSum = Math.max(index ,maxSum);
            if (index < 0){
                index = 0;
            }
        }
        return maxSum;
    }

}
