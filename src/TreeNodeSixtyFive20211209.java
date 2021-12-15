/**
 *date：2021-12-09
 *
 * message : BiNode
 * word : 二叉树数据结构TreeNode可用来表示单向链表（其中left置空，right为下一个链表节点）。
 * 实现一个方法，把二叉搜索树转换为单向链表，要求依然符合二叉搜索树的性质，转换操作应是原址的，
 * 也就是在原始的二叉搜索树上直接修改。
 *
 * 返回转换后的单向链表的头节点。
 * 注意：本题相对原题稍作改动
 */
public class TreeNodeSixtyFive20211209 {
    public static void main(String[] args){}


    TreeNode head = new TreeNode(-1);
    public TreeNode convertBiNode(TreeNode root) {
        if (root == null)
            return null;
        convertBiNode2(root);
        return head.right;


    }
    TreeNode treeNode = null;//记录前一个节点
    //中序遍历（左中右）（通过一个中间节点和一个头节点）
    public void convertBiNode2(TreeNode root){
        if (root == null)
            return;
        convertBiNode2(root.left);
        if (treeNode == null) {
            treeNode = root;
            head.right = root;
        }
        else{
            treeNode.right = root;
            treeNode = root;
        }
        root.left = null;
        convertBiNode2(root.right);
    }

    //中序遍历（右中左）
    public TreeNode convertBiNode3(TreeNode root){
        if (root == null)
            return null;
        convertBiNode3(root.right);
        root.right = treeNode;
        treeNode = root;
        convertBiNode3(root.left);
        root.left = null;
        return treeNode;
    }



}
