package TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 *date：2021-11-29
 *
 * message : 路径总和II
 *
 * work: 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 *
 * 叶子节点 是指没有子节点的节点。
 *


 *
 */
public class TreeNodeFortySeven2021129 {
    List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        patSum2(root,targetSum,new ArrayList<Integer>());
        return list;

    }

    public void patSum2(TreeNode root ,int targetSum,List<Integer> item) {
        if (root == null)
            return;
        item.add(root.val);
        if (root.left == null && root.right == null && targetSum == root.val) {
            list.add(new ArrayList<>(item));
            return;
        }
        if (root.left != null) {
            patSum2(root.left, targetSum - root.val, item);
            item.remove(item.size() - 1);
        }
        if (root.right != null) {
            patSum2(root.right, targetSum - root.val, item);
            item.remove(item.size() - 1);
        }
    }
}
