package TreeNode;

/**
 *date：2021-12-05
 *
 * message :  二叉搜索树的最小绝对差
 *
 * work : 给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
 *
 * 差值是一个正数，其数值等于两值之差的绝对值。
 *
 */
public class TreeNodeFiftySeven20211205 {
    public static void main(String[] args){}

    int min = Integer.MAX_VALUE;
    TreeNode minNode;//获取中序遍历的上一个节点
    public int getMinimumDifference(TreeNode root) {
         getMinimumDifference2(root);
         return min;
    }
    //中序遍历（会形成一个有序递增的数组）
    public void getMinimumDifference2(TreeNode root) {
      if (root == null)
          return;
      getMinimumDifference2(root.left);
      if(minNode !=null){
          int flag = root.val - minNode.val;
          min = Math.min(min,flag);
      }
      minNode = root;
      getMinimumDifference2(root.right);
    }

}
