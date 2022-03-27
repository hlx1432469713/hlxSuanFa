package TreeNode;

import java.util.Scanner;

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
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            int n = scanner.nextInt();
            int result = numTrees2(n);
            System.out.println(result);
        }
    }

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

    //动态规划
    // 2.1 确定dp数组（dp table）以及下标的含义 : dp[i] :代表总节点数为i时，共有dp[i]种二叉搜索树
    //  2.2 确定递推公式 :dp[i] += dp[j] * dp[i -j-1];
    //  2.3 dp数组如何初始化dp[0] = 1
    //  2.4 确定遍历顺序
    //  2.5 举例推导dp数组
    static public int numTrees2(int n){
        if(n <= 2)
            return n;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        //外层代表总共有i个节点
        for (int i = 1;i <= n;i++){
            //内层代表当值为j的节点为根节点，左节点个数为就j - 1,右节点个数为 i-j；
            for (int j = 1;j <= i;j++){
                dp[i] += dp[j - 1] * dp[i -j];
            }
        }
        return dp[n];

    }
}
