import jdk.internal.org.objectweb.asm.Handle;

import java.util.HashMap;
import java.util.Map;

/**
 *date：2022-02-18
 *
 * message : 找出星型图的中心节点
 *
 * work : 有一个无向的 星型 图，由 n 个编号从 1 到 n 的节点组成。星型图有一个 中心 节点，
 * 并且恰有 n - 1 条边将中心节点与其他每个节点连接起来。
 *
 * 给你一个二维整数数组 edges ，其中edges[i] = [ui, vi] 表示在节点 ui 和 vi 之间存在一条边。
 * 请你找出并返回edges 所表示星型图的中心节点。
 */
public class tuOneHundredTwentyTwo20220218 {
    public static void main(String[] args){

    }
    static  public int findCenter(int[][] edges) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int[] index : edges){
            for (int x : index){
                map.put(x,map.getOrDefault(x,0) + 1);
                if (map.get(x) > 1)
                    return x;
            }
        }
        return 0;
    }
    static  public int findCenter2(int[][] edges) {
       if (edges[0][0] == edges[1][0] || edges[0][0] == edges[1][1]){
           return edges[0][0];
       }else {
           return edges[0][1];
       }
    }
}
