package TreeNode;

/**
 *date：2021-12-16
 *
 * message : 将有序数组转换为二叉搜索树
 * word :给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
 *
 * 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
 *
 *
 *
 *
 */
public class TreeNodeSeventyThree20211216 {
    public static void main(String[] args){}

    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST2(nums,0,nums.length-1);
    }

    public TreeNode sortedArrayToBST2(int[] nums,int left,int right){
        if (right < left)
            return null;
        int mid = (left + right)/2;
        //int mid = left +((right - left)>>1);
        TreeNode treeNode = new TreeNode(nums[mid]);
        treeNode.left = sortedArrayToBST2(nums,left,mid - 1);
        treeNode.right = sortedArrayToBST2(nums,mid+1,right);
        return treeNode;

    }
}
