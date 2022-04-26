package shuZu;

import TreeNode.TreeNode;

import java.util.Scanner;

/**
 *date：2022-04-26
 *
 * message :剑指 Offer 16. 数值的整数次方
 *
 * work :实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。不得使用库函数，同时不需要考虑大数问题。
 */
public class shuZuTwoHundredEightyNine20220426 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            double x = scanner.nextDouble();
            int n = scanner.nextInt();
            double result  = myPow3(x,n);
            System.out.println(result);
        }
    }

    //for循环暴力解决--超出时间限制
    static public double myPow2(double x, int n) {
        int m = Math.abs(n);
        double sum = 1;
        for(int i = 1; i <= m;i++){
            sum *= x;
        }
        if(n < 0)
            sum = 1 / sum;
        return sum;
    }

    /**
     * 若 b 为奇数，则 a^b = a × a^(b − 1)
     * 若 b 为偶数，则 a^b = a^(b/2) * a^(b/2)
     */
    //递归
    static public double myPow(double x, int n) {
        if(n < 0)
            x = (double)(1.0 / x);
        long m = n;//要将 n 先转换成 long 类型 防止在取绝对值的时候溢出
        double result = getPow(x,Math.abs(m));
        return result;
    }
    static public double getPow(double x, long n){
        if(n == 0)
            return 1.0;
        if(n % 2 == 1)
            return x * getPow(x,n - 1);
        else{
            double num = getPow(x , n / 2);
            return num * num;
        }
    }
    //迭代
    static public double myPow3(double x, int n) {
        long m = n;
        if(n < 0) {
            x = 1.0 / x;
            m = -m;
        }
        double sum = 1.0;
       while(m > 0){
           if(m % 2 == 1)
               sum *= x;
           x *= x;
           m = m >> 1;
       }
       return sum;
    }

}
