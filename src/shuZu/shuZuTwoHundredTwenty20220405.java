package shuZu;

import java.util.HashSet;
import java.util.Set;

/**
 *date：2022-04-05
 *
 * message :  762. 二进制表示中质数个计算置位
 *
 * work :给你两个整数left和right ，在闭区间 [left, right]范围内，统计并返回 计算置位位数为质数 的整数个数。
 *
 * 计算置位位数 就是二进制表示中 1 的个数。
 *
 * 例如， 21的二进制表示10101有 3 个计算置位。
 *
 */
public class shuZuTwoHundredTwenty20220405 {
    public static void main(String args[]){}

    //  2 ^ 19 <10 ^ 6 < 2 ^20
    static public int countPrimeSetBits(int left, int right) {
        int[] list = {2,3,5,7,11,13,17,19};
        Set<Integer> set = new HashSet<>();
        int n = 0,sum = 0,ans = 0;
        for (int i = 0;i < list.length;i++)
            set.add(list[i]);
        for (int i = left;i <= right;i++){
            n = i;
            sum = 0;
            while(n > 0){
//                if (n % 2 == 1)
//                    sum++;
//                n /= 2;
                n = (n-1) & n;//用 & 运算速度会变快
                sum++;
            }
            if (set.contains(sum))
                ans++;
        }
        return ans;
    }
}
