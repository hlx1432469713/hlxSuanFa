package Dynamic;

import com.sun.javafx.logging.JFRPulseEvent;

/**
 *date：2022-04-15
 *
 * message : 516. 最长回文子序列
 *
 * work :给你一个字符串 s ，找出其中最长的回文子序列，并返回该序列的长度。
 *
 * 子序列定义为：不改变剩余字符顺序的情况下，删除某些字符或者不删除任何字符形成的一个序列。

 *
 *
 */
public class DynamicTwoHundredFiftyThree20220415 {
    public static void main(String[] args){}
    /**
     // 2.1 确定dp数组（dp table）以及下标的含义 :dp[i][j] :当在字符串s区间[i,j]中，最长回文子序列的长度为dp[i][j];
     //  2.2 确定递推公式 : if (s.charAt(i) == s.charAt(j)){
     //                    if (j - i <= 1)
     //                        dp[i][j] = j - i + 1;
     //                    else{
     //                        dp[i][j] = dp[i + 1][j - 1] + 2;
     //                    }
     //                }else{
     //                    dp[i][j] = Math.max(dp[i + 1][j],dp[i][j - 1]);
     //                }
     //  2.3 dp数组如何初始化
     //  2.4 确定遍历顺序：正序遍历
     */
    static public int longestPalindromeSubseq(String s) {
        int n = s.length();
        if (n == 1)
            return 1;
        int[][] dp = new int[n][n];
        for (int i = n - 1;i >= 0;i--){
            for (int j = i;j < n;j++){
                if (s.charAt(i) == s.charAt(j)){
                    if (j - i <= 1)
                        dp[i][j] = j - i + 1;
                    else{
                        dp[i][j] = dp[i + 1][j - 1] + 2;
                    }
                }else{
                    dp[i][j] = Math.max(dp[i + 1][j],dp[i][j - 1]);
                }
            }
        }
        return dp[0][n - 1];
    }
}
