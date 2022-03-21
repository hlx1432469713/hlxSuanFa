package jingsai;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 *date：2022-03-13
 *
 * message : 6032. 得到要求路径的最小带权子图
 *
 * work : 给你一个整数n，它表示一个 带权有向 图的节点数，节点编号为0 到n - 1。
 *
 * 同时给你一个二维整数数组edges，其中edges[i] = [fromi, toi, weighti]，
 * 表示从fromi到toi有一条边权为weighti的 有向 边。
 *
 * 最后，给你三个 互不相同的整数src1，src2和dest，表示图中三个不同的点。
 *
 * 请你从图中选出一个 边权和最小的子图，使得从 src1和 src2出发，在这个子图中，
 * 都 可以到达 dest。如果这样的子图不存在，请返回 -1。
 *
 * 子图中的点和边都应该属于原图的一部分。子图的边权和定义为它所包含的所有边的权值之和。
 *



 *
 */
public class eight20220313 {
    public static void main(String[] args) {

    }

    static  public long minimumWeight(int n, int[][] edges, int src1, int src2, int dest) {
        //正向（每个节点对应的边集合）
        List<long[]>[] t = new ArrayList[n];
        //反向（每个节点对应的边集合）
        List<long[]>[] d = new ArrayList[n];
        for (int i = 0;i < n;i++) {
            t[i] = new ArrayList<>();
            d[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            //构造正向
            t[edge[0]].add(new long[]{edge[1],edge[2]});
            //构造反向
            d[edge[1]].add(new long[]{edge[0],edge[2]});
        }

        //src1到每一个的最短距离
        long[] cost1 = new long[n];
        //src2到每一个的最短距离
        long[] cost2 = new long[n];
        //dest到每一个的最短距离(反向图，从dest开始)
        long[] costd = new long[n];

        Arrays.fill(cost1,-1);
        Arrays.fill(cost2,-1);
        Arrays.fill(costd,-1);


        dij(src1,t,cost1);
        dij(src2,t,cost2);
        //如果从src1或者src2 无法到达dest ，则直接返回-1
        if (cost1[dest] == -1 || cost2[dest] == -1)
            return -1;

        dij(dest,d,costd);
        long sum = Long.MAX_VALUE;
        for (int i = 0; i < n;i++){
            if (cost1[i] == -1 || cost2[i] == -1 || costd[i] == -1)
                continue;
            sum =Math.min(sum ,cost1[i] + cost2[i] + costd[i]);
        }
        return sum;
    }

    static void dij(int s,List<long[]>[] t,long[] cost){
        PriorityQueue<long[]> p = new PriorityQueue<>((x,y)->(int)(x[1] - y[1]));
        p.add(new long[]{s,0});
        while(!p.isEmpty()){
            long[] tmp = p.poll();
            int node = (int) tmp[0];
            long c = tmp[1];
            if (cost[node] != -1)
                continue;
            cost[node] = c;
            for (long[] aLong : t[node]) {
                if (cost[(int)aLong[0]] != -1)
                    continue;
                p.add(new long[]{aLong[0],c + aLong[1]});
            }
        }
    }
}
