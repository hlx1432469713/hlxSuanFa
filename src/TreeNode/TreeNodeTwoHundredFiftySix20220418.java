package TreeNode;

import java.util.*;

/**
 *date：2022-04-18
 *
 * message : 103. 二叉树的锯齿形层序遍历
 *
 * work :给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。
 * （即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 */
public class TreeNodeTwoHundredFiftySix20220418 {
    public static void main(String[] args){}
    List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null )
            return list;
        boolean flag = true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            List<Integer> item = new ArrayList<>();
            int length = queue.size();
            while(length > 0){
                TreeNode treeNode = queue.poll();
                item.add(treeNode.val);
                if(treeNode.left!=null)
                    queue.offer(treeNode.left);
                if(treeNode.right!=null)
                    queue.offer(treeNode.right);
                length--;
            }
            if(!flag){
                Collections.reverse(item);
            }
            flag = !flag;
            list.add(item);
        }
        return list;
    }
}
