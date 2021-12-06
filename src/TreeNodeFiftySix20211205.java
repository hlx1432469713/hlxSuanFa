import java.util.ArrayList;
import java.util.List;

/**
 *date：2021-12-05
 *
 * message :  验证二叉搜索树（中序遍历的数组为一个递增数组）
 *
 * work: 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 *
 * 有效 二叉搜索树定义如下：
 *
 * 节点的左子树只包含 小于 当前节点的数。
 * 节点的右子树只包含 大于 当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 *
 */
public class TreeNodeFiftySix20211205 {
    public static void main(String[] args){}

    List<Integer> list = new ArrayList<>();
    public boolean isValidBST2(TreeNode root) {
        isValidBST1(root);
        if (list.size() == 1)
            return true;
        for(int i = 0 ;i <list.size();i++){
            if(i + 1 == list.size())
                break;
            if (list.get(i) > list.get(i+1)){
                return false;
            }
        }
        return true;
    }

    public void isValidBST1(TreeNode root){
        if (root == null) {
            return;
        }
        isValidBST1(root.left);
        list.add(root.val);
        isValidBST1(root.right);
    }


    //根据中序遍历（左中右），（二叉树搜索树  中序遍历递增序列）
    TreeNode max;
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        // 左
        boolean left = isValidBST(root.left);
        if (!left) {
            return false;
        }
        // 中
        if (max != null && root.val <= max.val) {
            return false;
        }
        max = root;
        // 右
        boolean right = isValidBST(root.right);
        return right;
    }

}
