package shuZu;

import java.util.Arrays;

/**
 *date：2022-04-12
 *
 * message :204. 计数质数
 *
 * work :给定整数 n ，返回 所有小于非负整数 n 的质数的数量 。
 */
public class shuZuTwoHundredFortyFive20220412 {
    public static void main(String[] args){}
    static  public int countPrimes(int n) {
        if(n == 0 || n == 1 || n== 2)
            return 0;
        boolean[] flag = new boolean[n + 1];
        Arrays.fill(flag,2,n + 1,true);
        int sum = 0;
        for(int i = 2;i <= (int)Math.sqrt(n);i++){
            if(flag[i]){
                for(int j = i;i*j < n;j++)
                    flag[i*j] = false;
            }
        }
        for(int i = 2;i < n;i++)
            if(flag[i])
                sum++;
        return sum;
    }
}
