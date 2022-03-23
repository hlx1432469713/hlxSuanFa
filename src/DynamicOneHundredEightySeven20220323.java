import java.util.Scanner;

/**
 *date：2022-03-23
 *
 * message :  1049. 最后一块石头的重量 II
 *
 * work ： 有一堆石头，用整数数组stones 表示。其中stones[i] 表示第 i 块石头的重量。
 *
 * 每一回合，从中选出任意两块石头，然后将它们一起粉碎。假设石头的重量分别为x 和y，且x <= y。那么粉碎的可能结果如下：
 *
 * 如果x == y，那么两块石头都会被完全粉碎；
 * 如果x != y，那么重量为x的石头将会完全粉碎，而重量为y的石头新重量为y-x。
 * 最后，最多只会剩下一块 石头。返回此石头 最小的可能重量 。如果没有石头剩下，就返回 0。
 *
 */
public class DynamicOneHundredEightySeven20220323 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int n = scanner.nextInt();
            int[] nums = new int[n];
            for (int i = 0;i < n;i++)
                nums[i] = scanner.nextInt();
            int result = lastStoneWeightII(nums);
            System.out.println(result);
        }

    }


    /**
     * 采用一维数组（石块的重量 == 石块的价值）
     * dp[j] : 容量为j的背包，所背石块的最大重量为dp[j]
     * 思想：如果想要剩下的石块重量最小，那必定是两个石块重量最接近最好，所以首先计算出整个石头堆的总重量，然后将其进行平均分成两个堆
     *      堆即相当于背包，堆的重量相当于背包的重量
     *      这样问题就转换成，当背包最大容量确定时，往背包里面放石头所产生的最大价值是多少（即最大的重量是多少）
     *      例如 整个石头堆的重量是31，那背包重量就是15，但是按照所给的石头放置背包内，重量最大只有14（若再放一个石头总重量就超过16），
     *      那这样另一个堆就是31 -14 =17，
     *      那这样两个堆进行相互比较粉碎，最后会剩下 17 -14 = 3 的石块
     * @param stones
     * @return
     */
    static  public int lastStoneWeightII(int[] stones) {
       if (stones.length == 1)
           return stones[0];
        int sum = 0;//总重量
        for (int i : stones) {
            sum += i;
        }
        int target = sum >> 1;//(sum / 2)
        int[] dp = new int[target + 1];
       for (int i = 0;i < stones.length;i++){
           for (int j =target;j >= stones[i];j--){
               dp[j] = Math.max(dp[j],dp[j - stones[i]] + stones[i]);
           }
       }
       return sum - dp[target] -dp[target];
    }

}
