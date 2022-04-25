package TreeNode;

/**
 *date：2022-04-23
 *
 * message :剑指 Offer 27. 二叉树的镜像
 *
 * work :请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 *
 * 例如输入：
 *
 *    4
 *  /  \
 *  2   7
 * / \  / \
 * 1  3 6  9
 * 镜像输出：
 *
 *    4
 *  /  \
 *  7   2
 * / \  / \
 * 9  6 3 1
 */
public class TreeNodeTwoHundredEightyOne20220423 {
    public static void main(String[] args){}
    public TreeNode mirrorTree(TreeNode root) {
        return dfs(root);

    }
    public TreeNode dfs(TreeNode root){
        if(root ==null)
            return null;
        TreeNode left = dfs(root.left);
        TreeNode right = dfs(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}
