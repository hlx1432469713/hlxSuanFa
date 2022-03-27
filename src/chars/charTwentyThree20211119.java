package chars;

import java.util.Scanner;
import java.util.Stack;

/**
 *date：2021-11-19
 *
 * message ：反转字符串
 *
 * work:编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。
 *      不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 */
public class charTwentyThree20211119 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int nums = scanner.nextInt();
            char[] s = new char[nums];
            for(int i = 0;i < nums;i++)
                s[i] = scanner.next().charAt(0);
            reverseString(s);
            for(char s1:s)
                System.out.print(s1 + "  ");
        }

    }

    static public void reverseString(char[] s) {
        int left = 0,right = s.length - 1;
        while(left <= right){
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }


}
