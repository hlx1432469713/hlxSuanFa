import java.util.Arrays;
import java.util.Scanner;

/**
 *date：2021-10-30
 *
 * message ：双指针法（移除元素）
 *
 * work:给你两个字符串haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回 -1 。
 说明：
 *。对于本题而言，当needle是空字符串时我们应当返回 0 。这与 C 语言的strstr()以及 Java 的indexOf()定义相符。
 *
 */
public class shuZuNine20211030 {
    public static void main(String[] args){
      Scanner scanner = new Scanner(System.in);
      String str1 = scanner.next();
      String str2 = scanner.next();
        int x = strStr(str1,str2);
        System.out.println(x);
    }
    static public int strStr(String haystack, String needle) {
        int index = 0;
        if(haystack.length()==0&& needle.length()==0)
            return 0;
        if(haystack.length()==0 || needle.length()==0)
            return -1;
        for(int i = 0;i<haystack.length();i++){
            char s1 = haystack.charAt(i);
            char s2 = needle.charAt(index);
            if(s1 == s2){
                index++;
            }else{
                i = i- index;
                index = 0;
            }
            if(index == needle.length())
                return i-index+1;
        }
        return -1;
    }

}
