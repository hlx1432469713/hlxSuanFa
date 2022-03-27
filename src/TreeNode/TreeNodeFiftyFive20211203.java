package TreeNode;

/**
 *date：2021-12-03
 *
 * message : 合并二叉树
 *
 * work: 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
 *
 * 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为NULL 的节点将直接作为新二叉树的节点。

 *

 *
 *
 */
public class TreeNodeFiftyFive20211203 {
    public static void main(String[] args){}


    //自己写的递归
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null)
            return null;
        TreeNode treeNode = new TreeNode();
        if(root1 != null && root2!=null) {
            treeNode.val = root1.val + root2.val;
            treeNode.left = mergeTrees(root1.left,root2.left);
            treeNode.right = mergeTrees(root1.right,root2.right);
        }
        else if(root1 != null) {
           treeNode = root1;
        }
        else {
            treeNode = root2;
        }
        return treeNode;
    }

    //优化版递归
    //传入了两个树，那么就有两个树遍历的节点t1 和 t2，如果t1 == NULL 了，两个树合并就应该是 t2 了啊（如果t2也为NULL也无所谓，合并之后就是NULL）。
    //反过来如果t2 == NULL，那么两个数合并就是t1（如果t1也为NULL也无所谓，合并之后就是NULL）。
    public TreeNode mergeTrees2(TreeNode root1, TreeNode root2) {
        if (root1 == null)
            return root2;
        if (root2 == null)
            return root1;

        TreeNode treeNode = new TreeNode(root1.val + root2.val);
        treeNode.left = mergeTrees2(root1.left,root2.left);
        treeNode.right = mergeTrees2(root1.right,root2.right);
        return treeNode;
    }

}
