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
           int result = integerBreak(n);
           System.out.println(result);
       }
    }
    //将 i 拆分成 j 和 i-j 的和，且 i-j 不再拆分成多个正整数，此时的乘积是 j×(i−j)；
    //将 i 拆分成 j 和 i-j 的和，且 i-j 继续拆分成多个正整数，此时的乘积是 j×dp[i−j]。
    static  public int integerBreak(int n) {
        //dp[i] 代表  可以获得的最大乘积
        int[] dp = new int[n+1];
        for(int i = 2;i <= n;i++){
            for(int j = 1;j < i;j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }
        return dp[n];
    }



}
