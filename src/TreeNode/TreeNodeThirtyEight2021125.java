package TreeNode;

/**
 *date：2021-11-24
 *
 * message ： 平衡二叉树
 *
 * work:给定一个二叉树，判断它是否是高度平衡的二叉树。
 *
 * 本题中，一棵高度平衡二叉树定义为：一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
 *
 */
public class TreeNodeThirtyEight2021125 {
    public static void main(String[] args){}

    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        return treeDeep(root) != -1;
    }

    public int treeDeep(TreeNode node){
      if (node == null)
          return 0;
      int left = treeDeep(node.left);
      if(left == -1)
          return -1;
      int right = treeDeep(node.right);
      if(right == -1)
          return -1;
      if(Math.abs(left-right) > 1)
          return -1;
      return Math.max(left,right) + 1;
    }
}
