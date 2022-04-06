import java.util.*;

/**
 *date：2022-04-06
 *
 * message : 310. 最小高度树
 *
 * work : 树是一个无向图，其中任何两个顶点只通过一条路径连接。 换句话说，一个任何没有简单环路的连通图都是一棵树。
 *
 * 给你一棵包含n个节点的树，标记为0到n - 1 。
 * 给定数字n和一个有 n - 1 条无向边的 edges列表（每一个边都是一对标签），
 * 其中 edges[i] = [ai, bi] 表示树中节点 ai 和 bi 之间存在一条无向边。
 *
 * 可选择树中任何一个节点作为根。当选择节点 x 作为根节点时，设结果树的高度为 h 。
 * 在所有可能的树中，具有最小高度的树（即，min(h)）被称为 最小高度树 。
 *
 * 请你找到所有的 最小高度树 并按 任意顺序 返回它们的根节点标签列表。
 *
 * 树的 高度 是指根节点和叶子节点之间最长向下路径上边的数量。
 *
 */
public class tuTwoHundredTwentySix20220406 {
    public static void main(String[] args){}
    static  public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> list = new ArrayList<>();
        if(n == 1){
            list.add(0);
            return list;
        }
        //节点的出度数组
        int[] degree = new int[n];
        //节点的图结构
        List<List<Integer>> map = new ArrayList<>();
        for(int i = 0;i < n;i++)
            map.add(new ArrayList<>());
        for(int[] d : edges){
            //计算每个节点的出度
            degree[d[0]]++;
            degree[d[1]]++;
            map.get(d[0]).add(d[1]);
            map.get(d[1]).add(d[0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0;i < degree.length;i++){
            //当节点从出度为1，可以作为叶子节点
            if(degree[i] == 1)
                queue.add(i);
        }
        while(!queue.isEmpty()){
            //每一轮更新list，直到 队列为空，最后的结果即为最小高度树的根节点标签列表
            list = new ArrayList<>();
            int size = queue.size();
            for(int i = 0;i < size;i++){
                int x = queue.poll();
                //每一轮，将叶子节点放入list中
                list.add(x);
                List<Integer> result = map.get(x);
                for(int j = 0;j < result.size();j++){
                    degree[result.get(j)]--;
                    if(degree[result.get(j)] == 1)
                        queue.add(result.get(j));
                }
            }
        }
        return list;
    }
}
