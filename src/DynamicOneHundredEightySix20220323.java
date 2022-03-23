import java.util.Scanner;

/**
 *date：2022-03-23
 *
 * message :  416. 分割等和子集
 *
 * work ： 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 *
 */
public class DynamicOneHundredEightySix20220323 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int n = scanner.nextInt();
            int[] nums = new int[n];
            for (int i = 0;i < n;i++)
                nums[i] = scanner.nextInt();
            boolean result = canPartition2(nums);
            System.out.println(result);
        }

    }

    //01背包问题（二维解法）
    //背包重量为sum / 2（由于物品的价值和重量是一样，所以背包的最大价值跟背包的重量一致）  每个物品重量是nums[i],价值也是nums[i]（重量跟价值一致）
    //dp[i][j] 表示从下标为[0-i]的物品里任意取，放进容量为j的背包，价值总和最大是多少。
    //推导公式： dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
    //   初始化：dp[i][0] = 0（背包容量为0）
    //// 正序遍历
    //for (int j = nums[0]; j <= sum / 2; j++) {
    //    dp[0][j] = nums[0];
    //}
    //   遍历顺序：先遍历物品在遍历背包
    static  public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        //数组和不是双数，不能分割
        if (sum % 2 != 0)
            return false;
        int target = sum /2;
        int m =nums.length;
        int n = target + 1;
        int[][] dp = new int[m][n];
        if (nums[0] == target)
            return true;
        //初始化
        for (int j = nums[0];j < n;j++){
            dp[0][j] = nums[0];
        }
        for (int i = 1;i < m;i++){
            for (int j = 1;j < n;j++){
                if (nums[i] > j)
                    dp[i][j] = dp[i -1][j];
                else
                    dp[i][j] = Math.max(dp[i -1][j],dp[i - 1][j - nums[i]] + nums[i]);
            }
        }
        return dp[m - 1][n - 1] == target;
    }

    /**
     * 采用一维数组
     * dp[j] : 容量为j的背包，所背物品最大价值为dp[j]
     * @param nums
     * @return
     */
    static  public boolean canPartition2(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        //数组和不是双数，不能分割
        if (sum % 2 != 0)
            return false;
        int target = sum /2;

        if (nums[0] == target)
            return true;
        int[] dp = new int[target + 1];

        //每次背包的重量都从最大背包重量 至物品的重量 因为背包的重量如果小于物品的重量，则无法存储该物品（倒序遍历）
        for (int i = 0;i < nums.length;i++){
            for (int j = target;j >= nums[i];j--){
                    dp[j] = Math.max(dp[j],dp[j - nums[i]] + nums[i]);
            }
        }
        return dp[target] == target;
    }
}
