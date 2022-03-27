package TreeNode;

import java.util.*;

/**
 *date：2022-03-19
 *
 * message : 653. 两数之和 IV - 输入 BST
 *
 * work :给定一个二叉搜索树 root 和一个目标结果 k，如果 BST 中存在两个元素且它们的和等于给定的目标结果，则返回 true。
 *
 */
public class TreeNodeOneHundredEightyTwo20220321 {
    public static void main(String args[]){

    }

    Set<Integer> set = new HashSet<>();
    public boolean findTarget(TreeNode root, int k) {
        return inorder(root,k);
    }
    public boolean inorder(TreeNode root,int k){
        if(root == null)
            return false;
        boolean left = inorder(root.left,k);
        boolean right = inorder(root.right,k);
        if(set.contains(k - root.val))
            return true;
        set.add(root.val);
        return left || right;

    }
}
