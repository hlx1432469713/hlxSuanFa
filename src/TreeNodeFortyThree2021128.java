import java.util.LinkedList;
import java.util.Queue;

/**
 *date：2021-11-28
 *
 * message : 对称二叉树
 *
 * work:  给定一个二叉树，检查它是否是镜像对称的。
 *
 */
public class TreeNodeFortyThree2021128 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return isSymmetricS(root.left,root.right);
    }

    //递归
    public boolean isSymmetricS(TreeNode left , TreeNode right){
        if(left == null && right == null)
            return true;
        if(left == null || right == null || left.val != right.val)
            return false;
        boolean out = isSymmetricS(left.left,right.right);
        boolean in = isSymmetricS(left.right,right.left);
        return out && in;
    }

    //使用队列
    public boolean isSymmetric2(TreeNode root){
        if (root == null)
            return true;
        Queue<TreeNode> queue = new LinkedList<>();
       queue.add(root.left);
       queue.add(root.right);
        while(!queue.isEmpty()){
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            if(left == null  && right == null)
                continue;
            if(left == null || right == null || left.val != right.val)
                return false;
            queue.add(left.left);
            queue.add(right.right);
            queue.add(left.right);
            queue.add(right.left);
        }
        return true;
    }
}
