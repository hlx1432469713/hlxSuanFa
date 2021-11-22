import java.util.Scanner;
import java.util.Stack;

/**
 *date：2021-11-19
 *
 * message ：反转字符串II
 *
 * work:给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。
 *
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样
 *


 */
public class charTwentyFour20211119 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String s = scanner.next();
            int k = scanner.nextInt();
            String result = reverseStr(s,k);
            System.out.println(result);
        }


    }

    static public String reverseStr(String s, int k) {
        char str[] = s.toCharArray();
        int length = str.length;
        //每次前进2k个字符
        for(int i = 0;i < str.length;i = i+2*k){
            int left = i;
            int right = 0;
            if((left + k -1) < length - 1)
                right = left + k -1;
            else
                right = length - 1;
            while(left <= right){
                char temp = str[left];
                str[left] = str[right];
                str[right] = temp;
                left++;
                right--;
            }
        }
        return String.valueOf(str);
    }
}
