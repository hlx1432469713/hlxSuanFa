package TreeNode;

import java.util.Stack;

/**
 *date：2022-04-19
 *
 * message :114. 二叉树展开为链表
 *
 * work :给你二叉树的根结点 root ，请你将它展开为一个单链表：
 *
 * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 *
 */
public class TreeNodeTwoHundredSixtyThree20220419 {
    public static void main(String[] args){}

    public  void flatten(TreeNode root) {
        if(root == null)
            return;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        dfs(root,stack);
        TreeNode tmp = stack.pop();
        while(!stack.isEmpty()){
            TreeNode list = stack.pop();
            list.right = tmp;
            list.left = null;
            tmp = list;
        }
        root = tmp;
    }
    public void dfs(TreeNode node ,Stack<TreeNode> stack){
        if (node == null)
            return;
        stack.push(node);
        dfs(node.left,stack);
        dfs(node.right,stack);
    }
}
