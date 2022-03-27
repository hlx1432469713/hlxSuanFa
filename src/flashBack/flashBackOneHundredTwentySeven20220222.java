package flashBack;

import java.util.*;

/**
 *date：2022-02-22
 *
 * message : 字母大小写全排列
 *
 * work :给定一个字符串 s ，通过将字符串 s 中的每个字母转变大小写，我们可以获得一个新的字符串。
 *
 * 返回 所有可能得到的字符串集合 。以 任意顺序 返回输出。
 */
public class flashBackOneHundredTwentySeven20220222 {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String s = scanner.next();
            List<String> result = letterCasePermutation(s);
            for (String s1 : result)
                System.out.print(s1 + " ");
        }
    }

    static StringBuilder stringBuilder = new StringBuilder();
    static List<String> list = new ArrayList<>();
    static public List<String> letterCasePermutation(String s) {
        if (s == null)
            return list;
        char[] chars = s.toCharArray();
        backtracking(chars,0);
        return list;

    }

    //先不管大小写 先遍历到最后，然后回溯，如果是 字母  就进行大小写的转换，然在进行遍历 这样就可以全部遍历到
    static public void backtracking(char[] s,int start){
        if (stringBuilder.length() == s.length){
            list.add(stringBuilder.toString());
            return;
        }
        stringBuilder.append(s[start]);
        backtracking(s,start+1);
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        if (!Character.isDigit(s[start])){
            char x = (char)(s[start] - 'a' >= 0 ?s[start] - 32:s[start]+32);
            stringBuilder.append(x);
            backtracking(s,start + 1);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }

    }


}
