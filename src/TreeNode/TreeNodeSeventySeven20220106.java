package TreeNode;

/**
 *date：2022-01-06
 *
 * message : 二叉树的直径
 * word : 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
 *
 */
public class TreeNodeSeventySeven20220106 {
    public static void main(String[] args){}
    int sum = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        diameterOfBinaryTrees(root);
        return sum;
    }
    public int diameterOfBinaryTrees(TreeNode root){
        if (root == null)
            return 0;
        int left = diameterOfBinaryTrees(root.left);
        int right = diameterOfBinaryTrees(root.right);
        if((left + right) >sum)
            sum = left + right;
        return Math.max(left+1,right+1);
    }

}
