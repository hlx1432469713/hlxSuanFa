package chars;

import java.util.Scanner;

/**
 *date：2022-03-01
 *
 * message ： 504. 七进制数
 *
 * work ：给定一个整数 num，将其转化为 7 进制，并以字符串形式输出。
 *
 */
public class charOneHundredFifty20220307 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()){
            int numRows = scanner.nextInt();
            String result = convertToBase7(numRows);
            System.out.println(result);
        }
    }
    static  public String convertToBase7(int num) {
        if(num == 0)
            return "0";
        StringBuilder stringbuiler = new StringBuilder();
        int m = Math.abs(num);
        while(m > 0){
            stringbuiler.append(m % 7);
            m = m / 7;
        }
        if(num < 0)
            stringbuiler.append("-");
        return stringbuiler.reverse().toString();
    }
}
