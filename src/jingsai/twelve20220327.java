package jingsai;

import java.util.*;

/**
 *date：2022-03-27
 *
 * message :5268. 找出两数组的不同（简单）
 *
 * work : 给你两个下标从 0 开始的整数数组 nums1 和 nums2 ，请你返回一个长度为 2 的列表 answer ，其中：
 *
 * answer[0] 是 nums1 中所有 不 存在于 nums2 中的 不同 整数组成的列表。
 * answer[1] 是 nums2 中所有 不 存在于 nums1 中的 不同 整数组成的列表。
 * 注意：列表中的整数可以按 任意 顺序返回。
 *
 */
public class twelve20220327 {
    public static void main(String[] args) {}

    /** 分组dp
     * 对每个栈取前缀和sum,则前缀和数组种的第j个元素被视作 体积为j，价值为sum[j] 的物品
     // 2.1 确定dp数组（dp table）以及下标的含义 : dp[i][j]:代表从前i个栈中取体积为j的物品，物品价值最大值为dp[i][j]
     //  2.2 确定递推公式  dp[i][j] = Math.max(dp[i][j],dp[i - 1])
     //  2.3 dp数组如何初始化  dp[0] = 1
     //  2.4 确定遍历顺序：先遍历物品，再遍历背包容量    (每个物品的数量是无限的)完全背包问题：
     内层背包容量循环：正序遍历
     */
    static  public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> result = new ArrayList<>();
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set1.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            set2.add(nums2[i]);
            if (set1.contains(nums2[i])){
                set1.remove(nums2[i]);
            }
        }
        for (int i = 0; i < nums1.length; i++) {
            if (set2.contains(nums1[i])) {
                set2.remove(nums1[i]);
            }
        }
        result.add(new ArrayList<>(set1));
        result.add(new ArrayList<>(set2));
        return result;
    }
}
