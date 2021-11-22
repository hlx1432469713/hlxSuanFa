import java.util.*;

/**
 *date：2021-11-22
 *
 * message ：前序遍历，中序遍历，后序遍历(递归遍历)
 *
 * work:给你二叉树的根节点 root ，返回它节点值的 前序/中序/后序 遍历。
 *
 */
public class TreeNodeTwentySeven2021122 {
    public static void main(String[] args){


    }
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preOrder(root,list);
        return list;

    }

    //前序遍历（中左右）
    private void preOrder(TreeNode root,List<Integer> list){
        if(root == null)
            return;
        list.add(root.val);
        preOrder(root.left,list);
        preOrder(root.right,list);

    }

    //中序遍历（左中右）
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(root,list);
        return list;
    }

    private void inorder(TreeNode root,List<Integer> list){
        if(root == null)
            return;
        inorder(root.left,list);
        list.add(root.val);
        inorder(root.right,list);

    }

    //后序遍历（左右中）
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        postorder(root,list);
        return list;
    }
    private void postorder(TreeNode root,List<Integer> list){
        if(root == null)
            return;
        postorder(root.left,list);
        postorder(root.right,list);
        list.add(root.val);
    }

}
