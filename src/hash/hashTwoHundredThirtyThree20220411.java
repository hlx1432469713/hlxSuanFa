package hash;

import java.util.HashSet;
import java.util.Set;

/**
 *date：2022-04-11
 *
 * message :804. 唯一摩尔斯密码词
 *
 * work :国际摩尔斯密码定义一种标准编码方式，将每个字母对应于一个由一系列点和短线组成的字符串，比如:
 *
 * 'a' 对应 ".-" ，
 * 'b' 对应 "-..." ，
 * 'c' 对应 "-.-." ，以此类推。
 * 为了方便，所有 26 个英文字母的摩尔斯密码表如下：
 *
 * [".-","-...","-.-.","-..",".","..-.","--.","....","..",".---",
 * "-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-",
 * "...-",".--","-..-","-.--","--.."]
 *
 * 给你一个字符串数组 words ，每个单词可以写成每个字母对应摩尔斯密码的组合。
 *
 * 例如，"cab" 可以写成 "-.-..--..." ，(即 "-.-." + ".-" + "-..." 字符串的结合)。我们将这样一个连接过程称作 单词翻译 。
 * 对 words 中所有单词进行单词翻译，返回不同 单词翻译 的数量。
 */
public class hashTwoHundredThirtyThree20220411 {
    public static void main(String[] args){}
    static public int uniqueMorseRepresentations(String[] words) {
        String[] list = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        StringBuilder s1 = new StringBuilder();
        Set<String> set = new HashSet<>();
        for(int i = 0;i < words.length;i++){
            for(int j = 0;j < words[i].length();j++)
                s1.append(list[words[i].charAt(j) - 'a']);
            set.add(s1.toString());
            s1.setLength(0);
        }
        return set.size();

    }
}
