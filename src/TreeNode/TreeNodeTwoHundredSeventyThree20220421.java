package TreeNode;

import java.util.Scanner;

/**
 *date：2022-04-21
 *
 * message :剑指 Offer 54. 二叉搜索树的第k大节点
 *
 * work :给定一棵二叉搜索树，请找出其中第 k 大的节点的值。
 *
 *
 */
public class TreeNodeTwoHundredSeventyThree20220421 {
    public static void main(String[] args){}

    static  int flag = 0;
    int index = 0;
    public int kthLargest(TreeNode root, int k) {
        dfs(root,k);
        return flag;
    }
    public void dfs(TreeNode root,int k){
        if(root == null || index >= k)
            return;
        dfs(root.right,k);
        index++;
        if(index == k){
            flag = root.val;
            return;
        }
        dfs(root.left,k);
    }
}
