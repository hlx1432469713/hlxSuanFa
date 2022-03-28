package chars;

import java.util.Arrays;
import java.util.Scanner;

/**
 *date：2022-03-28
 *
 * message :557. 反转字符串中的单词 III
 *
 * work : 给定一个字符串 s ，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 *
 */
public class charOneHundredNintyEight20220328 {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String s =scanner.next();
            String result = reverseWords(s);
            System.out.println(result);
        }
    }

    /**
     * 双指针
     * @param s
     * @return
     */
    static  public String reverseWords(String s) {
        String[] str = s.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0;i < str.length;i++){
            char[] list = str[i].toCharArray();
            int left = 0;
            int right = list.length - 1;
            while(left < right){
                char a = list[left];
                list[left] = list[right];
                list[right] = a;
                left++;
                right--;
            }
            if(i == str.length - 1)
                stringBuilder.append(list);
            else{
                stringBuilder.append(list);
                stringBuilder.append(" ");
            }
        }
        return stringBuilder.toString();
    }
}
