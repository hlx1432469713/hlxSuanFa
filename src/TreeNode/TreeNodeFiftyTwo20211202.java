package TreeNode;

/**
 *date：2021-12-02
 *
 * message : 最大二叉树
 *
 * work: 给定一个不含重复元素的整数数组 nums 。一个以此数组直接递归构建的 最大二叉树 定义如下：
 *
 * 二叉树的根是数组 nums 中的最大元素。
 * 左子树是通过数组中 最大值左边部分 递归构造出的最大二叉树。
 * 右子树是通过数组中 最大值右边部分 递归构造出的最大二叉树。
 * 返回有给定数组 nums 构建的 最大二叉树 。
 *
 *
 */
public class TreeNodeFiftyTwo20211202 {
    public static void main(String[] args){}

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMaximumBinaryTree2(nums,0,nums.length - 1);

    }

    //左闭右闭
    public TreeNode constructMaximumBinaryTree2(int[] nums,int left,int right){
       if(right < left)
           return null;
       if(right == left)
           return new TreeNode(nums[right]);
        int max = 0;
        int flag = 0;
        for(int i = left;i <=right;i++) {
            if(max < nums[i]){
                max = nums[i];
                flag = i;
            }
        }
        TreeNode treeNode = new TreeNode(max);
        treeNode.left = constructMaximumBinaryTree2(nums,left,flag - 1);
        treeNode.right = constructMaximumBinaryTree2(nums,flag + 1,right);
        return treeNode;

    }
}
