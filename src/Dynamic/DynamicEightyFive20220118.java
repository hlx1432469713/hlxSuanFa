package Dynamic;

import java.util.Scanner;

/**
 *date：2022-01-18
 *
 * message :   整数拆分
 *
 * work : 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
 */
public class DynamicEightyFive20220118 {
    public static void main(String[] args){
       Scanner scanner = new Scanner(System.in);
       while(scanner.hasNext()){
           int n = scanner.nextInt();
           int result = integerBreak2(n);
           System.out.println(result);
       }
    }

    static  public int integerBreak(int n)  {
        //将 i 拆分成 j 和 i-j 的和，且 i-j 不再拆分成多个正整数，此时的乘积是 j×(i−j)；
        //将 i 拆分成 j 和 i-j 的和，且 i-j 继续拆分成多个正整数，此时的乘积是 j×dp[i−j]。
        //dp[i] 代表  可以获得的最大乘积
        int[] dp = new int[n+1];
        for(int i = 2;i <= n;i++){
            for(int j = 1;j < i;j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }
        return dp[n];
    }


    //动态规划
    // 2.1 确定dp数组（dp table）以及下标的含义 : dp[i] :代表整数i可以获得的最大乘积
    //  2.2 确定递推公式 :dp[i] = Math.max(dp[i],Math.max(j * (i -j),j * dp[i - j]));
    //  2.3 dp数组如何初始化dp[1] = 1
    //  2.4 确定遍历顺序
    //  2.5 举例推导dp数组
    static  public int integerBreak2(int n){
        //将 i 拆分成 j 和 i-j 的和，且 i-j 不再拆分成多个正整数，此时的乘积是 j×(i−j)；
        //将 i 拆分成 j 和 i-j 的和，且 i-j 继续拆分成多个正整数，此时的乘积是 j×dp[i−j]。
       int[] dp = new int[n + 1];
       dp[2] = 1;
       for (int i = 3;i <= n;i++){
           for (int j = 1;j < i;j++){
               dp[i] = Math.max(dp[i],Math.max(j * (i -j),j * dp[i - j]));
           }
       }
       return dp[n];
    }

}
