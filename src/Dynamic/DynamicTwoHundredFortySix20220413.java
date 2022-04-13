package Dynamic;

/**
 *date：2022-04-13
 *
 * message :1143. 最长公共子序列
 *
 * work :给定两个字符串text1 和text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。
 *
 * 一个字符串的子序列是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 *
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
 * 两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。
 *
 */
public class DynamicTwoHundredFortySix20220413 {
    public static void main(String[] args){}

    /**
     // 2.1 确定dp数组（dp table）以及下标的含义 :dp[i][j] ：当字符串A长度为i，字符串B长度为j时，最长公共子序列的长度为dp[i][j]。
     //  2.2 确定递推公式 :
     //  2.3 dp数组如何初始化
     //  2.4 确定遍历顺序：后序遍历
     */
    static  public int longestCommonSubsequence(String text1, String text2) {
        int n1 = text1.length();
        int n2 = text2.length();
        int[][] dp = new int[n1 + 1][n2 + 1];
        for (int i = 1;i <= n1;i++){
            for (int j = 1;j <= n2;j++){
                if (text1.charAt(i - 1) == text2.charAt(j - 1)){
                    dp[i][j] = dp[i -1][j - 1] + 1;
                }else{
                    //如果两个字符 不相等，则要比较A长度为i- 1和B长度为j时  以及A长度为i和B长度为j- 1时的最长公共子序列的长度
                    dp[i][j] = Math.max(dp[i - 1][j],dp[i][j - 1]);
                }
            }
        }
        return dp[n1][n2];
    }
}
