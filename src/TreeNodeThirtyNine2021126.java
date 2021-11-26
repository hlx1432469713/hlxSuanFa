import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *date：2021-11-25
 *
 * message : 翻转二叉树
 *
 * work:  翻转一棵二叉树。
 *
 */
public class TreeNodeThirtyNine2021126 {
    public static void main(String[] args) {
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int length = queue.size();
            while (length > 0) {
                TreeNode treeNode = queue.poll();
                TreeNode temp = treeNode.left;
                treeNode.left = treeNode.right;
                treeNode.right = temp;
                if (treeNode.left != null)
                    queue.add(treeNode.left);
                if (treeNode.right != null)
                    queue.add(treeNode.right);
                length--;
            }
        }
            return root;
    }
    public TreeNode invertTree2(TreeNode root) {
        if (root == null)
            return null;
        TreeNode left = invertTree2(root.left);
        TreeNode right = invertTree2(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
  

}
