package Dynamic;

import java.util.Scanner;

/**
 *date：2022-01-18
 *
 * message :  删除并获得点数
 *
 * work :
 * 给你一个整数数组 nums ，你可以对它进行一些操作。
 *
 * 每次操作中，选择任意一个 nums[i] ，删除它并获得 nums[i] 的点数。之后，你必须删除 所有 等于 nums[i] - 1 和 nums[i] + 1 的元素。
 *
 * 开始你拥有 0 个点数。返回你能通过这些操作获得的最大点数。。
 */
public class DynamicEightySeven20220118 {
    public static void main(String[] args){
       Scanner scanner = new Scanner(System.in);
       while(scanner.hasNext()){
           int n = scanner.nextInt();
           int[] nums = new int[n];
           for (int i = 0;i < n;i++)
               nums[i] = scanner.nextInt();
           int flag = deleteAndEarn(nums);
           System.out.println(flag);
       }
    }

    //将其转换成 打家劫舍问题
    static  public int deleteAndEarn(int[] nums) {
        int max = 0;
        for (int i = 0;i < nums.length;i++){
            max = Math.max(max,nums[i]);
        }
        int[] list = new int[max + 1];
        for (int i = 0;i < nums.length;i++){
            list[nums[i]]++;
        }
        //以下就是打家劫舍问题
        int[] dp = new int[max + 1];
        dp[1] = list[1];
        for(int i = 2;i <= max;i++){
            dp[i] = Math.max(dp[i - 2] + i * list[i],dp[i - 1]);
        }
        return dp[max];
    }

}
