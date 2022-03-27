package chars;

import java.util.Scanner;

/**
 *date：2022-03-03
 *
 * message ： 258. 各位相加
 *
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 *
 */
public class charOneHundredFortySeven20220303 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()){
            int numRows = scanner.nextInt();
            int result = addDigits(numRows);
            System.out.println(result);
        }
    }

    static public int addDigits(int num) {
        while(num >= 10){
            int x = num;
            int all = 0;
            while(x > 0){
                all += x % 10;
                x = x / 10;
            }
            num = all;
        }
        return num;
    }
}
