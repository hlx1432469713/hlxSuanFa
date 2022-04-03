package jingsai;

import java.util.*;

/**
 *date：2022-04-03
 *
 * message ：5235. 找出输掉零场或一场比赛的玩家
 *
 * work : 给你一个整数数组 matches 其中 matches[i] = [winneri, loseri] 表示在一场比赛中 winneri 击败了 loseri 。
 *
 * 返回一个长度为 2 的列表 answer ：
 *
 * answer[0] 是所有 没有 输掉任何比赛的玩家列表。
 * answer[1] 是所有恰好输掉 一场 比赛的玩家列表。
 * 两个列表中的值都应该按 递增 顺序返回。
 *
 * 注意：
 *
 * 只考虑那些参与 至少一场 比赛的玩家。
 * 生成的测试用例保证 不存在 两场比赛结果 相同 。
 */
public class nineteen20220403 {
    public static void main(String[] args) {}

    static public List<List<Integer>> findWinners(int[][] matches) {
        List<List<Integer>> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0;i < matches.length;i++){
            int[] matche = matches[i];
            if(!map.containsKey(matche[0])){
                map.put(matche[0],0);
            }
            map.put(matche[1],map.getOrDefault(matche[1],0) + 1);
        }
        List<Integer> list0 = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        for (Integer key : map.keySet()) {
            if(map.get(key) == 0)
                list0.add(key);
            else if(map.get(key) == 1)
                list1.add(key);
        }
        Collections.sort(list0);
        Collections.sort(list1);
        list.add(list0);
        list.add(list1);
        return list;
    }
}