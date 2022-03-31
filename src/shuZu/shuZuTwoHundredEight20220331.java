package shuZu;


/**
 *date：2022-03-31
 *
 * message :  643. 子数组最大平均数 I
 *
 * work :给你一个由 n 个元素组成的整数数组 nums 和一个整数 k 。
 *
 * 请你找出平均数最大且 长度为 k 的连续子数组，并输出该最大平均数。
 *
 * 任何误差小于 10-5 的答案都将被视为正确答案。
 *
 *
 *
 *
 */
public class shuZuTwoHundredEight20220331 {
    public static void main(String args[]){}


    static  public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        double average = 0.0;
        for (int i = 0;i < k;i++)
            sum += nums[i];
        average = (double)sum / k;
        for (int i = k;i < nums.length;i++){
            sum = sum - nums[i - k] + nums[i];
            average = Math.max(average,(double)sum / k);
        }
        return average;

    }
}
