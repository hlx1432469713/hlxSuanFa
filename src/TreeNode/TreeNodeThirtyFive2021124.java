package TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *date：2021-11-24
 *
 * message ： 在每个树行中找最大值
 *
 * work:给定一棵二叉树的根节点 root ，请找出该二叉树中每一层的最大值。
 *
 */
public class TreeNodeThirtyFive2021124 {
    public static void main(String[] args){


    }
    List<Integer> list = new ArrayList<>();
    public List<Integer> largestValues(TreeNode root) {
        largest(root,0);
        return list;

    }

    //递归
    public void largest(TreeNode node,int deep){
        if (node == null)
            return;
        deep++;
        if(list.size() < deep)
            list.add(node.val);
        else if(list.get(deep - 1) < node.val)
            list.set(deep - 1,node.val);

        largest(node.left,deep);
        largest(node.right,deep);
    }

    //层序遍历
    public void largest2(TreeNode node){
        if (node == null)
            return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        while(!queue.isEmpty()){
            int length = queue.size();
            int max = queue.peek().val;
            while(length > 0){
                TreeNode treeNode = queue.poll();
                if(treeNode.val > max)
                    max = treeNode.val;
                if(treeNode.left != null)
                    queue.offer(treeNode.left);
                if(treeNode.right != null)
                    queue.offer(treeNode.right);
                length--;
            }
            list.add(max);
        }

    }

}
