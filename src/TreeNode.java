import java.util.List;

/**
 *date：2021-11-22
 *
 * message ：二叉树定义
 *
 *
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    List<TreeNode> children;
    TreeNode(int val){
        this.val = val;
    }
    TreeNode(int val,TreeNode left,TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public void addNode(int val){
        TreeNode newTreeNode = new TreeNode(val);
    }
}
