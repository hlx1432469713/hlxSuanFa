package taxXin;

import java.util.Arrays;

/**
 *date：2022-03-18
 *
 * message ：976. 三角形的最大周长
 *
 * work : 给定由一些正数（代表长度）组成的数组 nums ，返回 由其中三个长度组成的、面积不为零的三角形的最大周长 。
 *      如果不能形成任何面积不为零的三角形，返回 0。
 *
 *
 *

 */
public class tanXinOneHundredSeventyNine20220318 {
    public static void main(String[] args){

    }

    static public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        for(int i = nums.length -1;i >1;i--){
            int x1 = nums[i];
            int x2 = nums[i - 1];
            int x3 = nums[i - 2];
            if(x2 + x3 > x1)
                return x1 + x2 + x3;
        }
        return 0;
    }
}
