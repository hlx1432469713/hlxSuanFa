import java.io.UnsupportedEncodingException;
import java.util.*;

/**
 *date：2022-03-17
 *
 * message :  599. 两个列表的最小索引总和
 *
 * work :  给出一个字符串数组words 组成的一本英语词典。
 * 返回words 中最长的一个单词，该单词是由words词典中其他单词逐步添加一个字母组成。
 *
 * 若其中有多个可行的答案，则返回答案中字典序最小的单词。若无答案，则返回空字符串。
 *

 *
 */
public class hashOneHundredSeventyTwo20220317 {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int n = scanner.nextInt();
            String[] words = new String[n];
            for (int i = 0;i < n;i++)
                words[i] = scanner.next();
            String word = longestWord(words);
            System.out.println(word);
        }
    }
    static  public String longestWord(String[] words) {
        if (words.length == 1)
            return words[0];
        Arrays.sort(words,(a,b)->{
            if (a.length() == b.length()) {
                //当字符串长度相同时候，按照字典顺序进行相反排序（这样在下面就不需要在进行判断，直接替换结果单词，最后的答案一定
                // 是字典序中最小的单词）
              return  b.compareTo(a);
            }
            //数组按照字符串长度从小到大排序
            return a.length() - b.length();
        });
        Map<String,Integer> map = new HashMap<>();
        //方便存储单个字符
        map.put("",0);
        String result = "";
        for (int i = 0; i < words.length; i++) {
          if(map.containsKey(words[i].substring(0,words[i].length() - 1))){
              //由于上面是按照字典顺序 的相反顺序进行排列的，所以这里对应符合条件的单词，直接替换即可
              result = words[i];
              map.put(words[i],i);
            }
        }
        return result;

    }

}
