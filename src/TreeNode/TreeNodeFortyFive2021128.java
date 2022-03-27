package TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 *date：2021-11-28
 *
 * message : 找树左下角的值
 *
 * work:  给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。
 *          假设二叉树中至少有一个节点。
 *
 */
public class TreeNodeFortyFive2021128 {
    //层序遍历迭代法
    public int findBottomLeftValue(TreeNode root) {
        int result = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int length = queue.size();
            result = queue.peek().val;
            while(length > 0){
                TreeNode treeNode = queue.poll();
                if(treeNode.left != null)
                    queue.add(treeNode.left);
                if(treeNode.right != null)
                    queue.add(treeNode.right);
                length--;
            }
        }
        return result;
    }
    int maxLength = 0;
    int result = 0;
    public int findBottomLeftValue1(TreeNode root) {
        findBottomLeftValue2(root,0);
        return result;

    }
    //递归遍历
    public void  findBottomLeftValue2(TreeNode root,int deep){
        if (root == null)
            return;
        deep++;
        if (root.left == null && root.right == null){
            if(deep > maxLength){
                maxLength = deep;
                result = root.val;
                return;
            }
        }
        findBottomLeftValue2(root.left,deep);
        findBottomLeftValue2(root.right,deep);
    }
}
