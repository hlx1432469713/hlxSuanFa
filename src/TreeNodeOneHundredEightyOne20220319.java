import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *date：2022-03-19
 *
 * message : 652. 寻找重复的子树
 *
 * work :给定一棵二叉树 root，返回所有重复的子树。
 *
 * 对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。
 *
 * 如果两棵树具有相同的结构和相同的结点值，则它们是重复的。
 *
 */
public class TreeNodeOneHundredEightyOne20220319 {
    public static void main(String args[]){

    }
    Map<String,Integer> map = new HashMap<>();
    List<TreeNode> list = new ArrayList<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        backIng(root);
        return list;
    }

    public String backIng(TreeNode root){
        if(root == null)
            return "#";
        String left = backIng(root.left);
        String right = backIng(root.right);
        String s = left + right  + "#" + root.val;
        if(map.containsKey(s) && map.get(s) == 1){
            list.add(root);
        }
        map.put(s,map.getOrDefault(s,0) + 1);
        return s;
    }
}
