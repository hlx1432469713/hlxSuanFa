import java.util.ArrayList;
import java.util.List;

/**
 *date：2021-11-28
 *
 * message : 二叉树的所有路径
 *
 * work:  给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。
 *          叶子节点 是指没有子节点的节点。
 *
 */
public class TreeNodeFortyFour2021128 {
    List<String> list = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        binaryTreePaths1(root,"");
        return list;
    }

    public void binaryTreePaths1(TreeNode root,String str){
        if (root == null)
            return;
        if(str.isEmpty())
            str = str + root.val;
        else{
            str = str + "->" + root.val;
        }
        if(root.left == null && root.right == null)
            list.add(str);
        binaryTreePaths1(root.left,str);
        binaryTreePaths1(root.right,str);
    }
}
