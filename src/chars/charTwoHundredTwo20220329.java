package chars;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *date：2022-03-29
 *
 * message :1004. 最大连续1的个数 III
 *
 * work : 给定一个二进制数组 nums 和一个整数 k，如果可以翻转最多 k 个 0 ，则返回 数组中连续 1 的最大个数 。
 *
 *
 */
public class charTwoHundredTwo20220329 {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String s = scanner.next();
            int result = lengthOfLongestSubstring(s);
            System.out.println(result);
        }
    }

    /**
     * 滑动窗口
     * 输入: s = "abcaabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     * @param
     * @return
     */
    static public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> map = new HashMap<>();
        int left = 0;
        int length = 1;
       for (int i = 0;i < s.length();i++){
           if (map.containsKey(s.charAt(i))){
               left = Math.max(left,map.get(s.charAt(i)) + 1);
           }
           map.put(s.charAt(i),i);
           length = Math.max(length,i - left + 1);
       }
       return length;
    }

    static public int lengthOfLongestSubstring2(String s) {
        if (s.length() == 0)
            return 0;
        Map<Character,Integer> map = new HashMap<>();
        int left = 0;
        int right = 1;
        int length = 0;
        map.put(s.charAt(0),0);
        while(left < right && right < s.length()){
            if (map.containsKey(s.charAt(right))){
                left = Math.max(left,map.get(s.charAt(right)) + 1);
            }
            map.put(s.charAt(right),right);
            length = Math.max(length,right - left + 1);
        }
        return length;

    }
}
