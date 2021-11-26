import java.util.LinkedList;
import java.util.Queue;

/**
 *date：2021-11-26
 *
 * message : 翻转二叉树
 *
 * work:  翻转一棵二叉树。
 *
 */
public class TreeNodeForty021126 {
    public static void main(String[] args){}

    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null)
            return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int length = queue.size();
            while(length > 0){
                TreeNode node = queue.poll();
                if(node.val == val)
                    return node;
                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);
                length--;
            }
        }
        return null;
    }

    public TreeNode searchBST2(TreeNode node,int val){
        if (node == null)
            return null;
        if(node.val == val)
            return node;
        else if(node.val > val)
            return searchBST2(node.left,val);
        else
            return  searchBST2(node.right,val);
    }
}
