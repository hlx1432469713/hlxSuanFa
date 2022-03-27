package shuZu;

import java.util.Scanner;

/**
 *date：2022-01-05
 *
 * message ：青蛙跳台阶问题
 *
 * work:一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 */

public class shuZuSeventyFour20220105 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int n = scanner.nextInt();
            int result = numWays(n);
            System.out.println(result);

        }

    }
    static public int numWays(int n) {
        if( n== 1 || n == 0 ) return 1;
        if( n== 2 ) return 2;
        int tmp = 1;
        int sum = 2;
        for(int i = 3;i <= n;i++){
            int flag = tmp;
            tmp = sum;
            sum =(sum + flag)% 1000000007;//防止大数越界问题
        }
        return sum;

    }
}
