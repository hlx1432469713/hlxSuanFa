package flashBack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *date：2022-02-15
 *
 * message : 括号生成
 *
 * work : 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 */
public class flashBackOneHundredTwenty20220215 {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            List<String> list = generateParenthesis(n);
            for (String str : list)
                System.out.print(str + " ");
        }
    }
    static List<String> list = new ArrayList<>();
    static StringBuilder stringBuilder = new StringBuilder();
    static public List<String> generateParenthesis(int n) {
        if (n < 1)
            return list;
        backtracking(n,0,0);
        return list;
    }

    static public void backtracking(int n,int left,int right) {
        if (left < right)
            return;
        if(left == n && right == n){
            list.add(String.valueOf(stringBuilder));
            return;
        }
        if (left < n){
            stringBuilder.append("(");
            backtracking(n,left +1,right);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        if (right < n){
            stringBuilder.append(")");
            backtracking(n,left ,right + 1);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
    }

}
