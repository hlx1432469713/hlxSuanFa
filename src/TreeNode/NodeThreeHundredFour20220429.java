package TreeNode;

/**
 *date：2022-04-28
 *
 * message :剑指 Offer 28. 对称的二叉树
 *
 * work :请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 *
 *
 */
public class NodeThreeHundredFour20220429 {
    public static void main(String[] args){}

    public boolean isSymmetric(TreeNode root) {
        return dfs(root,root);
    }
    public boolean dfs(TreeNode root1,TreeNode root2){
        if(root1 == null && root2 == null)
            return true;
        else if(root1 == null || root2 == null || root1.val != root2.val)
            return false;
        boolean left = dfs(root1.left,root2.right);
        boolean right = dfs(root1.right,root2.left);
        return left && right;
    }
}
