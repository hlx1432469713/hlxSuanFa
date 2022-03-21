package jingsai;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *date：2022-03-13
 *
 * message : 6031. 找出数组中的所有 K 近邻下标
 *
 * work : 给你一个下标从 0 开始的整数数组 nums 和两个整数 key 和 k 。K 近邻下标 是 nums 中的一个下标 i ，
 * 并满足至少存在一个下标 j 使得 |i - j| <= k 且 nums[j] == key 。
 *
 * 以列表形式返回按 递增顺序 排序的所有 K 近邻下标。

 *
 */
public class six20220313 {
    public static void main(String[] args) {

    }

    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> list = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        int max = 0;
        for(int i = 0;i < nums.length;i++){
            if(nums[i] == key){
                min = Math.min(min,i);
                max =Math.max(max,i);
            }
        }
        int left = min - k;
        int right = max + k;
        for(int i = (left < 0?0:left);i <= (right>nums.length - 1?nums.length - 1:right);i++){
            list.add(i);
        }
        return list;
    }
}
