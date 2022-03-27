package flashBack;

import java.util.*;

/**
 *date：2022-02-26
 *
 * message : 1593. 拆分字符串使唯一子字符串的数目最大
 *
 * work : 给你一个字符串 s ，请你拆分该字符串，并返回拆分后唯一子字符串的最大数目。
 *
 * 字符串 s 拆分后可以得到若干 非空子字符串 ，这些子字符串连接后应当能够还原为原字符串。但是拆分出来的每个子字符串都必须是 唯一的 。
 *
 * 注意：子字符串 是字符串中的一个连续字符序列。
 *
 *
 * 输入：s = "ababccc"
 * 输出：5
 * 解释：一种最大拆分方法为 ['a', 'b', 'ab', 'c', 'cc'] 。像 ['a', 'b', 'a', 'b', 'c', 'cc'] 这样拆分不满足题目要求，因为其中的 'a' 和 'b' 都出现了不止一次。
 *
 *
 */
public class flashBackOneHundredThirtyEight20220226 {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
           String s = scanner.next();
           int result = maxUniqueSplit(s);
           System.out.println(result);
        }
    }

    static int max = 1;
    static public int maxUniqueSplit(String s) {
        backtracking(new HashSet<String>(),s,0,0);
        return max;
    }
    static void backtracking(HashSet<String> set , String s , int start,int sum){;
        if (start >= s.length()){
            max = Math.max(max,sum);
            return;
        }
        for (int i = start;i < s.length();i++){
            //进行剪枝
            if (set.size() + s.length() - i <= max)
                return;
            String s1 = s.substring(start,i+1);
            if (set.contains(s1))
                continue;
            set.add(s1);
            backtracking(set,s,i + 1,sum + 1);
            set.remove(s1);
        }


    }


}
