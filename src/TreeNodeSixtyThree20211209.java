/**
 *date：2021-12-09
 *
 * message : 最小高度树
 * work : 给定一个有序整数数组，元素各不相同且按升序排列，编写一个算法，创建一棵高度最小的二叉搜索树。
 *
 * 示例:
 * 给定有序数组: [-10,-3,0,5,9],
 *
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 *           0
 *          / \
 *        -3   9
 *        /   /
 *      -10  5
 */
public class TreeNodeSixtyThree20211209 {
    public static void main(String[] args){}

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0)
            return null;
        return sortedArrayToBST2(nums,0,nums.length - 1);

    }
    public TreeNode sortedArrayToBST2(int[]nums,int left,int right){
        if (right < left)
            return null;
        int mid = (left + right)/2;
        TreeNode treeNode = new TreeNode(nums[mid]);
        treeNode.left = sortedArrayToBST2(nums,left,mid-1);
        treeNode.right = sortedArrayToBST2(nums,mid+1,right);
        return treeNode;
    }
}
