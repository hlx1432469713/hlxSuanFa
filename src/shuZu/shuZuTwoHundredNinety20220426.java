package shuZu;

import java.util.Scanner;

/**
 *date：2022-04-26
 *
 * message :剑指 Offer 15. 二进制中1的个数
 *
 * work :编写一个函数，输入是一个无符号整数（以二进制串的形式），返回其二进制表达式中数字位数为 '1' 的个数（也被称为 汉明重量).）。
 *
 * 提示：
 *
 * 请注意，在某些语言（如 Java）中，没有无符号整数类型。在这种情况下，输入和输出都将被指定为有符号整数类型，并且不应影响您的实现，
 * 因为无论整数是有符号的还是无符号的，其内部的二进制表示形式都是相同的。
 * 在 Java 中，编译器使用 二进制补码 记法来表示有符号整数。因此，在上面的示例 3中，输入表示有符号整数 -3。
 *
 */
public class shuZuTwoHundredNinety20220426 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            int n = scanner.nextInt();
            int result  = hammingWeight(n);
            System.out.println(result);
        }
    }


       // you need to treat n as an unsigned value
    //使用Java十进制转二进制字符串API
    static public int hammingWeight(int n) {
        String s = Integer.toBinaryString(n);
        int sum = 0;
        for(int i = 0;i < s.length();i++){
            if (s.charAt(i) == '1')
                sum++;
        }
        return sum;
    }

    /**
     * 根据 与运算 定义，设二进制数字 nn ，则有：
     * 若 n & 1 = 0 ，则 n 二进制 最右一位 为 0 ；
     * 若 n & 1 = 1 ，则 n 二进制 最右一位 为 1 。
     *
     * >>:带符号右移。正数右移高位补0，负数右移高位补1。比如: 4>> 1，结果是2; -4>> 1，结果是-2。-2>> 1,结果是-1。
     * >>>:无符号右移。无论是正数还是负数，高位通通补0。
     * @param n
     * @return
     */
    static public int hammingWeight2(int n) {
        int sum = 0;
        while(n != 0){
            sum += n & 1;
            n = n >>> 1;
        }
        return sum;
    }
}
