import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *date：2021-11-22
 *
 * message ：层次遍历（递归和借助辅助队列）（从上面往下遍历）
 *
 * work:给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）
 *
 */
public class TreeNodeTwentyEight2021122 {
    public static void main(String[] args){


    }
    List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        level1(root,0);
        return list;

    }
    //递归(广度优先遍历)---根据同一深度的节点放在一起
    public void level1(TreeNode node,int deep){
        if(node == null)
            return;
        deep++;
        if(list.size() < deep){
            List<Integer> item = new ArrayList<>();
            list.add(item);
        }
        list.get(deep - 1).add(node.val);
        level1(node.left,deep);
        level1(node.right,deep);
    }

    //借助辅助队列
    public void level2(TreeNode node){
        if(node == null)
            return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        while(!queue.isEmpty()){
            List<Integer> item = new ArrayList<>();
            int length = queue.size();
            while(length > 0){
                TreeNode treeNode = queue.poll();
                item.add(treeNode.val);
                if(treeNode.left != null)
                    queue.offer(treeNode.left);
                if(treeNode.right != null)
                    queue.offer(treeNode.right);
                length--;
            }
            list.add(item);
        }

    }
}
