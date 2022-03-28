package shuZu;

import java.util.Scanner;
import java.util.Stack;

/**
 *date：2022-03-28
 *
 * message :693. 交替位二进制数
 *
 * work : 给定一个正整数，检查它的二进制表示是否总是 0、1 交替出现：换句话说，就是二进制表示中相邻两位的数字永不相同
 *
 */
public class shuZuOneHundredNintySix20220328 {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n =scanner.nextInt();
            boolean result = hasAlternatingBits(n);
            System.out.println(result);
        }
    }

    static public boolean hasAlternatingBits(int n) {
        int flag = -1;
        while(n > 0){
            int x = n % 2;
            if(flag == x)
                return false;
            flag = x;
            n = n /2;
        }
        return true;
    }
}
