package TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *date：2022-02-25
 *
 * message : 95. 不同的二叉搜索树 II
 *
 * work : 给你一个整数 n ，请你生成并返回所有由 n 个节点组成且节点值从 1 到 n 互不相同的不同 二叉搜索树 。
 * 可以按 任意顺序 返回答案。
 *
 * 输入：n = 3
 * 输出：[[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]
 *
 * 输入：n = 1
 * 输出：[[1]]
 */
public class TreeNodeOneHundredThirtyFive20220225 {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int n = scanner.nextInt();
            List<TreeNode> newList = generateTrees(n);
        }
    }
    static List<TreeNode> list = new ArrayList<>();
    static TreeNode treeNode = new TreeNode(0);
    static public List<TreeNode> generateTrees(int n) {
        return  backtracking2(1,n);
    }

    //回溯for循环 求子集(失败)
    static public void backtracking(int n,boolean[] flag,int num){
        if (num == n){
            TreeNode treeNodes = treeNode;
            list.add(treeNodes);
            return;
        }

        for (int i = 1;i <= n;i++){
            TreeNode treeNodeNew = new TreeNode(i);
            if (flag[i - 1] == true)
                continue;
            flag[i - 1] = true;
            if (treeNode.val == 0) {
                treeNode = treeNodeNew;
            }
            else {
                if (treeNode.val < treeNodeNew.val) {
                    treeNode.right = treeNodeNew;
                    treeNode.left = null;
                }
                else {
                    treeNode.right = null;
                    treeNode.left = treeNodeNew;
                }
            }
            backtracking(n,flag,num+1);
            flag[i - 1] = false;
        }
    }

    //根据二叉搜索树的性质 左子树的值小于 根节点   右子树的值大于根节点
    static public List<TreeNode> backtracking2(int start,int end){
        List<TreeNode> list = new ArrayList<>();
        if (start > end){
            list.add(null);
            return list;
        }
        for (int i = start;i <= end;i++){
            List<TreeNode> left = backtracking2(start,i-1);
            List<TreeNode> right = backtracking2(i + 1,end);
            for (TreeNode leftTreeNode : left)
                for (TreeNode rightTreeNode : right){
                    TreeNode root = new TreeNode(i);
                    root.left = leftTreeNode;
                    root.right = rightTreeNode;
                    list.add(root);
                }
        }
        return list;

    }
}
