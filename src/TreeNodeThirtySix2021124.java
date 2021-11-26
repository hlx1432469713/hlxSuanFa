import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *date：2021-11-24
 *
 * message ： 左叶子之和
 *
 *
 *
 * work:计算给定二叉树的所有左叶子之和。
 *
 */
public class TreeNodeThirtySix2021124 {
    public static void main(String[] args){}
    int sum = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        if(root.left!=null)
            sumOfLeft(root,0,true);
        else
            sumOfLeft(root,0,false);
        return sum;

    }
    public void sumOfLeft(TreeNode node,int deep,boolean done){
        if (node == null)
            return;
        deep++;
        if(done && node.left==null && node.right==null){
            sum += node.val;
        }
        sumOfLeft(node.left, deep, true);
        sumOfLeft(node.right,deep,false);
    }
}
