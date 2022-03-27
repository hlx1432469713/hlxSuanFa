package TreeNode;

/**
 *date：2021-12-09
 *
 * message : 检查平衡性
 * word : 实现一个函数，检查二叉树是否平衡。在这个问题中，平衡树的定义如下：任意一个节点，其两棵子树的高度差不超过 1。
 * 示例 1:
 * 给定二叉树 [3,9,20,null,null,15,7]
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回 true 。
 * 示例 2:
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 *       1
 *      / \
 *     2   2
 *    / \
 *   3   3
 *  / \
 * 4   4
 * 返回false 。
 */
public class TreeNodeSixtyFour20211209 {
    public static void main(String[] args){}

    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        return isBalanced2(root) != -1;

    }

    public int isBalanced2(TreeNode root){
        if (root == null)
            return 0;
        int left = isBalanced2(root.left);
        if ( left == -1)//左子树已经不再平衡
            return -1;
        int right = isBalanced2(root.right);
        if (right == -1)//右子树已经不再平衡
            return -1;
        if(Math.abs(left - right) > 1)
            return -1;
        return Math.max(left,right) + 1;

    }

}
