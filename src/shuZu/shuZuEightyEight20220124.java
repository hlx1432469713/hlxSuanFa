package shuZu;

import java.util.Scanner;

/**
 *date：2022-01-24
 *
 * message ：加一
 *
 * work:给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *

 *

 */

public class shuZuEightyEight20220124 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] digits = new int[n];
        for(int i = 0;i < n;i++){
            digits[i] = scanner.nextInt();
        }
        int[] result = plusOne(digits);
        for(int j = 0;j < result.length;j++)
            System.out.print(result[j] + "  ");

    }

    static public int[] plusOne(int[] digits) {
        int length = digits.length;
        while(length > 0){
            int num = digits[length - 1] + 1;
            if (num <= 9){
                digits[length - 1] = num;
                return digits;
            }else {
                digits[length - 1] = 0;
                length--;
            }
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;


    }
}
