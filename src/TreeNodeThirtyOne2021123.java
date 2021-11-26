import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *date：2021-11-23
 *
 * message ：二叉树的最大深度
 *
 * work:给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 */
public class TreeNodeThirtyOne2021123 {
    public static void main(String[] args){


    }
    int max = 0;
    public int maxDepth(TreeNode root) {
        level1(root,0);
        return max;

    }
    //递归
    public void level1(TreeNode node,int deep){
        if (node == null)
            return;
        deep++;
        if(deep > max)
            max = deep;
        level1(node.left,deep);
        level1(node.right,deep);
    }
}
