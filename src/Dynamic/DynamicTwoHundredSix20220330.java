package Dynamic;

import java.util.HashSet;
import java.util.Set;

/**
 *date：2022-03-30
 *
 * message :  337. 打家劫舍 III
 *
 * work :小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为root。
 *
 * 除了root之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，
 * 聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果 两个直接相连的房子在同一天晚上被打劫 ，房屋将自动报警。
 *
 * 给定二叉树的root。返回在不触动警报的情况下，小偷能够盗取的最高金额。
 *
 *
 */
public class DynamicTwoHundredSix20220330 {
    public static void main(String args[]){}

    /**
     // 2.1 确定dp数组（dp table）以及下标的含义 :下标为0记录不偷该节点所得到的的最大金钱，下标为1记录偷该节点所得到的的最大金钱。
     //  2.2 确定递推公式 :dp[0] = Math.max(left[0],left[1]) + Math.max(right[0],right[1]);
                        dp[1] = left[0]+ right[0] + root.val;
     //  2.3 dp数组如何初始化
     //  2.4 确定遍历顺序：后序遍历
     */
    static  public int rob(TreeNode root) {
        int[] list = dfs(root);
        return Math.max(list[0],list[1]);
    }
    static public int[] dfs(TreeNode root){
        //下标为0记录不偷该节点所得到的的最大金钱，下标为1记录偷该节点所得到的的最大金钱。
        int[] dp = new int[2];
        if(root == null)
            return dp;
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        //不偷该节点 -- 那就是从左右节点中选最大值
        dp[0] = Math.max(left[0],left[1]) + Math.max(right[0],right[1]);
        //偷该节点 -- 那左右节点都不能选取
        dp[1] = left[0]+ right[0] + root.val;
        return dp;
    }
}
