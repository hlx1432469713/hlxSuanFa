import java.util.Arrays;
import java.util.Scanner;

/**
 *date：2022-03-10
 *
 * message ：435. 无重叠区间
 * work :给定一个区间的集合intervals，其中 intervals[i] = [starti, endi]。返回 需要移除区间的最小数量，使剩余区间互不重叠。

 *
 *
 */
public class tanXinOneHundredFiftySeven20220310 {
    public static void main(String[] args){
    }



    //先将每个区间终点 由小到大排序，如果相同，则按区间开始，由小到大排序
    //最后计算每一个起点 是否在记录的范围之内，如果是，则更新sum. 否则更新right为此区间的终点
    static  public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->{
            if(a[1] == b[1])
                return a[0] - b[0];
            return a[1] - b[1];
        });
        int right = intervals[0][1];
        int sum = 0;
       for (int i = 1;i < intervals.length;i++){
           int[] interval = intervals[i];
           if (interval[0] < right){
               sum++;
           }else{
               right = interval[1];
           }
       }
       return sum;
    }
}
