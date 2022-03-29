package Dynamic;

import java.util.Scanner;

/**
 *date：2022-03-26
 *
 * message : 279. 完全平方数
 *
 * work ：给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。
 *
 * 完全平方数 是一个整数，其值等于另一个整数的平方；
 * 换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
 *
 */
public class DynamicOneHundredNintyFive20220326 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int n = scanner.nextInt();
            int result = numSquares(n);
            System.out.println(result);
        }
    }
    /**
     // 2.1 确定dp数组（dp table）以及下标的含义 :
     //  2.2 确定递推公式 :
     //  2.3 dp数组如何初始化
     //  2.4 确定遍历顺序：
     */
    static   public int numSquares(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        int max = Integer.MAX_VALUE;
        for(int i = 1;i < dp.length;i++)
            dp[i] = max;
        for(int i = 1;i <= n;i++){
            if(isPerfectSquare(i)){
                for(int j = i;j<=n;j++){
                    if(dp[j -i] != max){
                        dp[j] = Math.min(dp[j],dp[j - i] + 1);
                    }
                }
            }
        }
        return dp[n];
    }
    static public int numSquares2(int n) {
        /**
         * 首先背包物品是无限的，所以是个完全背包问题，内层循环：正序遍历
         * 其次是求组合，所以遍历顺序是先遍历物品，再遍历背包容量
         */
        int[] dp = new int[n + 1];
        dp[0] = 0;
        int max = Integer.MAX_VALUE;
        for (int i = 1;i < dp.length;i++)
            dp[i] = max;
        //先遍历物品
        for (int i = 1;i*i <= n;i++){
            //再遍历背包容量，每次都从完全平方数开始
            for (int j = i*i;j <=n;j++){
                if(dp[j - i*i] !=max){
                    dp[j] = Math.min(dp[j],dp[j - i*i] + 1);
                }
            }
        }
        return dp[n];
    }
    static public boolean isPerfectSquare(int num) {
        int left = 0;
        int right = num / 2 ;
        if(num == 1)
            return true;
        while(left <= right){
            int mid = left + ((right - left)>>1);
            if((long)mid * mid == num)
                return true;
            else if((long)mid * mid < num){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return false;
    }
}
