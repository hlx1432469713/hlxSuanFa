package shuZu;


import java.util.TreeSet;

/**
 *date：2022-04-05
 *
 * message :剑指 Offer II 057. 值和下标之差都在给定的范围内
 *
 * work :给你一个整数数组 nums 和两个整数 k 和 t 。请你判断是否存在 两个不同下标 i 和 j，使得 abs(nums[i] - nums[j]) <= t ，
 * 同时又满足 abs(i - j) <= k 。
 * 如果存在则返回 true，不存在返回 false。
 *
 */
public class shuZuTwoHundredTwentySix20220405 {
    public static void main(String args[]){}
    static public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> treeSet = new TreeSet<>();
        for (int i = 0;i < nums.length;i++){
            long flag = (long)nums[i] - t;
            if (treeSet.ceiling(flag) != null){
                long x =  (long)nums[i] + t;
                long y = treeSet.ceiling(flag);
                if (y <= x )
                    return true;
            }
            treeSet.add((long)nums[i]);
            if (treeSet.size() == k  + 1)
                treeSet.remove((long)nums[i - k ]);
        }
        return false;

    }

}
