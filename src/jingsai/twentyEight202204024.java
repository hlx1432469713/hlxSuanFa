package jingsai;

import java.util.*;

/**
 *date：2249. 统计圆内格点数目
 *
 * message ：2244. 完成所有任务需要的最少轮数
 *
 * work : 给你一个二维整数数组 circles ，其中 circles[i] = [xi, yi, ri]
 * 表示网格上圆心为 (xi, yi) 且半径为 ri 的第 i 个圆，返回出现在 至少一个 圆内的 格点数目 。
 *
 * 注意：
 *
 * 格点 是指整数坐标对应的点。
 * 圆周上的点 也被视为出现在圆内的点。
 */
public class twentyEight202204024 {
    public static void main(String[] args) {}
    static public int countLatticePoints(int[][] circles) {
            Set<String> list = new HashSet<>();
            for(int i = 0;i < circles.length;i++){
                int x = circles[i][0];
                int y = circles[i][1];
                int r = circles[i][2];
                for(int m = x - r;m <= x +r;m++){
                    for(int j = y - r;j <= y + r;j++){
                        if((m - x) * (m - x) + (y - j) *(y - j) <= r * r)
                            list.add(m + "#" + j);
                    }
                }
            }
            return list.size();
        }
}