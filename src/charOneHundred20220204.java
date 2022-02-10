import java.util.Scanner;

/**
 *date：2022-02-04
 *
 * message :  翻转字符串里的单词
 *
 * work : 给你一个字符串 s ，逐个翻转字符串中的所有 单词 。
 * 单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
 * 请你返回一个翻转 s 中单词顺序并用单个空格相连的字符串。
 *
 * 说明：
 *
 * 输入字符串 s 可以在前面、后面或者单词间包含多余的空格。
 * 翻转后单词间应当仅用一个空格分隔。
 * 翻转后的字符串中不应包含额外的空格。
 */
public class charOneHundred20220204 {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String s = scanner.nextLine();
            String result = reverseWords(s);
            System.out.print(result);
        }

    }
    static  public String reverseWords(String s) {
        String[] list = s.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = list.length - 1;i >=0;i--){
            if (!list[i].equals("")){
                if (stringBuilder.length() == 0)
                    stringBuilder.append(list[i]);
                else
                    stringBuilder.append(" " + list[i]);
            }
        }
        return stringBuilder.toString();

    }
}
