package jingsai;

/**
 *date：2022-04-03
 *
 * message ：6034. 数组的三角和
 *
 * work : 给你一个下标从 0 开始的整数数组 nums ，其中 nums[i] 是 0 到 9 之间（两者都包含）的一个数字。
 *
 * nums 的 三角和 是执行以下操作以后最后剩下元素的值：
 *
 * nums 初始包含 n 个元素。如果 n == 1 ，终止 操作。
 * 否则，创建 一个新的下标从 0 开始的长度为 n - 1 的整数数组 newNums 。
 * 对于满足 0 <= i < n - 1 的下标 i ，
 * newNums[i] 赋值 为 (nums[i] + nums[i+1]) % 10 ，% 表示取余运算。
 * 将 newNums 替换 数组 nums 。
 * 从步骤 1 开始 重复 整个过程。
 * 请你返回 nums 的三角和。
 *
 */
public class sixteen20220403 {
    public static void main(String[] args) {}

    static  public int triangularSum(int[] nums) {
        if(nums.length == 1)
            return nums[0];
        int n = nums.length;
        for(int i = 0;i < nums.length;i++){
            for(int j = 0;j < n - 1;j++){
                nums[j] = (nums[j] + nums[j + 1]) % 10;
            }
            n -= 1;
        }
        return nums[0];
    }
}