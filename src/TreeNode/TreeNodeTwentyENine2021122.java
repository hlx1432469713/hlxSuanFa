package TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *date：2021-11-22
 *
 * message ：层次遍历II(从下面往上遍历)
 *
 * work:给定一个二叉树，返回其节点值自底向上的层序遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 *
 */
public class TreeNodeTwentyENine2021122 {
    public static void main(String[] args){


    }
    List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        levelOrderBottom(root,0);
        return list;

    }
    //递归(广度优先遍历)---根据同一深度的节点放在一起
    public void levelOrderBottom(TreeNode node,int deep){

    }

    //借助辅助队列
    public void level2(TreeNode node){
        if(node == null)
            return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        while(!queue.isEmpty()){
            int length = queue.size();
            List<Integer> item = new ArrayList<>();
            while(length > 0){
                TreeNode node1 = queue.poll();
                item.add(node1.val);
                if(node1.left != null)
                    queue.offer(node1.left);
                if(node1.right != null)
                    queue.offer(node1.right);
                length--;
            }
            list.add(0,item);
        }

    }
}
