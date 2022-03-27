package chars;

import java.util.Scanner;

/**
 *date：2022-02-25
 *
 * message : 537. 复数乘法
 *
 * work : 复数 可以用字符串表示，遵循 "实部+虚部i" 的形式，并满足下述条件：
 *
 * 实部 是一个整数，取值范围是 [-100, 100]
 * 虚部 也是一个整数，取值范围是 [-100, 100]
 * i2 == -1
 * 给你两个字符串表示的复数 num1 和 num2 ，请你遵循复数表示形式，返回表示它们乘积的字符串。
 */
public class charOneHundredThirtyFour20220225 {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String num1 = scanner.next();
            String num2 = scanner.next();
            String result = complexNumberMultiply(num1,num2);
            System.out.println(result);
        }

    }
    //模拟题
    static public String complexNumberMultiply(String num1, String num2) {
        String[] list1 = num1.split("\\+");
        String[] list2 = num2.split("\\+");
        String[] a2 = list1[1].split("i");
        String[] b2 = list2[1].split("i");
        Integer x1 = Integer.valueOf(list1[0] )* Integer.valueOf(list2[0] );
        int x2 = Integer.valueOf(a2[0]);
        int x3 = Integer.valueOf(b2[0]);
        int x = x1 -x2 * x3;
        int y1 =  x2 *  Integer.valueOf(list2[0]);
        int y2 =  x3 *  Integer.valueOf(list1[0]);
        int y = y1 + y2;
        return x+"+"+y+"i";
    }

}
