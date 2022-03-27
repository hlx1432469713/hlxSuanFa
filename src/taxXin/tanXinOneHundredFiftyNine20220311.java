package taxXin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *date：2022-03-11
 *
 * message ：56. 合并区间
 * work :以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 * 请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 *
 */
public class tanXinOneHundredFiftyNine20220311 {
    public static void main(String[] args){}


    //首先按照右边界进行从大到小进行排序，如果相等 则按照左边界从小到大排序
    static public int[][] merge(int[][] intervals) {
        if (intervals.length == 1)
            return intervals;
        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals,(a,b)->{
            if (a[1] == b[1])
                return a[0] - b[0];
            return b[1] - a[1];
        });
        int left = intervals[0][0];
        int right = intervals[0][1];
        for (int i = 1;i < intervals.length;i++){
            int[] interval = intervals[i];
            //上一个区间的左边届  大于 此区间的右边界，说明上一个区间跟此区间没有重叠区域
            //因此直接将上个区间放进结果数组中
            if (left > interval[1]){
                list.add(new int[]{left, right});
                left = interval[0];
                right = interval[1];
            }else{
                //代表存在重叠区间，此时合并后的区间范围：左边界最小的，右边界最大的
                left = Math.min(left,interval[0]);
                right = Math.max(right,interval[1]);
            }
        }
        list.add(new int[]{left, right});
        return list.toArray(new int[list.size()][]);
    }
}
