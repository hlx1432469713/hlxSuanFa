package TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *date：2022-04-25
 *
 * message :剑指 Offer 07. 重建二叉树
 *
 * work :输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。
 *
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 */
public class TreeNodeTwoHundredEightyEight20220425 {
    public static void main(String[] args){}
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder,0,preorder.length,inorder,0,inorder.length);
    }

    public TreeNode build(int[] preorder ,int preLeft,int preRight,
                          int[] inorder,int inLeft,int inRight){
        if (inLeft >= inRight || preLeft >= preRight)
            return null;

        TreeNode root = new TreeNode(preorder[preLeft]);
        int index = 0;
        for (int i = inLeft;i < inRight;i++){
            if (inorder[i] == root.val) {
                index = i;
                break;
            }
        }
        root.left = build(preorder,preLeft + 1,preLeft + (index - inLeft + 1), inorder,inLeft,index);
        root.right = build(preorder,preLeft + (index - inLeft + 1),preRight, inorder,index + 1,inRight);
        return  root;
    }

}
