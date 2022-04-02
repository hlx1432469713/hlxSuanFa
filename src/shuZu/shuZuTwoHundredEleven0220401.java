package shuZu;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *date：2022-03-31
 *
 * message : 面试题 17.18. 最短超串
 *
 * work :假设你有两个数组，一个长一个短，短的元素均不相同。找到长数组中包含短数组所有的元素的最短子数组，
 * 其出现顺序无关紧要。
 *
 * 返回最短子数组的左端点和右端点，如有多个满足条件的子数组，返回左端点最小的一个。若不存在，返回空数组。
 *
 * 输入:
 * big = [7,5,9,0,2,1,3,5,7,9,1,1,5,8,8,9,7]
 * small = [1,5,9]
 * 输出: [7,10]
 *
 */
public class shuZuTwoHundredEleven0220401 {
    public static void main(String args[]){}


    static public int[] shortestSeq(int[] big, int[] small) {
        if (small.length > big.length)
            return  new int[0];
        int index = 0;//滑动窗口标志
        int left = 0;//最左边界
        int right = 0;
        int minLen = Integer.MAX_VALUE;//所求数组最短长度
        int[] list = new int[2];
        Map<Integer,Integer> map = new HashMap<>();//用来记录small中各个数字情况
        for(int i = 0;i < small.length;i++)
            map.put(small[i],1);
        //首先将滑动窗口填满
        for (int i = 0;i < big.length && index < small.length;i++){
            if (map.containsKey(big[i])){
                if(map.get(big[i]) == 1)
                    index++;
                map.put(big[i],map.get(big[i]) - 1);
            }
            minLen = i + 1;//初始最短长度
            right = i;
        }
        if(index != small.length)
            return  new int[0];
        list[1] = right;
        while(left <= right && right < big.length){
            if (minLen > (right - left + 1)){
                minLen = right - left + 1 ;
                list[0] = left;
                list[1] = right;
            }
            if (minLen == small.length)
                return list;
            if (map.containsKey(big[left])) {
                if (map.get(big[left]) >= 0) {
                    right++;
                    while (right < big.length) {
                        if (map.containsKey(big[right])){
                            map.put(big[right], map.get(big[right]) - 1);
                        }
                        if (big[right] == big[left]){
                            break;
                        }
                        right++;
                    }
                }
                map.put(big[left], map.get(big[left]) + 1);
            }
            left++;
        }
        return list;
    }
}
