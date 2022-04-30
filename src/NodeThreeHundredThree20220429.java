import TreeNode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *date：2022-04-28
 *
 * message :剑指 Offer 36. 二叉搜索树与双向链表
 *
 * work :输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。
 *
 *
 */
public class NodeThreeHundredThree20220429 {
    public static void main(String[] args){}

    Node first = null;
    Node pre = null;
    public Node treeToDoublyList(Node root) {
        if(root == null)
            return null;
        dfs(root);
        pre.right = first;
        first.left = pre;
        return first;
    }

    public void dfs(Node  root){
        if(root == null)
            return;
        dfs(root.left);
        if(first == null && pre == null){
            first = root;
            pre = root;
        }else{
            pre.right = root;
            root.left = pre;
            pre = root;
        }
        dfs(root.right);
    }
}
