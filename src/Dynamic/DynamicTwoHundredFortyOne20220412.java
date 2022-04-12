package Dynamic;

import java.util.Arrays;

/**
 *date：2022-04-12
 *
 * message :718. 最长重复子数组
 *
 * work :给两个整数数组 nums1 和 nums2 ，返回 两个数组中 公共的 、长度最长的子数组的长度 。
 *

 *
 *
 *
 *
 */
public class DynamicTwoHundredFortyOne20220412 {
    public static void main(String[] args){}

    /**
     // 2.1 确定dp数组（dp table）以及下标的含义 :dp[i][j] ：当数组A长度为i，数组B长度为j时，最长重复子数组长度为dp[i][j]。
     //  2.2 确定递推公式 :
     //  2.3 dp数组如何初始化
     //  2.4 确定遍历顺序：后序遍历
     */
    static public int findLength(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int[][] dp = new int[n1 + 1][n2 + 1];
        int result = 0;
        for (int i = 1;i <= n1;i++){
            for (int j = 1;j <= n2;j++){
                if(nums1[i - 1] == nums2[j - 1]){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    result = Math.max(result,dp[i][j]);
                }
            }
        }
        return result;

    }

    //暴力求解
    static public int findLength2(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int maxLength = 0;
        for (int i = 0;i < n1;i++){
            int left = i;
            int right = 0;
            int index = 0;
            int flag = 0;
            if (maxLength >= n1 - i)
                return maxLength;
            while(right < n2 && left < n1 && flag < n2){
                if (nums2[right] == nums1[left]){
                    if (index == 0)
                        flag = right;
                    index++;
                    maxLength = Math.max(maxLength,index);
                    left++;
                }else{
                    if (index > 0)
                        right = flag;
                    index = 0;
                    left = i;
                }
                right++;
            }
        }
        return maxLength;
    }
}
