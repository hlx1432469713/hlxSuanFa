package TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 *date：2022-04-28
 *
 * message :剑指 Offer 26. 树的子结构
 *
 * work :输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 *
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 *
 *
 */
public class TreeNodeTwoHundredNinetyEight20220428 {
    public static void main(String[] args){
    }

    boolean flag = false;
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if(B == null || A == null)
            return false;
        dfs(A,B);
        return flag;
    }
    public void dfs(TreeNode root,TreeNode tree){
        if(root == null || flag)
            return;
        if(root.val == tree.val){
            flag = dfs2(root,tree);
            if(flag) return;
        }
        dfs(root.left,tree);
        dfs(root.right,tree);
    }
    public boolean dfs2(TreeNode root,TreeNode tree){
        if(tree == null)
            return true;
        if(root == null || root.val != tree .val)
            return false;
        return dfs2(root.left,tree.left) && dfs2(root.right,tree.right);
    }
}
