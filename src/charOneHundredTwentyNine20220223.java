import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *date：2022-02-23
 *
 * message :  仅仅反转字母
 *
 * work : 给你一个字符串 s ，根据下述规则反转字符串：
 *
 * 所有非英文字母保留在原有位置。
 * 所有英文字母（小写或大写）位置反转。
 * 返回反转后的 s 。
 */
public class charOneHundredTwentyNine20220223 {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String s = scanner.next();
            String result = reverseOnlyLetters(s);
            System.out.println(result);
        }

    }
    static  public String reverseOnlyLetters(String s) {
        int left  = 0;
        int right = s.length() - 1;
        char[] chars = s.toCharArray();
        while(left < right){
            if(!Character.isLetter(chars[left])){
                left++;
                continue;
            }else if (!Character.isLetter(chars[right])){
                right--;
                continue;
            }
            char c = chars[left];
            chars[left] = chars[right];
            chars[right] = c;
            left++;
            right--;
        }
        return String.valueOf(chars);
    }
}
