package jingsai;

import java.util.Arrays;

/**
 *date：2022-04-10
 *
 * message ：2231. 按奇偶性交换后的最大数字
 *
 * work : 给你一个正整数 num 。你可以交换 num 中 奇偶性 相同的任意两位数字
 * （即，都是奇数或者偶数）。
 *
 * 返回交换 任意 次之后 num 的 最大 可能值。
 *

 */
public class twentyOne202204010 {
    public static void main(String[] args) {}

    static public int largestInteger(int num) {
        if(num < 10)
            return num;
        String s = String.valueOf(num);
        int[] x = new int[s.length()];
        int[] y = new int[s.length()];
        boolean[] flag = new boolean[s.length()];
        for(int i = 0;i< s.length();i++){
            int m = s.charAt(i) - '0';
            if(m % 2 == 0){
                y[i] = m;
                flag[i] = true;
            }else{
                x[i] = m;
            }
        }
        Arrays.sort(x);
        Arrays.sort(y);
        int a = x.length - 1;
        int b = y.length - 1;
        StringBuilder s1 = new StringBuilder();
        for(int i = 0;i <flag.length;i++){
            if(flag[i] == true){
                s1.append(y[b]);
                b--;
            }else{
                s1.append(x[a]);
                a--;
            }
        }
        return Integer.valueOf(s1.toString());
    }
}