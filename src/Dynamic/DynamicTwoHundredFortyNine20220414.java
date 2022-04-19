package Dynamic;

/**
 *date：2022-04-14
 *
 * message : 115. 不同的子序列
 *
 * work :给定一个字符串 s 和一个字符串 t ，计算在 s 的子序列中 t 出现的个数。
 *
 * 字符串的一个 子序列 是指，通过删除一些（也可以不删除）字符且不干扰剩余字符相对位置所组成的新字符串。
 * （例如，"ACE"是"ABCDE"的一个子序列，而"AEC"不是）
 *
 * 题目数据保证答案符合 32 位带符号整数范围。
 *
 *
 *
 */
public class DynamicTwoHundredFortyNine20220414 {
    public static void main(String[] args){}

    /**
     *
     // 2.1 确定dp数组（dp table）以及下标的含义 :dp[i][j] ：当字符串t长度为i，字符串s长度为j时，在 s 的子序列中 t 出现的个数为dp[i][j]。
     //  2.2 确定递推公式 :if (s.charAt(j - 1) == t.charAt(i - 1)){
     //                    dp[i][j] = dp[i - 1][j - 1] + 1;
     //                }else{
     //                    dp[i][j] = dp[i - 1][j];
     //                }
     //  2.3 dp数组如何初始化
     //  2.4 确定遍历顺序：正序遍历
     */
    static  public int numDistinct(String s, String t) {
        int n1 = s.length();
        int n2 = t.length();
        if (n1 == 0 || n2 == 0)
            return 0;
        int[][] dp = new int[n2 + 1][n1 + 1];
        for (int i = 0;i < n1;i++)
            dp[0][i] = 1;
        for (int i = 1;i <= n2;i++){
            for (int j = 1;j <= n1;j++){
                if (s.charAt(j - 1) == t.charAt(i - 1)){
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j - 1];
                }else{
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        return dp[n2][n1];
    }
}
