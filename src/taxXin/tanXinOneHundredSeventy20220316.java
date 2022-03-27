package taxXin;

import java.util.Scanner;

/**
 *date：2022-03-14
 *
 * message ：680. 验证回文字符串 Ⅱ
 *
 * work :给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 *
 *

 */
public class tanXinOneHundredSeventy20220316 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String s = scanner.next();
            boolean result = validPalindrome(s);
            System.out.println(result);
        }
    }



    static  public boolean validPalindrome(String s) {
        if (s.length() == 1)
            return true;
        char[] list = s.toCharArray();
       int left = 0;
       int right = list.length - 1;

       while(left < right ){
           if (list[left] == list[right]){
               left++;
               right--;
           }else{
               //当左右指针指向的字符不相等的时候，分别去校验[left,right - 1] 和[left + 1,right]这两部分是否可以形成一个回文串
               //如果其中有一个true，表明去掉一个字符能够形成回文字符串
               //如果全是false，表面去掉一个字符不足以剩下的字符串形成回文字符串
              return isPalindrome(s,left + 1,right) || isPalindrome(s,left,right-1);
           }
       }
       return true;
    }

    //判断是否为回文子串
    static private boolean isPalindrome(String s,int start,int end){
        while(start < end){
            if (s.charAt(start) != s.charAt(end))
                return false;
            else{
                start++;
                end--;
            }
        }
        return true;
    }
}
