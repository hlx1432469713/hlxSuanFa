package TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *date：2021-11-22
 *
 * message ：二叉树的层平均值
 *
 * work:给定一个非空二叉树, 返回一个由每层节点平均值组成的数组。
 *
 */
public class TreeNodeThirty2021122 {
    public static void main(String[] args){


    }
    List<Double> list = new ArrayList<>();
    public List<Double> averageOfLevels(TreeNode root){
        level1(root,0);
        return list;

    }
    //递归(广度优先遍历)---根据同一深度的节点放在一起
    public void level1(TreeNode node,int deep){


    }

    //借助辅助队列
    public void level2(TreeNode node){
        if(node == null)
            return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        while(!queue.isEmpty()){
            int length = queue.size();
            double sum = 0,index = queue.size();
            while(length > 0){
                TreeNode node1 = queue.poll();
                sum += sum = node1.val;
                if(node1.left!=null)
                    queue.add(node1.left);
                if(node1.right!=null)
                    queue.add(node1.right);
                length--;
            }
            list.add(sum/index);
        }
    }
}
