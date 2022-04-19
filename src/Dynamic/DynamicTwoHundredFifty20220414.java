package Dynamic;

/**
 *date：2022-04-14
 *
 * message : 583. 两个字符串的删除操作
 *
 * work :给定两个单词 word1 和 word2 ，返回使得 word1 和  word2 相同所需的最小步数。
 *
 * 每步 可以删除任意一个字符串中的一个字符。
 *
 *
 *
 */
public class DynamicTwoHundredFifty20220414 {
    public static void main(String[] args){}

    /**
     // 2.1 确定dp数组（dp table）以及下标的含义 :dp[i][j] ：当字符串t长度为i，字符串s长度为j时，相同子序列的长度为dp[i][j]
     //  2.2 确定递推公式 :if (s.charAt(j - 1) == t.charAt(i - 1)){
     //                    dp[i][j] = dp[i - 1][j - 1] + 1;
     //                }else{
     //                    dp[i][j] = dp[i - 1][j];
     //                }
     //  2.3 dp数组如何初始化
     //  2.4 确定遍历顺序：正序遍历
     */
    ///转换成求最长公共子序列的长度
    static  public int minDistance(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();
        int[][] dp = new int[n1 + 1][n2 + 1];
        for (int i = 1;i <= n1;i++){
            for (int j = 1;j <= n2;j++){
                if (word1.charAt(i - 1) == word2.charAt(j - 1) ){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i - 1][j],dp[i][j - 1]);
                }
            }
        }
        return (n1 - dp[n1][n2]) + n2 - dp[n1][n2];

    }

    //对两个字符串进行删除操作
    static  public int minDistance2(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();
        int[][] dp = new int[n1 + 1][n2 + 1];
        for(int i = 1;i <= n1;i++) dp[i][0] = i;
        for(int j = 1;j <= n2;j++)dp[0][j] = j;
        for (int i = 1;i <= n1;i++){
            for (int j = 1;j <= n2;j++){
                if (word1.charAt(i - 1) == word2.charAt(j - 1) ){
                    //相等时，不对字符串进行操作
                    dp[i][j] = dp[i - 1][j - 1] ;
                }else{
                    //对word1进行删除操作：dp[i][j] = dp[i - 1][j] + 1
                    //对word2进行删除操作：dp[i][j] = dp[i][j - 1] + 1
                    //对word1,word2同时进行删除操作：dp[i][j] = dp[i - 1][j - 1] + 2
                    dp[i][j] = Math.min(dp[i - 1][j] + 1,Math.min( dp[i][j - 1] + 1, dp[i - 1][j - 1] + 2));
                }
            }
        }
        return dp[n1][n2];

    }
}
