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
     // 2.1 确定dp数组（dp table）以及下标的含义 : dp[j]:装满容量为j的背包，共有dp[j]种组合(排列)
     //  2.2 确定递推公式 :   dp[i] += dp[i - nums[j]];
     //  2.3 dp数组如何初始化  dp[0] = 1
     //  2.4 确定遍历顺序：由于顺序不同的序列被视为不同的组合，因此这个算是一个排列问题
                        排列问题：先遍历背容量，再遍历物品
                        (每个物品的数量是无限的)完全背包问题：内层背包容量循环：正序遍历
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
