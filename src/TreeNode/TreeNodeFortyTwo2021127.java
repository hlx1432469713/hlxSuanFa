package TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 *date：2021-11-27
 *
 * message : 填充每个节点的下一个右侧节点指针II
 *
 * work:  给定一个 二叉树定义如下：（普通二叉树）
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 *
 * 初始状态下，所有next 指针都被设置为 NULL。

 *
 */
public class TreeNodeFortyTwo2021127 {
    public static void main(String[] args){}
    public TreeNode connect2(TreeNode root) {
        if(root == null)
            return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int length = queue.size();
            while(length > 0){
                TreeNode treeNode = queue.poll();
                if(length -1 > 0)
                    treeNode.next = queue.peek();
                if (treeNode.left != null)
                    queue.add(treeNode.left);
                if (treeNode.right != null)
                    queue.add(treeNode.right);
                length--;
            }
        }
        return root;
    }
}
