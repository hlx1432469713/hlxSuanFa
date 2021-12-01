import java.util.LinkedList;
import java.util.Queue;

/**
 *date：2021-11-29
 *
 * message : 路径总和
 *
 * work: 给你二叉树的根节点root 和一个表示目标和的整数targetSum ，判
 * 断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和targetSum 。
 *
 * 叶子节点 是指没有子节点的节点。

 *
 */
public class TreeNodeFortySix2021129 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null )
            return false;
        boolean left = false,right = false;
        if(root.left == null && root.right == null && targetSum - root.val == 0)
            return true;
        if (root.left != null)
            left = hasPathSum(root.left,targetSum - root.val);
        if (root.right != null)
            right = hasPathSum(root.right,targetSum - root.val);
        return left || right;
    }
}
