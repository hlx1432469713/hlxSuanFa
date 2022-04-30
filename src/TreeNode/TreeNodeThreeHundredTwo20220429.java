package TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *date：2022-04-28
 *
 * message :剑指 Offer 34. 二叉树中和为某一值的路径
 *
 * work :给你二叉树的根节点 root 和一个整数目标和 targetSum ，
 * 找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 *
 * 叶子节点 是指没有子节点的节点。
 */
public class TreeNodeThreeHundredTwo20220429 {
    public static void main(String[] args){}

    List<List<Integer>> list = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        if(root == null)
            return list;
        dfs(root,target,0);
        return list;
    }
    public TreeNode dfs(TreeNode root,int target,int sum){
        if(root == null){
            return null;
        }
        path.add(root.val);
        TreeNode left = dfs(root.left,target,sum + root.val);
        TreeNode right = dfs(root.right,target,sum + root.val);
        if(left == null && right == null)
            if(sum + root.val == target)
                list.add(new ArrayList<>(path));
        path.removeLast();
        return root;
    }
}
