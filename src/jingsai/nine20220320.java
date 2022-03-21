package jingsai;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 *date：2022-03-20
 *
 * message :6027. 统计数组中峰和谷的数量
 *
 * work : 给你一个下标从 0 开始的整数数组 nums 。如果两侧距 i 最近的不相等邻居的值均小于 nums[i] ，
 * 则下标 i 是 nums 中，某个峰的一部分。类似地，如果两侧距 i 最近的不相等邻居的值均大于 nums[i] ，
 * 则下标 i 是 nums 中某个谷的一部分。对于相邻下标 i 和 j ，如果 nums[i] == nums[j] ，
 * 则认为这两下标属于 同一个 峰或谷。
 *
 * 注意，要使某个下标所做峰或谷的一部分，那么它左右两侧必须 都 存在不相等邻居。
 *
 * 返回 nums 中峰和谷的数量。
 */
public class nine20220320 {
    public static void main(String[] args) {
    }

    static  public int countHillValley(int[] nums) {
        //记录此次差值
        int cur = 0;
        //记录前一次差值
        int pre = 0;
        int sum = 0;
        for(int i = 1;i < nums.length;i++){
            cur = nums[i] - nums[i - 1];
            //符合峰或者谷的定义
            if((cur < 0 && pre >= 0) || (cur > 0 && pre <= 0)){
                sum++;
                pre = cur;
            }
        }
        //最后需要去除多算进去的首节点
        return sum - 1 < 0? 0 : sum - 1;
    }
}
