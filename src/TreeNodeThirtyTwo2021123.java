import java.util.LinkedList;
import java.util.Queue;

/**
 *date：2021-11-23
 *
 * message ：二叉树的最小深度
 *
 * work:给定一个二叉树，找出其最小深度。
 *
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 *
 * 说明：叶子节点是指没有子节点的节点。
 *
 */
public class TreeNodeThirtyTwo2021123 {
    public static void main(String[] args){


    }
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int deep = 0;
        while (!queue.isEmpty()) {
            int length = queue.size();
            deep++;
            while (length > 0) {
                TreeNode treeNode = queue.poll();
                if (treeNode.left != null ){
                    queue.add(treeNode.left);
                }
                if(treeNode.right !=  null) {
                    queue.add(treeNode.right);
                }
                if(treeNode.left == null && treeNode.right == null) {
                   return deep;
                }
                length--;
            }
        }
        return deep;
    }

}
