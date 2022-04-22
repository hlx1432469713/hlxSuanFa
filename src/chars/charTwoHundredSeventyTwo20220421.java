package chars;

import java.util.Scanner;

/**
 *date：2022-04-21
 *
 * message :824. 山羊拉丁文
 *
 * work :给你一个由若干单词组成的句子sentence ，单词间由空格分隔。每个单词仅由大写和小写英文字母组成。
 *
 * 请你将句子转换为 “山羊拉丁文（Goat Latin）”（一种类似于 猪拉丁文- Pig Latin 的虚构语言）。山羊拉丁文的规则如下：
 *
 * 如果单词以元音开头（'a', 'e', 'i', 'o', 'u'），在单词后添加"ma"。
 * 例如，单词 "apple" 变为 "applema" 。
 * 如果单词以辅音字母开头（即，非元音字母），移除第一个字符并将它放到末尾，之后再添加"ma"。
 * 例如，单词 "goat" 变为 "oatgma" 。
 * 根据单词在句子中的索引，在单词最后添加与索引相同数量的字母'a'，索引从 1 开始。
 * 例如，在第一个单词后添加 "a" ，在第二个单词后添加 "aa" ，以此类推。
 * 返回将 sentence 转换为山羊拉丁文后的句子。
 *
 *
 */
public class charTwoHundredSeventyTwo20220421 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String s = scanner.next();
            String str = toGoatLatin(s);
            System.out.println(str);
        }
    }

    static public String toGoatLatin(String sentence) {
        StringBuilder s1 = new StringBuilder();
        String s2 = "aeiouAEIOU";
        String[] list = sentence.split(" ");
        for(int i = 1;i <= list.length;i++){
            if(s2.contains(list[i - 1].charAt(0) + "")){
                s1.append(list[i - 1] + "ma");
            }else{
                s1.append(list[i - 1].substring(1,list[i - 1].length()) + list[i - 1].charAt(0) + "ma");
            }
            for(int j = 0;j < i;j++)
                s1.append('a');
            if(i < list.length)
                s1.append(" ");

        }
        return s1.toString();

    }
}
