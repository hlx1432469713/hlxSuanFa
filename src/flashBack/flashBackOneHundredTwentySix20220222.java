package flashBack;

import java.util.*;

/**
 *date：2022-02-22
 *
 * message :  字符串的排列
 *
 * work :输入一个字符串，打印出该字符串中字符的所有排列。
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 */
public class flashBackOneHundredTwentySix20220222 {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String s = scanner.next();
            String[] result = permutation(s);
            for (String s1 : result)
                System.out.print(s1 + " ");
        }
    }

    static StringBuilder stringBuilder = new StringBuilder();
    static List<String> list = new ArrayList<>();
    static public String[] permutation(String s) {
        if (s == null)
            return list.toArray(new String[list.size()]);
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        backtracking(chars,new boolean[s.length()]);
        return list.toArray(new String[list.size()]);
    }
    //需要两次去重  一次是不能使用已经存入的数据   第二次是在同一层遍历的时候 对相同字母进行去重
    //从左往右第一个未被填入的字符
    static public void backtracking(char[] s,boolean[] flag){
        if (stringBuilder.length() == s.length){
            list.add(stringBuilder.toString());
            return;
        }
        for (int i = 0;i < s.length;i++){
            if (flag[i] == true || (i > 0 && !flag[i - 1]&&s[i] == s[i - 1]))
                continue;
            flag[i] = true;
            stringBuilder.append(s[i]);
            backtracking(s,flag);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            flag[i] = false;
        }
    }


}
