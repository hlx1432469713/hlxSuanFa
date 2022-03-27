package Dynamic;

import java.util.Scanner;

/**
 *date：2022-01-10
 *
 * message :  打家劫舍
 *
 * work : 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，
 * 影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
 * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 */
public class DynamicEightyOne20220110 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int n = scanner.nextInt();
            int[] nums = new int[n];
            for(int i = 0;i < n;i++)
                nums[i] = scanner.nextInt();
            int result = rob(nums);
            System.out.println(result);
        }

    }
    //动态规划 1 23 5 6
    //dp数组代表 在第i个房间所能偷窃到的最高金额
    //当偷第一个房间，最高金额就是第一个房间存放的金额
    //当偷第二个房间，最高金额就是max{nums[0],nums[1]}
    //当到第k个房间，分两种情况 1.偷第k个房间，那最高金额就是dp[i -2] + nums[k - 1]
    //                      2.不偷第k个房间，那最高金额就是dp[i -1];
    //最后到第k个房间，最高金额 max{dp[i -2] + nums[k - 1],dp[i -1]}
    static  public int rob(int[] nums) {
        int length = nums.length;
        if (length == 1)
            return nums[0];
        int[] dp = new int[length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for (int i = 2;i <length;i++){
            dp[i] = Math.max(dp[i - 2] + nums[i],dp[i - 1]);
        }
        return dp[length - 1];
    }

    //使用滚动数组--空间复杂度为o(1)
    static  public int rob2(int[] nums) {
        int length = nums.length;
        if (length == 1)
            return nums[0];

        int first = nums[0];
        int second = Math.max(nums[0],nums[1]);
        for (int i = 2;i <length;i++){
           int temp = second;
           second = Math.max(first + nums[i],second);
           first = temp;
        }
        return second;
    }


}
