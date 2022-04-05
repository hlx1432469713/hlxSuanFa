package hash;


import java.util.*;

/**
 *date：2022-04-04
 *
 * message :剑指 Offer II 016. 不含重复字符的最长子字符串
 *
 * work : 给定一个字符串 s ，请你找出其中不含有重复字符的 最长连续子字符串 的长度。
 *
 *。
 */
public class hashTwoHundredEighteen20220404 {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String s = scanner.next();
            int result = lengthOfLongestSubstring(s);
            System.out.println(result);
        }
    }
    static public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> map = new HashMap<>();
        int left = 0;
        int len = 0;
        for (int i = 0;i < s.length();i++){
            if (map.containsKey(s.charAt(i))){
                left = Math.max(left,map.get(s.charAt(i)) + 1);
            }
            len = Math.max(len,i - left + 1);
            map.put(s.charAt(i),i);
        }
        return len;

    }
}
