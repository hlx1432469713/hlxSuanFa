/**
 *date：2021-11-30
 *
 * message : 从前序与中序遍历序列构造二叉树
 *
 * work: 给定一棵树的前序遍历 preorder 与中序遍历  inorder。请构造二叉树并返回其根节点。
 *


 *
 */
public class TreeNodeFortyNine2021130 {
    int num = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree1(preorder,inorder,num,preorder.length - 1);

    }

    //左闭右闭
    public TreeNode buildTree1(int[] preorder, int[] inorder,int left, int right ){
        if(right < left)
            return null;
        int flag = preorder[num];
        TreeNode treeNode = new TreeNode(flag);//作为根节点
        int cudId = right;
        for(;cudId >= left;cudId--){
            if (inorder[cudId] == flag)
                break;
        }
        num++;
        treeNode.left = buildTree1(preorder,inorder,left,cudId - 1);
        treeNode.right = buildTree1(preorder,inorder,cudId + 1,right);
        return treeNode;
    }
}
