package TreeNode;

/**
 *date：2021-12-14
 *
 * message : 二叉树的最近公共祖先
 * word : 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，
 * 最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大
 * （一个节点也可以是它自己的祖先）。”
 *
 */
public class TreeNodeSixtyEight20211214 {
    public static void main(String[] args){}
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == p || root == q || root == null)
            return root;

        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if (left != null && right != null)
            return root;
        else if (left == null && right != null)
            return right;
        else if (left !=null && right == null )
            return left;
        else
            return null;

    }






}