import java.util.ArrayList;
import java.util.List;

/**
 *date：2021-11-30
 *
 * message : 从中序与后序遍历序列构造二叉树
 *
 * work: 根据一棵树的中序遍历与后序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *


 *
 */
public class TreeNodeFortyEight2021130 {
    //将后序遍历最后一个元素，作为分割点（也是当前节点），对中序遍历进行分割成左中(左闭右开)和右中
    //然后根据左中和右中的大小来将后序遍历（去掉最后一个元素）分割成后左和后右
    int num;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder.length == 0)
            return null;
        num = postorder.length;
      // return buildTree1(inorder,0,inorder.length,postorder,0,postorder.length);
        return buildTree2(inorder,postorder,0,num);
    }

    //左闭右开
    public TreeNode buildTree1(int[] inorder,int inorderLeft,int inorderRight,
                                int[] postorder,int postLeft,int postRight){
        //没有元素
        if(inorderRight - inorderLeft < 1)
            return null;
         if(inorderRight - inorderLeft == 1)//只有一个元素
            return new TreeNode(inorder[inorderLeft]);
        //后序遍历最后一个节点-------》根节点
        int flag = postorder[postRight - 1];
        TreeNode treeNode = new TreeNode(flag);
        int cutId = 0;
        for(int i = inorderLeft;i < inorderRight;i++){
            if(inorder[i] == flag){
                cutId = i;
                break;
            }
        }
        treeNode.left = buildTree1(inorder,inorderLeft,cutId,
                                    postorder,postLeft,postLeft + (cutId - inorderLeft));
        treeNode.right = buildTree1(inorder,cutId+1,inorderRight,
                                    postorder,postLeft + (cutId - inorderLeft),postRight-1);
        return treeNode;
    }

    //左闭右闭（不用管后序遍历）
    public TreeNode buildTree2(int[] inorder,int[] postorder,int left,int right){
        if(right < left)
            return null;
        int flag = postorder[num];
        TreeNode treeNode = new TreeNode(flag);
        int cutId = right;
        for(;cutId >= left;cutId--){
            if(inorder[cutId] == flag){
                break;
            }
        }
        num = num - 1;
        treeNode.right = buildTree2(inorder,postorder,cutId+1,right);
        treeNode.left = buildTree2(inorder,postorder,left,cutId - 1);
        return treeNode;
    }
}
