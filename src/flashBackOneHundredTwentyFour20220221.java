import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 *date：2022-02-21
 *
 * message :  目标和
 *
 * work : 给你一个整数数组 nums 和一个整数 target 。
 *
 * 向数组中的每个整数前添加'+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
 *
 * 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
 * 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
 *

 */
public class flashBackOneHundredTwentyFour20220221 {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int n = scanner.nextInt();
            int[] nums = new int[n];
            for (int i = 0;i < n;i++)
                nums[i] = scanner.nextInt();
            int target = scanner.nextInt();
            int result = findTargetSumWays2(nums,target);
            System.out.println(result);
        }

    }

    static int result = 0;
    static  public int findTargetSumWays(int[] nums, int target) {
        if (nums.length == 0)
            return result;
        backtracking(nums,target,0,0);
        return result;

    }
    //回溯法---时间复杂度过高
   static public void backtracking(int[] nums,int target,int start,int sum){
        if (start == nums.length && target == sum){
            result++;
            return;
        }
       if (start < nums.length){
           backtracking(nums,target,start + 1,sum + nums[start]);
           backtracking(nums,target,start + 1,sum - nums[start]);
       }
   }

   //动态规划
   // 2.1 确定dp数组（dp table）以及下标的含义 : dp[i] : 代表总共有dp[i]种方法来填满容量为i的背包，
   //  2.2 确定递推公式 : dp[j] += dp[j - nums[i]];
   //  2.3 dp数组如何初始化dp[0] = 1 背包容量为0，装满该背包有一种方法 就是装0件物品
   //  2.4 确定遍历顺序：先遍历物品，再遍历背包
    static public int findTargetSumWays2(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((sum + target) % 2 == 1 || sum < Math.abs(target))
            return 0;
        int n = (sum + target) / 2;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 0;i < nums.length;i++){
            for (int j = n;j >= nums[i];j--)
                dp[j] += dp[j - nums[i]];
        }
        return dp[n];

    }


}
