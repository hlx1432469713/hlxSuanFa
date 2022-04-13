package Dynamic;

/**
 *date：2022-04-13
 *
 * message : 1035. 不相交的线
 *
 * work :在两条独立的水平线上按给定的顺序写下 nums1 和 nums2 中的整数。
 *
 * 现在，可以绘制一些连接两个数字 nums1[i]和 nums2[j]的直线，这些直线需要同时满足满足：
 *
 * nums1[i] == nums2[j]
 * 且绘制的直线不与任何其他连线（非水平线）相交。
 * 请注意，连线即使在端点也不能相交：每个数字只能属于一条连线。
 *
 * 以这种方法绘制线条，并返回可以绘制的最大连线数。
 *
 */
public class DynamicTwoHundredFortySeven20220413 {
    public static void main(String[] args){}

    /**
     * 求最多不相交的线，即求两个数组的最长公共子序列的长度
     // 2.1 确定dp数组（dp table）以及下标的含义 :dp[i][j] ：当数组A长度为i，数组B长度为j时最大连线数为dp[i][j]。
     //  2.2 确定递推公式 :if (nums1[i - 1] == nums2[j - 1]){
     //                    dp[i][j] = dp[i - 1][j - 1] + 1;
     //                }else{
     //                    dp[i][j] = Math.max(dp[i - 1][j],dp[i][j - 1]);
     //                }
     //  2.3 dp数组如何初始化
     //  2.4 确定遍历顺序：后序遍历
     */
    static public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int[][] dp = new int[n1 + 1][n2 + 1];
        for (int i = 1;i <= n1;i++){
            for (int j = 1;j <= n2;j++){
                if (nums1[i - 1] == nums2[j - 1]){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else{
                    //当两个元素不相等时（说明两个元素不能相连接），要比较数组A长度为i-1，数组B长度为j 和 数组A长度为i，数组B长度j - 1时
                                                            //的最长公共子序列的长度
                    dp[i][j] = Math.max(dp[i - 1][j],dp[i][j - 1]);
                }
            }
        }
        return dp[n1][n2];
    }
}
