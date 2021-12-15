/**
 *date：2021-12-09
 *
 * message : 删除给定值的叶子节点
 * word : 给你一棵以root为根的二叉树和一个整数target，请你删除所有值为target 的叶子节点 。
 *
 * 注意，一旦删除值为target的叶子节点，它的父节点就可能变成叶子节点；如果新叶子节点的值恰好也是target ，
 * 那么这个节点也应该被删除。
 *

 */
public class TreeNodeSixtySix20211209 {
    public static void main(String[] args){}


    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root == null)
            return null;
        root.left = removeLeafNodes(root.left,target);
        root.right = removeLeafNodes(root.right,target);
        if (root.left == null && root.right == null && root.val == target)
            return null;
        return root;

    }

    public void removeLeafNodes2(TreeNode root,int target){

    }

}
