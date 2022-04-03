package jingsai;

import java.util.*;

/**
 *date：2022-04-03
 *
 * message ：5219. 每个小孩最多能分到多少糖果
 *
 * work : 给你一个 下标从 0 开始 的整数数组 candies 。数组中的每个元素表示大小为 candies[i] 的一堆糖果。
 * 你可以将每堆糖果分成任意数量的 子堆 ，但 无法 再将两堆合并到一起。
 *
 * 另给你一个整数 k 。你需要将这些糖果分配给 k 个小孩，使每个小孩分到 相同 数量的糖果。每个小孩可以拿走 至多一堆 糖果，
 * 有些糖果可能会不被分配。
 *
 * 返回每个小孩可以拿走的 最大糖果数目 。
 *

 */
public class twenty20220403 {
    public static void main(String[] args) {}

    static   public int maximumCandies(int[] candies, long k) {
        long sum = 0;
        for (int i = 0; i < candies.length; i++) {
            sum += candies[i];
        }
        if (sum < k)
            return 0;
        long right = sum / k;
        long left = 1;
        long result = 0;
        while (left <= right) {
            long mid = left + ((right - left) / 2);
            long cnt = 0;
            for (int x : candies) {
                cnt += x / mid;
            }
            if (cnt >= k) {
                left = mid + 1;
                result = Math.max(mid, result);
            } else {
                right = mid - 1;
            }
        }
        return (int) result;
    }
}