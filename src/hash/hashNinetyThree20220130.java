package hash;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *date：2022-01-30
 *
 * message :  快乐数
 *
 * work : 编写一个算法来判断一个数 n 是不是快乐数。
 * 「快乐数」定义为：
 * 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
 * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
 * 如果这个过程 结果为1，那么这个数就是快乐数。
 * 如果 n 是 快乐数 就返回 true ；不是，则返回 false 。
 *
 */
public class hashNinetyThree20220130 {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int n = scanner.nextInt();
            boolean flag = isHappy(n);
            System.out.println(flag);
        }


    }

    static public boolean isHappy(int n) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(n,1);
        while (true){
            int sum = 0;
            String str = String.valueOf(n);
            char[] s = str.toCharArray();
            for(char c : s){
                sum += (c - '0') * (c - '0');
            }
            if (sum == 1)
               return true;
            if (map.get(sum) != null)
               return false;
            map.put(sum,1);
            n = sum;
        }
    }
}
