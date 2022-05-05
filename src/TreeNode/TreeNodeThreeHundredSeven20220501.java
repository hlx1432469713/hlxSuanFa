package TreeNode;

import shuZu.Node;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 *date：2022-05-01
 *
 * message :1305. 两棵二叉搜索树中的所有元素
 *
 * work : 给你 root1 和 root2 这两棵二叉搜索树。请你返回一个列表，其中包含 两棵树 中的所有整数并按 升序 排序。
 *
 */
public class TreeNodeThreeHundredSeven20220501 {
    public static void main(String[] args){}
    List<Integer> list = new ArrayList<>();
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        dfs(root1);
        dfs(root2);
        Collections.sort(list);
        return list;
    }
    public void dfs(TreeNode root){
        if(root == null)
            return;
        dfs(root.left);
        list.add(root.val);
        dfs(root.right);
    }
}
