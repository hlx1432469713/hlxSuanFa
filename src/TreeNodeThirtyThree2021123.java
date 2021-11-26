import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *date：2021-11-23
 *
 * message ：二叉树的右视图
 *
 * work:给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，
 * 返回从右侧所能看到的节点值。
 *
 */
public class TreeNodeThirtyThree2021123 {
    public static void main(String[] args){


    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null)
            return list;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int length = queue.size();
            while(length > 0){
                TreeNode treeNode = queue.poll();
                if(length - 1 == 0)
                    list.add(treeNode.val);
                if (treeNode.left != null ){
                    queue.add(treeNode.left);
                }
                if(treeNode.right !=  null) {
                    queue.add(treeNode.right);
                }
                length--;
            }
        }
        return list;

    }

}
