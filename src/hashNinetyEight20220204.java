import java.util.*;

/**
 *date：2022-02-04
 *
 * message :  四数相加 II
 *
 * work : 给你四个整数数组 nums1、nums2、nums3 和 nums4 ，数组长度都是 n ，
 * 请你计算有多少个元组 (i, j, k, l) 能满足：
 *
 * 0 <= i, j, k, l < n
 * nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0
 *

 */
public class hashNinetyEight20220204 {
    public static void main(String args[]){


    }


    //o(n^3) 超出时间限制
    static public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer,Integer> map = new HashMap<>();
        int index = 0;
        for (int i = 0;i < nums4.length;i++)
           map.put(nums4[i],map.getOrDefault(nums4[i],0) + 1);
        for(int i = 0;i < nums1.length;i++){
            for(int j = 0;j < nums2.length;j++){
                for(int k = 0;k < nums3.length;k++){
                    int flag = 0 - nums1[i] - nums2[j] - nums3[k];
                    if (map.containsKey(flag))
                        index += map.get(flag).intValue();
                }
            }
        }
        return index;
    }

    //将nums1和nums2进行累加合并 存入map数组中  ---分组+哈希表  o(n^2);
    static public int fourSumCount2(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
     //首先将nums1和nums2进行累加合并 存入map数组中
        Map<Integer,Integer> map = new HashMap<>();
        int index  = 0;
        for(int i :nums1)
            for (int j : nums2)
                map.put(i + j,map.getOrDefault(i + j,0) + 1);
       for (int i = 0;i < nums3.length;i++){
           for (int j = 0;j < nums4.length;j++){
               int flag = 0 - nums3[i] - nums4[j];
               if (map.containsKey(flag))
                   index += map.get(flag).intValue();
           }
       }
       return index;
    }
}
