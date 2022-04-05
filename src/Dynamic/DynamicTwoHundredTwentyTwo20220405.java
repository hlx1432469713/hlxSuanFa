package Dynamic;


import java.util.Scanner;

/**
 *date：2022-04-05
 *
 * message : 剑指 Offer 14- I. 剪绳子
 *
 * work : 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），
 * 每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18
 *
 *。
 */
public class DynamicTwoHundredTwentyTwo20220405 {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            int n = scanner.nextInt();
            int result = cuttingRope(n);
            System.out.println(result);
        }
    }
    static   public int cuttingRope(int n) {
        if (n == 2 || n== 3)
            return n - 1;
        int[] dp = new int[n + 1];
        for (int i = 2;i <= n;i++){
            for (int j = 1;j < i;j++){
                dp[i] = Math.max(dp[i],Math.max(j * (i - j),j * dp[i - j]));
            }
        }
        return dp[n];
    }

}
