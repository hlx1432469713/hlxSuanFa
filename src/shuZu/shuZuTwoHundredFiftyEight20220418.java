package shuZu;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 *date：2022-04-18
 *
 * message :215. 数组中的第K个最大元素
 *
 * work :给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 *
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 *
 */
public class shuZuTwoHundredFiftyEight20220418 {
    public static void main(String[] args){}
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> p = new PriorityQueue<>();
        for(int i = 0;i < k;i++){
            p.add(nums[i]);
        }
        for(int i = k;i < nums.length;i++){
            if(nums[i] > p.peek()){
                p.poll();
                p.add(nums[i]);
            }
        }
        return p.poll();
    }
    public int findKthLargest2(int[] nums, int k) {
        int[] list = new int[20001];
        for(int i = 0;i < nums.length;i++){
            list[nums[i] + 10000]++;
        }
        for(int i = 20000;i>=0;i--){
            if(list[i]!=0){
                k = k - list[i];
            }
            if(k <= 0)
                return i - 10000;
        }
        return 0;
    }
}
