package shuZu;

import java.util.*;

/**
 *date：2022-05-07
 *
 * message :332. 重新安排行程
 *
 * work :给你一份航线列表 tickets ，其中 tickets[i] = [fromi, toi] 表示飞机出发和降落的机场地点。
 * 请你对该行程进行重新规划排序。
 *
 * 所有这些机票都属于一个从 JFK（肯尼迪国际机场）出发的先生，所以该行程必须从 JFK 开始。
 * 如果存在多种有效的行程，请你按字典排序返回最小的行程组合。
 *
 * 例如，行程 ["JFK", "LGA"] 与 ["JFK", "LGB"] 相比就更小，排序更靠前。
 * 假定所有机票至少存在一种合理的行程。且所有的机票 必须都用一次 且 只能用一次。
 *
 */
public class shuZuThreeHundredTwentyTwo20220507 {

    /**
     * 首先要选取TreeMap用作升序排序
     * 然后要记录。每个机场可以 飞到的机场集合以及它们的次数（可能存在多个 相同出发和相同落地的组合）
     * 所以最后选择的集合是Map<String,Map<String,Integer>>
     *                      机场       落地的机场，次数
     * 接着开始回溯，直到全部使用了机票 ，直接跳出回溯，（因为所有机场顺序都是已经经过TreeMap进行升序排列）
     * 最后返回行程即可。
     * @param args
     */
    public static void main(String[] args){}
    Map<String,Map<String,Integer>> map;
    LinkedList<String> path = new LinkedList<>();
    public List<String> findItinerary(List<List<String>> tickets) {
        map = new TreeMap<>();
        for(int i = 0;i < tickets.size();i++){
            Map<String,Integer> h = new TreeMap<>();//用于进行升序排列
            if(map.containsKey(tickets.get(i).get(0))){
                h = map.get((tickets.get(i).get(0)));
            }
            h.put(tickets.get(i).get(1),h.getOrDefault(tickets.get(i).get(1),0) + 1);
            map.put(tickets.get(i).get(0),h);
        }
        path.add("JFK");
        backing(map.get("JFK"),tickets.size());
        return new ArrayList<>(path);
    }

    public boolean backing(Map<String,Integer> s ,int sum){
        if(sum <= 0){
            return true;
        }
        if(s == null)
            return false;
        for(String key : s.keySet()){
            if(s.get(key) == 0)
                continue;
            path.add(key);
            s.put(key,s.get(key) - 1);
            boolean flag = backing(map.get(key),sum -1);
            if(flag)
                return true;
            s.put(key,s.get(key) + 1);
            path.removeLast();
        }
        return false;
    }
}
