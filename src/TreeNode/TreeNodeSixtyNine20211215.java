package TreeNode;

/**
 *date：2021-12-15
 *
 * message : 二叉搜索树的最近公共祖先
 * word : 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，
 * 满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * 例如，给定如下二叉搜索树: root =[6,2,8,0,4,7,9,null,null,3,5]
 *
 */
public class TreeNodeSixtyNine20211215 {
    public static void main(String[] args){}
   //常规递归
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q)
            return root;
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if (left !=null && right !=null)
            return root;
        else if (left == null  && right !=null)
            return right;
        else if (left !=null && right == null)
            return left;
        return null;
    }

    //在有序树中 ， 从上到下遍历的时候，cur节点是数值在[p, q]区间中则说明该节点cur就是最近公共祖先了。
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;
        if (root.val > p.val && root.val > q.val){
            TreeNode left = lowestCommonAncestor2(root.left,p,q);
            if (left !=null)
                return left;
        }else if (root.val< p.val && root.val < q.val) {
            TreeNode right = lowestCommonAncestor2(root.right, p, q);
            if (right != null)
                return right;
        }
        return root;
}






}
