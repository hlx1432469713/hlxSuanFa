package flashBack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 *date：2022-02-10
 *
 * message :  电话号码的字母组合
 *
 * work : 给定一个仅包含数字2-9的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 2 :abc  3:def  4: ghi  5:jkl  6:mno  7:pqrs   8:tuv  9:wxyz
 */
public class flashBackOneHundredFour20220210 {
    public static void main(String args[]){
      Scanner scanner = new Scanner(System.in);
      while(scanner.hasNext()){
         String digits =scanner.next();
         List<String> str = letterCombinations(digits);
         for (String s : str)
             System.out.println(s + "  ");

      }

    }
    static List<String> str = new ArrayList<>();
    static StringBuilder  stringBuilder = new StringBuilder ();
    static String[] list = {"","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    static  public List<String> letterCombinations(String digits) {
        if (digits.isEmpty())
            return str;
        backtracking(digits,0);
        return str;

    }

    static public void backtracking(String digits,int start){
        if (stringBuilder.length() == digits.length()){
            str.add(String.valueOf(stringBuilder));
            return;
        }
        String s = list[digits.charAt(start) - '0' - 1];
        char[] d = s.toCharArray();
        for (int i = 0;i < d.length;i++){
            stringBuilder.append(d[i]);
            backtracking(digits,start+1);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }

    }


}
