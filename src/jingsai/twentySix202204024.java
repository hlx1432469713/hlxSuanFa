package jingsai;

import java.util.*;

/**
 *date：2248. 多个数组求交集
 *
 * message ：2244. 完成所有任务需要的最少轮数
 *
 * work : 给你一个二维整数数组 nums ，其中 nums[i] 是由 不同 正整数组成的一个非空数组，
 * 按 升序排列 返回一个数组，数组中的每个元素在 nums所有数组 中都出现过。
 *
 *
 *
 */
public class twentySix202204024 {
    public static void main(String[] args) {}

    static public List<Integer> intersection(int[][] nums) {
        List<Integer> list = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        int n = nums.length;
        for(int i = 0;i < n;i++){
            for(int j = 0;j < nums[i].length;j++){
                map.put(nums[i][j],map.getOrDefault(nums[i][j],0) + 1);
                if(map.get(nums[i][j]) == n)
                    list.add(nums[i][j]);
            }
        }
        Collections.sort(list);
        return list;

    }
}