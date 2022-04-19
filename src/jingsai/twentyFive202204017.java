package jingsai;

import java.util.HashMap;
import java.util.Map;

/**
 *date：2022-04-17
 *
 * message ：2244. 完成所有任务需要的最少轮数
 *
 * work : 给你一个下标从 0 开始的整数数组 tasks ，其中 tasks[i] 表示任务的难度级别。在每一轮中，
 * 你可以完成 2 个或者 3 个 相同难度级别 的任务。
 *
 * 返回完成所有任务需要的 最少 轮数，如果无法完成所有任务，返回 -1 。
 *
 *
 */
public class twentyFive202204017 {
    public static void main(String[] args) {}

    static public int minimumRounds(int[] tasks) {
        if(tasks.length == 1)
            return -1;
        Map<Integer,Integer> map = new HashMap<>();
        int sum = 0;
        for(int i = 0;i < tasks.length;i++){
            map.put(tasks[i],map.getOrDefault(tasks[i],0)+1);
        }
        for (Integer key : map.keySet()) {
            int num = map.get(key);
            if(num == 1)
                return -1;
            else{
                sum+= num / 3;
                if(num % 3 != 0){
                    sum++;
                }
            }
        }
        return sum;
    }
}