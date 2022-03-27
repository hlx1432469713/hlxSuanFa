package TreeNode;

/**
 *date：2021-12-02
 *
 * message : 最大二叉树II
 *
 * work: 最大树定义：一个树，其中每个节点的值都大于其子树中的任何其他值。
 *
 * 给出最大树的根节点 root。
 *
 * 就像之前的问题那样，给定的树是从列表A（root = Construct(A)）递归地使用下述Construct(A)例程构造的：
 *
 * 如果A为空，返回null
 * 否则，令A[i]作为 A 的最大元素。创建一个值为A[i]的根节点 root
 * root的左子树将被构建为Construct([A[0], A[1], ..., A[i-1]])
 * root的右子树将被构建为 Construct([A[i+1], A[i+2], ..., A[A.length - 1]])
 * 返回root
 * 请注意，我们没有直接给定A，只有一个根节点root = Construct(A).
 *
 * 假设 B 是 A 的副本，并在末尾附加值 val。题目数据保证 B中的值是不同的。
 *
 * 返回Construct(B)。
 *

 *
 *
 */
public class TreeNodeFiftyThree20211202 {
    public static void main(String[] args){}

    /**
     * (每次val值都是加在数组的最后面，如果是val是数组最大的，那就是val节点的左子树为root
     *                             val不是最大的，那val节点一定在root节点的右子树中
     *                             递归
     * @param root
     * @param val
     * @return0·
     */
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if(root == null || root.val < val){
            TreeNode treeNode = new TreeNode(val);
            treeNode.left = root;
            return treeNode;
        }
        root.right = insertIntoMaxTree(root.right,val);
        return root;
    }
}
