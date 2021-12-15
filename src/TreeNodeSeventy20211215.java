/**
 *date：2021-12-15
 *
 * message : 二叉搜索树中的插入操作
 * word : 给定二叉搜索树（BST）的根节点和要插入树中的值，将值插入二叉搜索树。 返回插入后二叉搜索树的根节点。
 * 输入数据 保证 ，新值和原始二叉搜索树中的任意节点值都不同。
 *
 * 注意，可能存在多种有效的插入方式，只要树在插入后仍保持为二叉搜索树即可。 你可以返回 任意有效的结果 。
 *

 *
 */
public class TreeNodeSeventy20211215 {
    public static void main(String[] args){}
   //常规递归
   public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null)
            return new TreeNode(val);
        insertIntoBST2(root,val);
        return root;
   }

   public void insertIntoBST2(TreeNode root,int val){
        //遍历左子树
       if (root.val > val) {
           if (root.left == null){
               TreeNode newNode = new TreeNode(val);
               root.left = newNode;
               return;
           }
           insertIntoBST2(root.left, val);
       }
       //遍历右子树
       if (root.val < val) {
           if (root.right == null){
               TreeNode newNode = new TreeNode(val);
               root.right = newNode;
               return;
           }
           insertIntoBST2(root.right, val);
       }
   }

}
