import javax.xml.soap.Node;
import java.util.*;

/**
 *date：2022-03-11
 *
 * message : 2049. 统计最高分的节点数目
 *
 * work :给你一棵根节点为 0 的二叉树，它总共有 n个节点，节点编号为0到n - 1。同时给你一个下标从0开始的整数数组parents表示这棵树，
 * 其中parents[i]是节点 i的父节点。由于节点 0是根，所以parents[0] == -1。
 *
 * 一个子树的 大小为这个子树内节点的数目。每个节点都有一个与之关联的分数。求出某个节点分数的方法是，
 * 将这个节点和与它相连的边全部 删除，剩余部分是若干个 非空子树，这个节点的 分数为所有这些子树 大小的乘积。
 *
 * 请你返回有 最高得分节点的 数目。
 *
 *
 *

 */
public class TreeNodeOneHundredSixtyOne20220311 {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()){
            int n = scanner.nextInt();
            int[] parents = new int[n];
            for (int i = 0;i < n;i++)
                parents[i] = scanner.nextInt();
            int result = countHighestScoreNodes(parents);
            System.out.println(result);
        }

    }
    static long max = 0;
    static int nums = 0;
    //先将数组转换成二叉树，然后通过后序遍历  遍历整棵树
    static public int countHighestScoreNodes(int[] parents) {
        Map<Integer,TreeNode> map = new HashMap<>();
        map.put(0,new TreeNode(0));
        for (int i = 1;i < parents.length;i++){
            if (!map.containsKey(i)){
                map.put(i,new TreeNode(i));
            }
            if (!map.containsKey(parents[i])){
                map.put(parents[i],new TreeNode(parents[i]));
            }
            if (map.get(parents[i]).left == null)
                map.get(parents[i]).left = map.get(i);
            else
                map.get(parents[i]).right =  map.get(i);
        }
        TreeNode root = map.get(0);
        backing(root,parents.length);
        return nums;
    }
    //分别计算 该节点的左子树和右子树的节点数量，然后再由总节点数 - 左子树节点数 - 右子树节点数 - 1 = 剩余的节点数
    //该节点的分数 = 左节点数
    static public long  backing(TreeNode treeNode,int num){
        if (treeNode == null)
            return 0;
        long left = backing(treeNode.left,num);
        long right = backing(treeNode.right,num);
        long surplusSum = num - left - right - 1;
        long all = (left == 0?1:left) * (right == 0 ? 1 : right) * (surplusSum == 0 ?1: surplusSum);
        if (all > max){
            max = all;
            nums = 1;
        }else if (all == max)
            nums++;
        return left + right + 1;
    }
}
