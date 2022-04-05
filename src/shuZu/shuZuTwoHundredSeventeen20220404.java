package shuZu;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *date：2022-04-04
 *
 * message :1001. 网格照明
 *
 * work : 在大小为 n x n 的网格 grid 上，每个单元格都有一盏灯，最初灯都处于 关闭 状态。
 *
 * 给你一个由灯的位置组成的二维数组lamps ，其中 lamps[i] = [rowi, coli]
 *
 * 表示 打开 位于 grid[rowi][coli] 的灯。即便同一盏灯可能在 lamps 中多次列出，不会影响这盏灯处于 打开 状态。
 *
 * 当一盏灯处于打开状态，它将会照亮 自身所在单元格 以及同一 行 、同一 列 和两条 对角线 上的 所有其他单元格 。
 *
 * 另给你一个二维数组 queries ，其中 queries[j] = [rowj, colj] 。对于第 j 个查询，
 *
 * 如果单元格 [rowj, colj] 是被照亮的，则查询结果为 1 ，否则为 0 。在第 j 次查询之后 [按照查询的顺序] ，
 *
 * 关闭 位于单元格 grid[rowj][colj] 上及相邻 8 个方向上（与单元格 grid[rowi][coli] 共享角或边）的任何灯。
 *
 * 返回一个整数数组 ans 作为答案， ans[j] 应等于第 j 次查询queries[j]的结果，1 表示照亮，0 表示未照亮。
 *。
 */
public class shuZuTwoHundredSeventeen20220404 {
    public static void main(String args[]){}
    static int[][] flag = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,0},{0,1},{1,0},{1,-1},{1,1}};
    //哈希表 + 线性映射
    public int[] gridIllumination(int n, int[][] lamps, int[][] queries){
        long N = n;
        Map<Integer ,Integer> row = new HashMap<>();
        Map<Integer ,Integer> col = new HashMap<>();
        Map<Integer ,Integer> left = new HashMap<>();
        Map<Integer ,Integer> right = new HashMap<>();
        //记录亮灯位置 --二维位置转一维位置 i= x*N+y
        Set<Long> set = new HashSet<>();
        for (int[] l : lamps){
            int x = l[0];
            int y = l[1];
            int a = x + y;
            int b = x - y;
            if (set.contains(x * N + y))
                continue;
            set.add(x * N + y);
            inCrement(row,x);
            inCrement(col,y);
            inCrement(left,a);
            inCrement(right,b);
        }
        int m = queries.length;
        int[] ans = new int[m];
        for (int i = 0;i < m;i++){
            int[] q = queries[i];
            int x = q[0];
            int y = q[1];
            int a = x + y;
            int b = x - y;
            if (row.containsKey(x) || col.containsKey(y)
                || left.containsKey(a) || right.containsKey(b))
                    ans[i] = 1;
            for (int[] d: flag){
                int nx = d[0] + x;
                int ny = d[1] + y;
                int na = nx + ny;
                int nb = nx - ny;
                if (nx < 0 || ny < 0 || nx >= n || ny >=n)
                    continue;
                //经过转换过的位置是开灯位置
                if (set.contains(nx *N + ny)){
                    set.remove(nx *N + ny);
                    delnCrement(row,nx);
                    delnCrement(col,ny);
                    delnCrement(left,na);
                    delnCrement(right,nb);
                }
            }
        }
        return ans;
    }
    static public void inCrement(Map<Integer,Integer> map,int key){
        map.put(key,map.getOrDefault(key,0) + 1);
    }
    static public void delnCrement(Map<Integer,Integer> map,int key){
        if (map.get(key) == 1)
            map.remove(key);
        else
            map.put(key,map.get(key) - 1);
    }
}
