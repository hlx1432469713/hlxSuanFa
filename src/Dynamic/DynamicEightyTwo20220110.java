package Dynamic;

import java.util.Scanner;

/**
 *date：2022-01-10
 *
 * message :  打家劫舍II
 *
 * work : 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。
 * 这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。
 * 同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。
 */
public class DynamicEightyTwo20220110 {
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
    static   public int rob(int[] nums) {
        //动态规划 1 23 5 6
        //dp数组代表 在第i个房间所能偷窃到的最高金额
        //当偷第一个房间，最高金额就是第一个房间存放的金额
        //当偷第二个房间，最高金额就是max{nums[0],nums[1]}
        //当到第k个房间，分两种情况 1.偷第k个房间，那最高金额就是dp[i -2] + nums[k - 1]
        //                      2.不偷第k个房间，那最高金额就是dp[i -1];
        //最后到第k个房间，最高金额 max{dp[i -2] + nums[k - 1],dp[i -1]}

        //首尾房间相连
        //[0,length-2] [1,length -1];
        int num1 = robs(nums,0,nums.length - 2);
        int num2 = robs(nums,1,nums.length - 1);
        return Math.max(num1,num2);
    }

    static public int robs(int[] nums,int start,int end) {
        int length = nums.length;
        if (length == 1)
            return nums[0];
        else if(length == 2)
            return Math.max(nums[1],nums[0]);
        int[] dp = new int[length];
        dp[start] = nums[start];
        dp[start + 1] = Math.max(nums[start], nums[start + 1]);
        for (int i = start+2; i <= end; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[end];
    }


    // 2.1 确定dp数组（dp table）以及下标的含义 :dp[i]：偷窃i个房间，最多能偷盗dp[i]金额
    //  2.2 确定递推公式 :    dp[i] = Math.max(dp[i - 1] ,dp[i - 2] + nums[i - 1]);
    //  2.3 dp数组如何初始化    dp[1] = nums[0];
    //                     dp[2] = Math.max(nums[0],nums[1]);
    //  2.4 确定遍历顺序：i是由i - 1 和 i- 2 确定的，所以遍历顺序为正序遍历
    static  public int rob2(int[] nums){
        //偷窃第一家房间
        if(nums.length == 1)
            return nums[0];
        int x = robs1(nums,0,nums.length -2);
        int y = robs1(nums,1,nums.length - 1);
        return Math.max(x,y);

    }
    static public int robs1(int[] nums,int start,int end){
        int n = end - start + 1;
        int[] dp = new int[n + 1];
        dp[1] = nums[start];
        start++;
        for(int i = 2;i <= n;i++){
            dp[i] = Math.max(dp[i - 1],dp[i - 2] + nums[start]);
            start++;
        }
        return dp[n];
    }
}
