package hash;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *date：2022-04-01
 *
 * message : 1456. 定长子串中元音的最大数目
 *
 * work :给你字符串 s 和整数 k 。
 *
 * 请返回字符串 s 中长度为 k 的单个子字符串中可能包含的最大元音字母数。
 *
 * 英文中的 元音字母 为（a, e, i, o, u）。
 *

 *
 */
public class hashTwoHundredThirteen20220401 {
    public static void main(String args[]){}


    static  String str = "aeiou";
    static public int maxVowels(String s, int k) {
        int[] num = new int[26];
        int max = 0;
        for(int i = 0;i < k;i++)
            num[s.charAt(i) - 'a']++;
        max = getNum(num);
        for(int i = k;i < s.length();i++){
            num[s.charAt(i)- 'a']++;
            num[s.charAt(i - k) - 'a']--;
            max = Math.max(max,getNum(num));
        }
        return max;
    }
    static public int getNum(int[] num){
        int sum = 0;
        for(int i = 0;i < str.length();i++){
            sum += num[str.charAt(i) - 'a'];
        }
        return sum;
    }
}
