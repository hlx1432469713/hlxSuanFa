package taxXin;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *date：2022-03-14
 *
 * message ：409. 最长回文串(21分49秒)
 *
 * work :给定一个包含大写字母和小写字母的字符串s，返回通过这些字母构造成的 最长的回文串。
 *
 * 在构造过程中，请注意 区分大小写 。比如"Aa"不能当做一个回文字符串。
 *
 *

 */
public class tanXinOneHundredSixtyNine20220316 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()){
            String s = scanner.next();
            int result = longestPalindrome(s);
            System.out.println(result);
        }
    }
    //使用map作为哈希表；
    static  public int longestPalindrome(String s) {
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0;i < s.length();i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        int sum = 0;
        for (Character character : map.keySet()) {
           if (map.get(character) % 2 == 0)
                sum += map.get(character);
            else {
               sum += map.get(character) - 1;
           }
        }
        if (sum < s.length())
            sum += 1;
        return sum ;
    }

    //使用数组作为哈希表
    static  public int longestPalindrome2(String s) {
        int[] list = new int[58];
        for (int i = 0;i < s.length();i++)
            list[s.charAt(i) - 'A']++;
        int sum = 0;
        for (int i = 0; i < list.length; i++) {
            if (list[i] % 2 == 0)
                sum += list[i];
            else
                sum += list[i] - 1;
        }
        // 如果最终的长度小于原字符串的长度，说明里面某个字符出现了奇数次，那么那个字符可以放在回文串的中间，所以额外再加一。
        if (sum < s.length())
            sum += 1;
        return sum;
    }
}
