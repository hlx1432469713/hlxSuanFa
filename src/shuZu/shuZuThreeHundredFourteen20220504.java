package shuZu;

import java.util.HashMap;
import java.util.Map;

/**
 *date：2022-05-04
 *
 * message :560. 和为 K 的子数组
 *
 * work :给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
 *
 */
public class shuZuThreeHundredFourteen20220504 {
    public static void main(String[] args){}
    public int subarraySum(int[] nums, int k) {
        int all = 0;
        int sum = 0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for(int i = 0;i < nums.length;i++){
            sum += nums[i];
            if(map.containsKey(sum - k)){
                all += map.get(sum - k);
            }
            map.put(sum,map.getOrDefault(sum,0) + 1);
        }
        return all;
    }
}
