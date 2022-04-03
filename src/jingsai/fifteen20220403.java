package jingsai;

import java.util.Scanner;

/**
 *date：2022-04-03
 *
 * message ：6033. 转换数字的最少位翻转次数
 *
 * work : 一次 位翻转 定义为将数字 x 二进制中的一个位进行 翻转 操作，即将 0 变成 1 ，
 * 或者将 1 变成 0 。
 *
 * 比方说，x = 7 ，二进制表示为 111 ，我们可以选择任意一个位（包含没有显示的前导 0 ）并进行翻转。
 * 比方说我们可以翻转最右边一位得到 110 ，或者翻转右边起第二位得到 101 ，或者翻转右边起第五位（这一位是前导 0 ）
 * 得到 10111 等等。
 * 给你两个整数 start 和 goal ，请你返回将 start 转变成 goal 的 最少位翻转 次数。
 *
 */
public class fifteen20220403 {
    public static void main(String[] args) {}

    static public int minBitFlips(int start, int goal) {
        int sum = 0;
        while(start > 0 || goal > 0){
            int x1 = start % 2;
            int y1 = goal % 2;
            if(x1 != y1)
                sum++;
            start /= 2;
            goal /= 2;
        }
        return sum;
    }
}
