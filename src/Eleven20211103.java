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
        int result = maxSubArray(nums);
        System.out.println(result);
    }
    //暴力求解
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
    //动态规划法
    static public int maxSubArray1 ( int[] nums){
        return 0;
    }

}
