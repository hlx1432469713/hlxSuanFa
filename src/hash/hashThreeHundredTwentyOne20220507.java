package hash;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 *date：2022-05-07
 *
 * message :1036. 逃离大迷宫
 *
 * work :在一个 106 x 106 的网格中，每个网格上方格的坐标为(x, y) 。
 *
 * 现在从源方格source = [sx, sy]开始出发，意图赶往目标方格target = [tx, ty] 。
 * 数组 blocked 是封锁的方格列表，
 * 其中每个 blocked[i] = [xi, yi] 表示坐标为 (xi, yi) 的方格是禁止通行的。
 *
 * 每次移动，都可以走到网格中在四个方向上相邻的方格，只要该方格 不 在给出的封锁列表blocked上。
 * 同时，不允许走出网格。
 *
 * 只有在可以通过一系列的移动从源方格source 到达目标方格target 时才返回true。否则，返回 false。
 *
 * 0 <= blocked.length <= 200.
 *
 */
public class hashThreeHundredTwentyOne20220507 {
    public static void main(String[] args){
        int[][] blocked = {{0,1},{1,0}};
        int[] source = {0,0};
        int[] target = {0,2};
        boolean result = isEscapePossible(blocked,source,target);
        System.out.println(result);
    }

    /**
     * 广搜 + 提前退出
     *
     * 1、从起点和终点同时广搜，每一轮搜到的点分别放入startQueue和endQueue，
     * 按广搜标准操作进行出队、入队以及是否block、是否命中目标等处理。
     *
     * 但题目数据大，第1步肯定会超时，所以第2步（提前退出）很重要。
     *
     * 2、在广搜过程中，当startQueue和endQueue中的都大于200时，就可以直接return true。
     * 因为此时200个block点已经包不住start和end往外扩展的路径了。
     */
    static  int[][] list = {{-1,0},{1,0},{0,-1},{0,1}};
    static public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        if (blocked.length == 0)
            return true;
        Set<String> set = new HashSet<>();
        for(int[] l : blocked){
            set.add(l[0] + "#" + l[1]);
        }
        Queue<int[]> start = new LinkedList<>();
        Queue<int[]> end = new LinkedList<>();
        start.add(source);
        end.add(target);
        set.add(source[0] + "s" + source[1]);//起点开始搜索到的点
        set.add(target[0] + "e" + target[1]);//终点开始搜索到的点
        while(!start.isEmpty() && !end.isEmpty()) {
            if (!start.isEmpty()) {
                if(search(start,set,"s","e"))
                    return true;
            }
            if (!end.isEmpty()) {
                if(search(end,set,"e","s"))
                    return true;
            }
            if(start.size() > 200 && end.size() > 200)
                return true;
        }
        return false;
    }
    static public boolean search(Queue<int[]> queue, Set<String> set,String c,String b){
        int[] s = queue.poll();
        int x = s[0], y = s[1];
        for (int[] l : list) {
            int nx = x + l[0];
            int ny = y + l[1];
            if (nx < 0 || ny < 0 || nx >= 1000000 || ny >= 1000000 ||
                    set.contains(nx + c + ny)|| set.contains(nx + "#" + ny)){
                continue;
            }
            if (set.contains(nx + b + ny))
                return true;
            queue.add(new int[]{nx, ny});
            set.add(nx + c + ny);
        }
        return false;
    }
}
