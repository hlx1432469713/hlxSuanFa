package TreeNode;

/**
 *date：2021-12-15
 *
 * message : 删除二叉搜索树中的节点
 * word : 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的key对应的节点，并保证二叉搜索树的性质不变。
 * 返回二叉搜索树（有可能被更新）的根节点的引用。
 *
 * 一般来说，删除节点可分为两个步骤：
 *
 * 首先找到需要删除的节点；
 * 如果找到了，删除它。
 *

 *
 */
public class TreeNodeSeventyOne20211215 {
    public static void main(String[] args){}
   //常规递归

    /**
     * 第一种情况：没找到删除的节点，遍历到空节点直接返回了
     * 找到删除的节点
     * 第二种情况：左右孩子都为空（叶子节点），直接删除节点， 返回NULL为根节点
     * 第三种情况：删除节点的左孩子为空，右孩子不为空，删除节点，右孩子补位，返回右孩子为根节点
     * 第四种情况：删除节点的右孩子为空，左孩子不为空，删除节点，左孩子补位，返回左孩子为根节点
     * 第五种情况：左右孩子节点都不为空，则将删除节点的左子树头结点（左孩子）放到删除节点的右子树的最左面节点的左孩子上，返回删除节点右孩子为新的根节点。
     * @param root
     * @param key
     * @return
     */
   public TreeNode deleteNode(TreeNode root, int key) {
       if (root == null)
           return null;
       if (root.val == key){
           if (root.left == null )
               return root.right;
           else if ( root.right == null)
               return root.left;
           else {
               TreeNode right = root.right;
               while(right.left !=null){
                   right = right.left;
               }
               right.left = root.left;
               return  root.right;
           }
       }
       else if (root.val > key)
           root.left = deleteNode(root.left,key);
       else if (root.val < key)
           root.right = deleteNode(root.right,key);
       return root;

   }



}
