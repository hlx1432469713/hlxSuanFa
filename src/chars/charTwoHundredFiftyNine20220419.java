package chars;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 *date：2022-04-19
 *
 * message :821. 字符的最短距离
 *
 * work :给你一个字符串 s 和一个字符 c ，且 c 是 s 中出现过的字符。
 *
 * 返回一个整数数组 answer ，其中 answer.length == s.length 且 answer[i] 是 s 中从下标 i 到离它 最近 的字符 c 的 距离 。
 *
 * 两个下标 i 和 j 之间的 距离 为 abs(i - j) ，其中 abs 是绝对值函数。
 *
 *
 *
 */
public class charTwoHundredFiftyNine20220419 {
    public static void main(String[] args){}
    public int[] shortestToChar(String s, char c) {
        int n = s.length();
        int[] result = new int[n];
        if(n == 1){
            result[0] = 0;
            return result;
        }
        int flag = Integer.MAX_VALUE;
        int left = 0,right = 0;
        while(left <= right && right < n){
            if(s.charAt(right) == c){
                while(left <= right){
                    result[left] = Math.min(Math.abs(right - left),Math.abs(flag - left));
                    left++;
                }
                flag = right;
            }else if(flag != Integer.MAX_VALUE){
                result[right] = Math.abs(flag - right);
            }
            right++;
        }
        return result;
    }
    public int[] shortestToChar2(String s, char c) {
        int n = s.length();
        int[] result = new int[n];
        Arrays.fill(result,Integer.MAX_VALUE);
        if(n == 1){
            result[0] = 0;
            return result;
        }
        int left = 0,right = s.length() - 1;
       for(int i = 0;i < s.length();i++){
           if (s.charAt(i) == c){
               while(left <= i){
                   result[left] = Math.min(result[left],i - left);
                   left++;
               }
           }
       }
        for(int j = s.length() - 1;j >= 0;j--){
            if (s.charAt(j) == c){
                while(right >= j){
                    result[right] = Math.min(result[right],right - j);
                    right--;
                }
            }
        }
        return result;
    }
}
