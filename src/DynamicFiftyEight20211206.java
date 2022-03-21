import java.util.Scanner;

/**
 *date：2021-12-06
 *
 * message :  斐波那契数
 *
 * work : 斐波那契数，通常用F(n) 表示，形成的序列称为 斐波那契数列 。该数列由0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 *
 * F(0) = 0，F(1)= 1
 * F(n) = F(n - 1) + F(n - 2)，其中 n > 1
 * 给你 n ，请计算 F(n) 。
 *
 */
public class DynamicFiftyEight20211206 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int n = scanner.nextInt();
            int x = fib(n);
            int y = fib2(n);
            System.out.println(x + "   " + y);
        }
    }

    //递归
    static  public int fib(int n) {
        if(n < 1) return 0;
        if(n == 1 || n ==2) return 1;
        return fib(n-1) + fib(n - 2);

    }

    //优化迭代（压缩空间状态）
    static  public int fib2(int n) {
        if(n < 1) return 0;
        if(n == 1 || n ==2) return 1;
        int pre = 1,cur = 1;
        int temp = 0;
        for(int i = 3;i <= n;i++){
            temp = cur;
            cur = pre + cur;
            pre = temp;
        }
        return cur;
    }

    //动态规划
    // 2.1 确定dp数组（dp table）以及下标的含义 : dp[i] : 代表 到第i项的和为dp[i]
    //  2.2 确定递推公式 : dp[i] = dp[i - 1] + dp[i -2]
    //  2.3 dp数组如何初始化dp[0] = 0,dp[1] = 1
    //  2.4 确定遍历顺序
    //  2.5 举例推导dp数组
    static int fib3(int n){
        if (n <= 1)
            return n;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i -2];
        }
        return dp[n];
    }

}
