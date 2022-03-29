package Dynamic;

import java.util.List;
import java.util.Scanner;

/**
 *date：2022-03-28
 *
 * message : 139. 单词拆分
 *
 * work ：给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出 s 。
 *
 * 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
 *
 *
 */
public class DynamicOneHundredNintyNine20220328 {
    public static void main(String[] args){}
    /**
     // 2.1 确定dp数组（dp table）以及下标的含义 :dp[i]：字符串长度为i，dp[i]为true，表示该字符串可以拆分成一个或者多个在字典中出现的单词
     //  2.2 确定递推公式 :   dp[i] += dp[i - nums[j]];
     //  2.3 dp数组如何初始化  dp[0] = 1
     //  2.4 确定遍历顺序：由于顺序不同的序列被视为不同的组合，因此这个算是一个排列问题
                        排列问题：先遍历背容量，再遍历物品
                        (每个物品的数量是无限的)完全背包问题：内层背包容量循环：正序遍历
     */
    static public boolean wordBreak(String s, List<String> wordDict) {
        //  单词 wordDict 是物品，
        // 字符串 s 为 背包
        //  单词能否组成字符串 s ，即物品能否将背包装满
        // 可以无限使用是完全背包问题，遍历顺序：先遍历背包容量，再遍历物品（因为求子串，字符串s为背包）
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        //外层表示带分割字符串的长度
        for(int i = 1;i <= s.length();i++){
            //内层表示对字符串进行分割，j代表分割开始位置（也代表分割的第一部分的长度），每次都去比较，分割位置前的那部分字符串是否已经能够由字典
            //中的单词组成，如果能组成，然后再看分割位置后面的部分能否由字典中的单词组成，只有两部分都是true，才能判断长度为i的字符串可以拆分为一个或多个在字典中出现的单词
            for (int j = 0;j < i;j++){
                if (dp[j] && wordDict.contains(s.substring(j,i)))
                    dp[i] = true;
            }
        }
        return dp[s.length()];
    }
}
