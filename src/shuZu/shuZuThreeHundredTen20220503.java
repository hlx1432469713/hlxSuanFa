package shuZu;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 *date：2022-05-03
 *
 * message :937. 重新排列日志文件
 *
 * work :给你一个日志数组 logs。每条日志都是以空格分隔的字串，其第一个字为字母与数字混合的 标识符 。
 *
 * 有两种不同类型的日志：
 *
 * 字母日志：除标识符之外，所有字均由小写字母组成
 * 数字日志：除标识符之外，所有字均由数字组成
 * 请按下述规则将日志重新排序：
 *
 * 所有 字母日志 都排在 数字日志 之前。
 * 字母日志 在内容不同时，忽略标识符后，按内容字母顺序排序；在内容相同时，按标识符排序。
 * 数字日志 应该保留原来的相对顺序。
 * 返回日志的最终顺序。
 *
 */
public class shuZuThreeHundredTen20220503 {
    public static void main(String[] args){}
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs,(log1, log2) -> {
            String[] s1 = log1.split(" ",2);
            String[] s2 = log2.split(" ",2);
            boolean a = Character.isDigit(s1[1].charAt(0));
            boolean b = Character.isDigit(s2[1].charAt(0));
            // 1表示两个数位置交换，
            // -1表示两个数位置不交换，
            // 0表示两个相同元素不排序，
            // 要是我们把等于返回为-1，那么两个相同的元素会交互顺序
            if(a && b)
                return 0;
            if(!a && !b){
                int c = s1[1].compareTo(s2[1]);
                if(c!=0)
                    return c;
                return s1[0].compareTo(s2[0]);
            }
            return a ? 1 : -1;
            // 如果s1是数字字符，则s2是字母字符，返回1，代表两个需要交换顺序
            // 如果s1是字母字符，则s2是数字字符，返回-1，代表两个不需要交换顺序
        });
        return logs;
    }
}
