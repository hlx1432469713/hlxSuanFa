package TreeNode;

/**
 *date：2021-11-24
 *
 * message ： 完全二叉树的节点个数
 *
 * work:给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。
 *
 * 完全二叉树 的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，
 * 并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~2^h个节点。
 *
 */
public class TreeNodeThirtySeven2021125 {
    public static void main(String[] args){}

    //第一种 ---  遍历整棵树
    int sum = 0;
    public int countNodes(TreeNode root) {
        countNodeSum(root,0);
        return sum;
    }
    public void countNodeSum(TreeNode root,int deep){
        if (root == null)
            return;
        deep++;

        sum++;
        countNodeSum(root.left,deep);
        countNodeSum(root.right,deep);
    }

    //第二种方法
    //求完全二叉树的   右子树   的  最左节点  所在的高度（深度）w
     //如果 w == h  节点个数 == 2^(h - 1) + 右子树的节点个数
     //如果 w == h - l -1   节点个数 == 2^(h - l -1) + 左子树的节点个数

    public int countNodes2(TreeNode root) {
        if (root == null)
            return 0;
        return bs(root,1,treeDeep(root,1));
    }

    public int bs(TreeNode node,int j,int h){
        if(j == h)
            return 1;
        if(treeDeep(node.right,j+1) == h){
            return (1<<(h-1)) + bs(node.right,j,h-1);
        }else{
            return (1<<(h-j-1)) + bs(node.left,j,h-1);
        }
    }

    //根据输入节点所在层数，求其  子二叉树   的深度
    public int treeDeep(TreeNode node , int j){
        while(node != null){
            j++;
            node = node.left;
        }
        return j - 1;
    }

    /**
     * 针对完全二叉树的解法(第三种解法)
     *
     * 满二叉树的结点数为：2^depth - 1
     */
    public int countNodes3(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);
        if (leftDepth == rightDepth) {// 左子树是满二叉树
            // 2^leftDepth其实是 （2^leftDepth - 1） + 1 ，左子树 + 根结点
            return (1 << leftDepth) + countNodes(root.right);
        } else {// 右子树是满二叉树
            return (1 << rightDepth) + countNodes(root.left);
        }
    }

    private int getDepth(TreeNode root) {
        int depth = 0;
        while (root != null) {
            root = root.left;
            depth++;
        }
        return depth;
    }
}
