/**
 *date：2022-01-05
 *
 * message : 不同的二叉搜索树
 * word : 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
 *
 *
 *
 */
public class TreeNodeSeventySix20220105 {
    public static void main(String[] args){}

    //采用动态规划
    public int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        for (int i = 1;i <= n;i++){
            for (int j = 1;j <= i;j++){
                dp[i] += dp[j -1] * dp[i - j];
            }
        }
        return dp[n];
    }
}
