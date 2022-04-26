package shuZu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *date：2022-04-25
 *
 * message :398. 随机数索引
 *
 * work :给你一个可能含有 重复元素 的整数数组nums ，请你随机输出给定的目标数字target 的索引。你可以假设给定的数字一定存在于数组中。
 *
 * 实现 Solution 类：
 *
 * Solution(int[] nums) 用数组 nums 初始化对象。
 * int pick(int target) 从 nums 中选出一个满足 nums[i] == target 的随机索引 i 。
 * 如果存在多个有效的索引，则每个索引的返回概率应当相等。
 */
public class shuZuTwoHundredEightySeven20220425 {
    public static void main(String[] args){}
    static Map<Integer, List<Integer>> map = new HashMap<>();
    public void Solution(int[] nums) {
        for(int i = 0;i < nums.length;i++){
            List<Integer> list = new ArrayList<>();
            if (map.containsKey(nums[i])){
                list = map.get(nums[i]);
            }
            list.add(i);
            map.put(nums[i],list);
        }
    }

    public int pick(int target) {
        int sum = map.get(target).size();
        int num = (int)(Math.random() * (sum   -0) + 0 );
        return map.get(target).get(num);
    }

    //蓄水池抽样
    int[] num ;
    public void Solution2(int[] nums) {
        num = nums;
    }

    public int pick2(int target) {
        int sum = 0;
        int ans = 0;
       for(int i = 0;i < num.length;i++){
           if(num[i] == target){
               sum++;
               if((int)(Math.random() * sum) == 0)
                   ans = i;
           }
       }
       return ans;
    }

}
