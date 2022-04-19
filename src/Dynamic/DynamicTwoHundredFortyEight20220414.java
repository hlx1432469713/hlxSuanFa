package Dynamic;

/**
 *date：2022-04-14
 *
 * message : 392. 判断子序列
 *
 * work :给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 *
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。
 * （例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 *
 * 进阶：
 *
 * 如果有大量输入的 S，称作 S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？
 *
 *
 */
public class DynamicTwoHundredFortyEight20220414 {
    public static void main(String[] args){}

    /**
     * 求最多不相交的线，即求两个数组的最长公共子序列的长度
     // 2.1 确定dp数组（dp table）以及下标的含义 :dp[i][j] ：当字符串t长度为i，字符串s长度为j时，相同子序列的长度为dp[i][j]
     //  2.2 确定递推公式 :if (s.charAt(j - 1) == t.charAt(i - 1)){
     //                    dp[i][j] = dp[i - 1][j - 1] + 1;
     //                }else{
     //                    dp[i][j] = dp[i - 1][j];
     //                }
     //  2.3 dp数组如何初始化
     //  2.4 确定遍历顺序：正序遍历
     */
    static  public boolean isSubsequence(String s, String t) {
        int n1 = s.length();
        int n2 = t.length();
        int[][] dp = new int[n2 + 1][n1 + 1];
        for (int i = 1;i <= n2;i++){
            for (int j = 1;j <= n1;j++){
                if (s.charAt(j - 1) == t.charAt(i - 1)){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else{
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        if (dp[n2][n1] == n1)
            return true;
        return false;
    }
}
