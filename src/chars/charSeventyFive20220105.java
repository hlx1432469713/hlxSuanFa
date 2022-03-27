package chars;

import java.util.*;

/**
 *date：2022-01-05
 *
 * message ：替换所有的问号
 *
 * work:给你一个仅包含小写英文字母和 '?' 字符的字符串 s，请你将所有的 '?' 转换为若干小写字母，使最终的字符串不包含任何 连续重复 的字符。
 * 注意：你 不能 修改非 '?' 字符。
 * 题目测试用例保证 除 '?' 字符 之外，不存在连续重复的字符。
 * 在完成所有转换（可能无需转换）后返回最终的字符串。如果有多个解决方案，请返回其中任何一个。可以证明，在给定的约束条件下，答案总是存在的。

 */
public class charSeventyFive20220105 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String s = scanner.next();
            String result = modifyString(s);
            System.out.println(result + "");
        }
    }
    static  public String modifyString(String s) {
        char[] list = s.toCharArray();
        for(int i = 0;i < s.length();i++){
            if (list[i] == '?') {
                char str = 'a';
                //这一步的 边界处理就很 nice --- 能够将i = 0 和 i = s.length()-1 的情况同时考虑进去
                while((i > 0 && list[i - 1] == str) || (i < s.length() -1 && list[i + 1] == str))
                    str++;
                list[i] = str;
            }
        }
        return String.valueOf(list);
    }
}
