package Dynamic;

/**
 *date：2022-04-15
 *
 * message : 72. 编辑距离
 *
 * work :给你两个单词word1 和word2， 请返回将word1转换成word2 所使用的最少操作数 。
 *
 * 你可以对一个单词进行如下三种操作：
 *
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 *
 */
public class DynamicTwoHundredFiftyOne20220415 {
    public static void main(String[] args){}

    /**
     // 2.1 确定dp数组（dp table）以及下标的含义 :dp[i][j] ：当字符串word1长度为i，字符串word2长度为j时，word1转换成word2最少操作数
     //  2.2 确定递推公式 :  if (word1.charAt(i - 1) == word2.charAt(j - 1)){
     //                    dp[i][j] = dp[i - 1][j - 1];//当两个字符串相等时，不需要做任何操作
     //                }else{
     //                    //当两个字符串不相等时，可以进行对word1进行增删改 三种操作
     //                    //改：dp[i][j] = dp[i - 1][j - 1] + 1
     //                    //删（删除word1的一个字符,相当于word2增加一个字符）：dp[i][j] = dp[i][j - 1] + 1;
     //                    //增（增word1一个字符）：dp[i][j] = dp[i - 1][j ] + 1
     //                    dp[i][j] = Math.min(dp[i - 1][j - 1] + 1,Math.min(dp[i - 1][j],dp[i][j - 1]) + 1);
     //                }
     //  2.3 dp数组如何初始化
     //  2.4 确定遍历顺序：正序遍历
     */
    static   public int minDistance(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();
        int[][] dp = new int[n1 + 1][n2 + 1];
        for (int i = 1;i <= n1;i++){
            dp[i][0] = i;
        }
        for (int j = 1;j <= n2;j++){
            dp[0][j] = j;
        }
        for (int i = 1;i <= n1;i++){
            for (int j = 1;j <= n2;j++){
                if (word1.charAt(i - 1) == word2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1];//当两个字符串相等时，不需要做任何操作
                }else{
                    //当两个字符串不相等时，可以进行对word1进行增删改 三种操作
                    //改：dp[i][j] = dp[i - 1][j - 1] + 1
                    //删（删除word1的一个字符,相当于word2增加一个字符）：dp[i][j] = dp[i][j - 1] + 1;
                    //增（增word1一个字符）：dp[i][j] = dp[i - 1][j ] + 1
                    dp[i][j] = Math.min(dp[i - 1][j - 1] + 1,Math.min(dp[i - 1][j],dp[i][j - 1]) + 1);
                }
            }
        }
        return dp[n1][n2];
    }
}
