import java.util.ArrayList;
import java.util.List;

/**
 *date：2021-12-13
 *
 * message : 二叉搜索树中的众数
 * word : 给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
 *
 * 假定 BST 有如下定义：
 *
 * 结点左子树中所含结点的值小于等于当前结点的值
 * 结点右子树中所含结点的值大于等于当前结点的值
 * 左子树和右子树都是二叉搜索树

 *

 */
public class TreeNodeSixtySeven20211213 {
    public static void main(String[] args){}


    /**
     * 利用二叉搜索树的性质
     * 1.中序遍历二叉树
     * 2.比较当前节点（now）和上一个节点（pre）是否相同
     * 3.需要一个Map记录 频率最高的元素和频率
     * @param root
     * @return
     */
    List<Integer> list;
    TreeNode pre = null;
    int maxCount = 0;
    int count = 0;
    public int[] findMode(TreeNode root) {
        list = new ArrayList<>();
        findMode2(root);
        int[] result = new int[list.size()];
        for(int i = 0;i < list.size();i++)
            result[i] = list.get(i);
        return result;
    }
    public void findMode2(TreeNode root){
        if (root == null)
            return;
        findMode2(root.left);
        //当是第一个节点或者相邻两节点值不一样
        if (pre == null || pre.val != root.val){
            count = 1;
        }
        else{
            count++;
        }
        pre = root;
        if (count > maxCount){
            list.clear();//清空数组
            maxCount = count;
            list.add(root.val);
        }else if (count == maxCount){
            list.add(root.val);
        }
        findMode2(root.right);

    }



}
