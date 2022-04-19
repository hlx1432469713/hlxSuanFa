package chars;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *date：2022-04-17
 *
 * message : 819. 最常见的单词
 *
 * work :
 * 给定一个段落 (paragraph) 和一个禁用单词列表 (banned)。返回出现次数最多，同时不在禁用列表中的单词。
 *
 * 题目保证至少有一个词不在禁用列表中，而且答案唯一。
 *
 * 禁用列表中的单词用小写字母表示，不含标点符号。段落中的单词不区分大小写。答案都是小写字母。

 *
 *
 */
public class charTwoHundredFiftyFive20220417 {
    public static void main(String[] args){}
    static public String mostCommonWord(String paragraph, String[] banned) {
        int max = 0;
        String result = "";
        paragraph = paragraph.toLowerCase();
        Set<String> set = new HashSet<>();
        for(int i = 0;i < banned.length;i++){
            set.add(banned[i]);
        }
        paragraph = paragraph.replace("!"," ");
        paragraph = paragraph.replace("?"," ");
        paragraph = paragraph.replace("'"," ");
        paragraph = paragraph.replace(","," ");
        paragraph = paragraph.replace("."," ");
        paragraph = paragraph.replace(";"," ");
        String[] list = paragraph.split(" ");
        Map<String,Integer> map = new HashMap<>();
        for(String s : list){
            if(s != "" && !set.contains(s)){
                map.put(s,map.getOrDefault(s,0) + 1);
                if(max < map.get(s)){
                    max = map.get(s);
                    result = s;
                }
            }
        }
        return result;
    }
}
