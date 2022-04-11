package jingsai;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 *date：2022-04-10
 *
 * message ：2233. K 次增加后的最大乘积
 *
 * work : 给你一个非负整数数组nums和一个整数k。每次操作，
 * 你可以选择nums中 任一元素并将它 增加1。
 *
 * 请你返回 至多k次操作后，能得到的nums的最大乘积。
 * 由于答案可能很大，请你将答案对109 + 7取余后返回。
 */
public class twentyThree202204010 {
    public static void main(String[] args) {}

    static public int maximumProduct(int[] nums, int k) {
        Queue<Integer> priorityQueue = new PriorityQueue();
        for(int x : nums){
            priorityQueue.add(x);
        }
        while(k > 0){
            k--;
            priorityQueue.add(priorityQueue.poll() + 1);
        }
        long result = 1L;
        for(int y : priorityQueue){
            result = (result * y)%1000000007;
        }
        return (int)(result);
    }
}