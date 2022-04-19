package Dynamic;

/**
 *date：2022-04-15
 *
 * message : 647. 回文子串
 *
 * work :给你一个字符串 s ，请你统计并返回这个字符串中 回文子串 的数目。
 *
 * 回文字符串 是正着读和倒过来读一样的字符串。
 *
 * 子字符串 是字符串中的由连续字符组成的一个序列。
 *
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
 *
 *
 */
public class DynamicTwoHundredFiftyTwo20220415 {
    public static void main(String[] args){}

    /**
     // 2.1 确定dp数组（dp table）以及下标的含义 :dp[i][j] :当在字符串s区间[i,j]中，是否为回文子串;
     //  2.2 确定递推公式 : if (s.charAt(i) == s.charAt(j)){
     //                   if (j - i  <= 1){
     //                       dp[i][j] = true;
     //                       sum++;
     //                   }else if (dp[i + 1][j - 1]){
     //                       dp[i][j] = true;
     //                       sum++;
     //                   }
     //               }
     //  2.3 dp数组如何初始化
     //  2.4 确定遍历顺序：正序遍历
     */
    static   public int countSubstrings(String s) {
        int n = s.length();
        if (n == 1)
            return 1;
        boolean[][] dp = new boolean[n][n];
        int sum = 0;
        for (int i = n - 1;i >= 0;i--){
            for (int j = i;j <n;j++){
               if (s.charAt(i) == s.charAt(j)){
                   if (j - i  <= 1){
                       dp[i][j] = true;
                       sum++;
                   }else if (dp[i + 1][j - 1]){
                       dp[i][j] = true;
                       sum++;
                   }
               }
            }
        }
        return sum;
    }
}
