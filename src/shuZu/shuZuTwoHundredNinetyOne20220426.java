package shuZu;

import java.util.Scanner;

/**
 *date：2022-04-26
 *
 * message :剑指 Offer 14- II. 剪绳子 II
 *
 * work :给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m段（m、n都是整数，n>1并且m>1），
 * 每段绳子的长度记为 k[0],k[1]...k[m - 1] 。请问 k[0]*k[1]*...*k[m - 1] 可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *

 *
 */
public class shuZuTwoHundredNinetyOne20220426 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            int n = scanner.nextInt();
            int result  = cuttingRope(n);
            System.out.println(result);
        }
    }
    //由于数据量过大，所以需要进行取模操作，因此动态规划方法就不能做
    //贪心思想：尽可能多的剪长度为 3 的绳子 ，直到最后长度 < 4 ，直接跳出循环，乘以剩下长度即可（4 可分为 2 * 2 == 4 == 4)
    static public int cuttingRope(int n) {
        if(n == 2) return 1;
        if(n == 3) return 2;
        long sum = 1;
        while(n > 4){
            sum *= 3;
            sum %= 1000000007;//直接进行取模操作，防止相乘后超出时间限制
            n -= 3;
        }
        return (int)(sum * n %1000000007);//最后相乘可能会超出限制，因此在进行一次取模操作
    }
}
