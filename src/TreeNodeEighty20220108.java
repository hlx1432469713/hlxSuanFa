/**
 *date：2022-01-08
 *
 * message : 二叉树的坡度
 * word : 一个树的 节点的坡度 定义即为，该节点左子树的节点之和和右子树节点之和的 差的绝对值 。如果没有左子树的话，左子树的节点之和为 0 ；
 * 没有右子树的话也是一样。空结点的坡度是 0 。
 *
 * 整个树 的坡度就是其所有节点的坡度之和。
 *

 *
 */
public class TreeNodeEighty20220108 {
    public static void main(String[] args){}
    int sum = 0;
    public int findTilt(TreeNode root){
        findTilt2(root);
        return sum;
    }
    public int findTilt2(TreeNode root) {
        if (root == null)
            return 0;
        int left = findTilt2(root.left);
        int right = findTilt2(root.right);
        sum += Math.abs(left - right);
        return root.val + left + right;

    }


}

