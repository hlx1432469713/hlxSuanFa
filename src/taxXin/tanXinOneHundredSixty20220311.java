package taxXin;

import java.util.*;

/**
 *date：2022-03-11
 *
 * message ：763. 划分字母区间
 * work :字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。
 * 返回一个表示每个字符串片段的长度的列表。
 *
 * 输入：S = "ababcbacadefegdehijhklij"
 * 输出：[9,7,8]
 * 解释：
 * 划分结果为 "ababcbaca", "defegde", "hijhklij"。
 * 每个字母最多出现在一个片段中。
 * 像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
 *
 */
public class tanXinOneHundredSixty20220311 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()){
            String s = scanner.next();
            List<Integer> list = partitionLabels(s);
            for (Integer integer : list) {
                System.out.print(integer + "  ");
            }

        }
    }



    //用map
    static  public List<Integer> partitionLabels(String s) {
        Map<Character,Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0;i < s.length();i++){
            map.put(s.charAt(i),i);
        }
        int flag = 0;
        int index= 0;
        for (int i = 0;i < s.length();i++){
            flag = Math.max(flag , map.get(s.charAt(i)));
            if (flag == i){
                list.add(flag - index + 1);
                index = i + 1;
            }
        }
        return list;
    }

    //用数组
    static  public List<Integer> partitionLabels2(String s) {
       int[] map = new int[26];
        List<Integer> list = new ArrayList<>();
        //首先记录字符串中每个字符的最远位置
        for (int i = 0;i < s.length();i++){
            map[s.charAt(i) - 'a'] = i;
        }
        int flag = 0;
        int index= 0;
        //从头开始遍历，如果当前i 跟最远位置flag 相同的化，就可以切割一刀，记录该子串的长度
        for (int i = 0;i < s.length();i++){
            //随着遍历，不断更新最远位置flag的值，直到该flag的值跟当前i相等
            flag = Math.max(flag , map[s.charAt(i) - 'a']);
            if (flag == i){
                list.add(flag - index + 1);
                index = i + 1;
            }
        }
        return list;
    }
}
