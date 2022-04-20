package Dynamic;

import java.util.Arrays;

/**
 *date：2022-04-20
 *
 * message :764. 最大加号标志
 *
 * work :在一个 n x n 的矩阵grid中，除了在数组mines中给出的元素为0，其他每个元素都为1。mines[i] = [xi, yi]表示grid[xi][yi] == 0
 *
 * 返回 grid 中包含1的最大的 轴对齐 加号标志的阶数 。如果未找到加号标志，则返回 0 。
 *
 * 一个k阶由1组成的 “轴对称”加号标志 具有中心网格grid[r][c] == 1，
 * 以及4个从中心向上、向下、向左、向右延伸，长度为k-1，由1组成的臂。
 * 注意，只有加号标志的所有网格要求为 1 ，别的网格可能为 0 也可能为 1 。
 *
 */
public class DynamicTwoHundredSeventy20220420 {
    public static void main(String[] args){}
    /**
     // 2.1 确定dp数组（dp table）以及下标的含义 :dp[i][j][0,1,2,3]:以i,j为中心，其向左，向上，向右，向下的连续 1 的个数为dp[i][j][0,1,2,3]
     //  2.2 确定递推公式：dp[i][j][0] = dp[i][j - 1][0] + 1
                        dp[i][j][1] = dp[i - 1][j][1] + 1
     //  2.3 dp数组如何初始化
     //  2.4 确定遍历顺序：后序遍历
     */
    static public int orderOfLargestPlusSign(int n, int[][] mines) {
        int[][] list = new int[n][n];
        int ans = 0;
        for (int i = 0;i < n;i++)
            Arrays.fill(list[i],1);
        for(int j = 0;j < mines.length;j++){
            list[mines[j][0]][mines[j][1]] = 0;
        }
        int[][][] dp = new int[n + 2][n + 2][4];
        for(int i = 1;i <= n;i++){
            for (int j = 1;j <= n;j++) {
                if (list[i - 1][j - 1] == 1) {
                    dp[i][j][0] = dp[i][j - 1][0] + 1;
                    dp[i][j][1] = dp[i - 1][j][1] + 1;
                }
            }
        }
        for(int i = n;i >= 1;i--){
            for (int j = n;j >= 1;j--) {
                if (list[i - 1][j - 1] == 1) {
                    dp[i][j][2] = dp[i][j + 1][2] + 1;
                    dp[i][j][3] = dp[i + 1][j][3] + 1;
                }
            }
        }
        for(int i = 0;i < n;i++){
            for (int j = 0;j < n;j++) {
                if (list[i][j] == 1) {
                    ans = Math.max(ans,Math.min(Math.min(dp[i + 1][j  + 1][0],dp[i + 1][j  + 1][1]),
                            Math.min(dp[i + 1][j  + 1][2],dp[i + 1][j  + 1][3])));
                }
            }
        }
        return ans;
    }


    //采用递归的方法，分别求出以（i，j）为中心的左右上下的最短臂长，即为阶数
    static public int orderOfLargestPlusSign2(int n, int[][] mines) {
            int[][] list = new int[n][n];
            for (int i = 0;i < n;i++)
                Arrays.fill(list[i],1);
            for(int j = 0;j < mines.length;j++){
                list[mines[j][0]][mines[j][1]] = 0;
            }
            int max = 0;
            for (int i = 0;i < n;i++){
                for (int j = 0;j < n;j++){
                    if (list[i][j] == 1)
                        max = Math.max(max,getLength(list,i,j) + 1);
                }
            }
            return max;
    }
   static public int getLength(int[][] nums,int row,int col){
        int n = nums.length;
        int left = 0;
        for(int j = col - 1;j>=0;j--){
            if(nums[row][j] == 0)
                break;
            left++;
        }
        int right = 0;
        for(int j = col + 1;j < n;j++){
            if(nums[row][j] == 0)
                break;
            right++;
        }
        int up = 0;
        for(int i = row - 1;i >=0;i--){
            if (nums[i][col] == 0)
                break;
            up++;
        }
        int down = 0;
        for(int i = row + 1;i < n;i++){
            if (nums[i][col] == 0)
                break;
            down++;
        }
        return Math.min(Math.min(left,right),Math.min(up,down));

    }
}
