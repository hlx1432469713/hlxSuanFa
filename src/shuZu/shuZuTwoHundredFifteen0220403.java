package shuZu;


import java.util.HashMap;
import java.util.Map;

/**
 *date：2022-04-03
 *
 * message : 744. 寻找比目标字母大的最小字母
 *
 * work :给你一个排序后的字符列表 letters ，列表中只包含小写英文字母。
 * 另给出一个目标字母target，请你寻找在这一有序列表里比目标字母大的最小字母。
 *
 * 在比较时，字母是依序循环出现的。举个例子：
 *
 * 如果目标字母 target = 'z' 并且字符列表为letters = ['a', 'b']，则答案返回'a'
 *
 */
public class shuZuTwoHundredFifteen0220403 {
    public static void main(String args[]){}


    static   public char nextGreatestLetter(char[] letters, char target) {
        int left = 0;
        int right = letters.length - 1;
        char flag = target;
        if(letters[letters.length - 1] <= target)
            return letters[0];
        while(left <= right){
            int mid = left + ((right - left)/2);
            if(letters[mid] > target){
                flag = letters[mid];
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return flag;
    }
}
