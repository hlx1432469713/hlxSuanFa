package shuZu;

import java.util.*;

/**
 *date：2022-04-06
 *
 * message : 496. 下一个更大元素 I
 *
 * work : nums1中数字x的 下一个更大元素 是指x在nums2 中对应位置 右侧 的 第一个 比x大的元素。
 *
 * 给你两个 没有重复元素 的数组nums1 和nums2 ，下标从 0 开始计数，其中nums1是nums2的子集。
 *
 * 对于每个 0 <= i < nums1.length ，找出满足 nums1[i] == nums2[j] 的下标 j ，
 * 并且在 nums2 确定 nums2[j] 的 下一个更大元素 。如果不存在下一个更大元素，那么本次查询的答案是 -1 。
 *
 * 返回一个长度为nums1.length 的数组 ans 作为答案，满足 ans[i] 是如上所述的 下一个更大元素 。
 *
 *
 */
public class shuZuTwoHundredTwentySeven20220406 {
    public static void main(String[] args){}
    static public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int[] result = new int[n1];
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i < n1;i++)
            map.put(nums1[i],i);
        //将数组每个元素初始化为-1
        Arrays.fill(result,-1);
        Stack<Integer> stack = new Stack<>();
        for(int i = 0;i < n2;i++){
            while(!stack.isEmpty() && nums2[i] > nums1[stack.peek()] ){
                int y = stack.pop();
                result[y] = nums2[i];
            }
            if(map.containsKey(nums2[i])){
                stack.push(map.get(nums2[i]));
            }
        }
        return result;
    }
}
