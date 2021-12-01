import java.util.LinkedList;
import java.util.Queue;

/**
 *date：2021-11-27
 *
 * message : 填充每个节点的下一个右侧节点指针
 *
 * work:  给定一个 完美二叉树(满二叉树) ，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
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
public class TreeNodeFortyOne2021127 {
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

    //递归()
    public TreeNode connect(TreeNode root) {
        if(root == null)
            return null;
        if(root.left != null){
            root.left.next = root.right;
            if(root.next != null){
                root.right.next = root.next.left;
            }
        }
        connect(root.left);
        connect(root.right);
        return root;

    }


}
