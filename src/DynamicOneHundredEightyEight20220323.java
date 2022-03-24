import java.util.LinkedList;
import java.util.Scanner;

/**
 *date：2022-03-24
 *
 * message :  474. 一和零
 *
 * work ： 给你一个二进制字符串数组 strs 和两个整数 m 和 n 。
 *
 * 请你找出并返回 strs 的最大子集的长度，该子集中 最多 有 m 个 0 和 n 个 1 。
 *
 * 如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集 。
 *
 *
 */
public class DynamicOneHundredEightyEight20220323 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int n = scanner.nextInt();
            String[] nums = new String[n];
            for (int i = 0;i < n;i++)
                nums[i] = scanner.next();
            int m = scanner.nextInt();
            int k = scanner.nextInt();
            int result = findMaxForm2(nums,m,k);
            System.out.println(result);
        }

    }



    //采用回溯暴力搜索，超出时间限制
    static int[] num = new int[2];
    static LinkedList<String> path = new LinkedList<>();
    static int maxLength = 0;
    static public int findMaxForm(String[] strs, int m, int n) {
        backIng(strs,m,n,0,0,0);
        return maxLength;
    }

    static public void backIng(String[] strs, int m, int n,int start,int zero,int one){
        if (maxLength == strs.length)
            return;
        if (start > strs.length)
            return;
        maxLength = Math.max(maxLength,path.size());
        for (int i = start;i < strs.length;i++){
           num = getNum(strs[i]);
           if ((zero + num[0] <= m) && (one + num[1] <= n)){
               path.add(strs[i]);
               backIng(strs,m,n,i + 1,zero + num[0],one + num[1]);
               path.removeLast();
           }
        }
    }




    /**
     * 采用一维数组的模式，有两个维度 因此设置成二维数组，但是一维数组的遍历方式，倒序遍历
     // 2.1 确定dp数组（dp table）以及下标的含义 : i:代表最多0的个数  j代表最多1的个数
                                                dp[i][j] : 最多有i个0和j个1的子集的最大长度为dp[i][j]
     //  2.2 确定递推公式 : dp[i][j] = max(dp[i][j],dp[i - zeroNum][j - oneNum] + 1);
     //  2.3 dp数组如何初始化dp[0][0] = 0
     //  2.4 确定遍历顺序：先遍历物品，再遍历背包
     */
    static int[] nums = new int[2];
    static public int findMaxForm2(String[] strs, int m, int n){
        int[][] dp = new int[m + 1][n + 1];
        for (int k = 0;k < strs.length;k++){
            //获取字符串的0和1 的个数 nums[0] : 代表 0 的个数，nums[1] : 代表 1 的个数
            nums = getNum(strs[k]);
            //倒序遍历
            for (int i = m;i >= nums[0];i--)
                for (int j = n;j >= nums[1];j--){
                    dp[i][j] = Math.max(dp[i][j],dp[i - nums[0]][j - nums[1]] + 1);
                }
        }
        return dp[m][n];
    }
    //获得字符串中0 1 的个数
    static public int[] getNum(String str){
        int[] result = new int[2];
        int x = 0;
        int y = 0;
        for (int i = 0;i < str.length();i++){
            switch (str.charAt(i)){
                case '0' : x++;
                    break;
                case '1' : y++;
                    break;
            }
        }
        result[0] = x;
        result[1] = y;
        return result;
    }
}
