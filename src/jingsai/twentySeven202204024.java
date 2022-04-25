package jingsai;

import java.util.*;

/**
 *date：2250. 统计包含每个点的矩形数目
 *
 * message ：2244. 完成所有任务需要的最少轮数
 *
 * work : 给你一个二维整数数组rectangles，其中rectangles[i] = [li, hi]表示第i个矩形长为li高为hi。
 * 给你一个二维整数数组points，其中points[j] = [xj, yj]是坐标为(xj, yj)的一个点。
 *
 * 第i个矩形的 左下角在(0, 0)处，右上角在(li, hi)。
 *
 * 请你返回一个整数数组count，长度为points.length，其中count[j]是 包含 第j个点的矩形数目。
 *
 * 如果0 <= xj <= li 且0 <= yj <= hi，那么我们说第i个矩形包含第j个点。如果一个点刚好在矩形的 边上，这个点也被视为被矩形包含。

 *
 */
public class twentySeven202204024 {
    public static void main(String[] args) {}

      //哈希表 + 排序
    static public int[] countRectangles(int[][] rectangles, int[][] points) {
        Map<Integer,List<Integer>>map = new HashMap<>();
        int n = points.length;
        int[] result = new int[n];
        for(int i = 0;i < rectangles.length;i++){
            int l = rectangles[i][0];
            int h = rectangles[i][1];
            List<Integer> list = new ArrayList<>();
            if(map.containsKey(h)){
                list = map.get(h);
            }
            list.add(l);
            map.put(h,list);
        }
        for(Integer x : map.keySet()){
            List<Integer> s = map.get(x);
            Collections.sort(s);//这里排序主要用于进行二分查找
            map.put(x,s);
        }
        for(int i = 0;i < n;i++){
            int x = points[i][0];
            int y = points[i][1];
            int cout = 0;
            for(Integer num : map.keySet()){
                if(num >= y){
                    cout += getNum(map.get(num),x);
                }
            }
            result[i] = cout;
        }
        return result;
    }
    //二分查找
    static public int getNum(List<Integer> list ,int x){
        int left = 0,right = list.size() - 1;
        while(left < right){
            int mid = left + (right - left) / 2;
            if(list.get(mid) >= x){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return list.get(right) >= x? list.size() - right:0;
    }

}