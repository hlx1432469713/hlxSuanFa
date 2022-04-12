package shuZu;

/**
 *date：2022-04-12
 *
 * message :264. 丑数 II
 *
 * work :给你一个整数 n ，请你找出并返回第 n 个 丑数 。
 *
 * 丑数 就是只包含质因数 2、3 和/或 5 的正整数。
 */
public class shuZuTwoHundredFortyFour20220412 {
    public static void main(String[] args){}
    static  public int nthUglyNumber(int n) {
        //dp[i]:代表第i个丑数为dp[i]
        //当x为丑数时，2x，3x，5x，必定也为丑数，因此每次都取其三中的最小值
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int q1 = 1,q2 = 1,q3 = 1;
        for(int i = 2;i <=n;i++){
            //dp[q1]必定为丑数，因此 temp1也必定为丑数
            int temp1 = 2 * dp[q1];
            int temp2 = 3 * dp[q2];
            int temp3 = 5 * dp[q3];
            dp[i] = Math.min(temp1,Math.min(temp2,temp3));
            if(dp[i] == temp1)
                q1++;
            if(dp[i] == temp2)
                q2++;
            if(dp[i] == temp3)
                q3++;
        }
        return dp[n];
    }
}
