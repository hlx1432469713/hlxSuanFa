package jingsai;

import java.util.*;

/**
 *date：2022-03-06
 *
 * message : 6018. 根据描述创建二叉树
 *
 * work : 给你一个二维整数数组 descriptions ，其中 descriptions[i] = [parenti, childi, isLefti]
 * 表示 parenti 是 childi 在 二叉树 中的 父节点，二叉树中各节点的值 互不相同 。此外：
 *
 * 如果 isLefti == 1 ，那么 childi 就是 parenti 的左子节点。
 * 如果 isLefti == 0 ，那么 childi 就是 parenti 的右子节点。
 * 请你根据 descriptions 的描述来构造二叉树并返回其 根节点 。
 *
 * 测试用例会保证可以构造出 有效 的二叉树。 的单元格，并以列表形式返回。单元格应该按前面描述的格式用 字符串 表示，
 *
 * 输入：descriptions = [[20,15,1],[20,17,0],[50,20,1],[50,80,0],[80,19,1]]
 * 输出：[50,20,80,15,17,19]
 * 解释：根节点是值为 50 的节点，因为它没有父节点。
 * 结果二叉树如上图所示。
 *
 */
public class four20220306 {
    public static void main(String args[]){
    }
    //首先我们寻找所有节点 ，
    static  public TreeNode createBinaryTree(int[][] descriptions) {
        //用来存储所有节点
        Map<Integer ,TreeNode> map = new HashMap<>();
        //用来存储 除 根节点以外的所有节点----即是为了寻找根节点
        HashSet<Integer> hashSet = new HashSet<>();
        for (int[] description : descriptions) {
            if (!map.containsKey(description[0]))
                map.put(description[0],new TreeNode(description[0]));
            if (!map.containsKey(description[1]))
                map.put(description[1],new TreeNode(description[1]));
            if (description[2] == 1){
                map.get(description[0]).left = map.get(description[1]);
            }else{
                map.get(description[0]).right = map.get(description[1]);
            }
            //第二个元素为子节点，所以他不会是树的根节点
            hashSet.add(description[1]);
        }
        //根节点一定在description[0]中出现
        for (int[] description : descriptions) {
            //如果有个节点没有在hashSet中出现过，那一定是根节点
            if (!hashSet.contains(description[0]))
                return map.get(description[0]);
        }
        return null;
    }
}
