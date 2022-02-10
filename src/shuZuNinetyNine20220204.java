import java.util.HashMap;
import java.util.Map;

/**
 *date：2022-02-04
 *
 * message :  可以形成最大正方形的矩形数目
 *
 * work : 给你一个数组 rectangles ，其中 rectangles[i] = [li, wi] 表示第 i 个矩形的长度为 li 、宽度为 wi 。
 *
 * 如果存在 k 同时满足 k <= li 和 k <= wi ，就可以将第 i 个矩形切成边长为 k 的正方形。
 * 例如，矩形 [4,6] 可以切成边长最大为 4 的正方形。
 *
 * 设 maxLen 为可以从矩形数组rectangles 切分得到的 最大正方形 的边长。
 *
 * 请你统计有多少个矩形能够切出边长为 maxLen 的正方形，并返回矩形 数目 。
 *
 *
 */
public class shuZuNinetyNine20220204 {
    public static void main(String args[]){

    }
    static public int countGoodRectangles(int[][] rectangles) {
        int maxLen = 0;
        int maxLenCount = 0;
        for (int i = 0;i < rectangles.length;i++){
            int max = Math.max(rectangles[i][0],rectangles[i][1]);
            if (maxLen < max){
                maxLen = max;
                maxLenCount = 1;
            }else if (maxLen == max)
                maxLenCount++;
        }
        return maxLenCount;
    }
}
