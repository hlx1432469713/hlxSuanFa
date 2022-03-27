package flashBack;

import java.util.HashSet;
import java.util.Scanner;

/**
 *date：2022-02-27
 *
 * message :1849. 将字符串拆分为递减的连续值
 *
 * work : 给你一个仅由数字组成的字符串 s 。
 *
 * 请你判断能否将 s 拆分成两个或者多个 非空子字符串 ，使子字符串的 数值 按 降序 排列，且每两个 相邻子字符串 的数值之 差 等于 1 。
 *
 * 例如，字符串 s = "0090089" 可以拆分成 ["0090", "089"] ，数值为 [90,89] 。这些数值满足按降序排列，且相邻值相差 1 ，这种拆分方法可行。
 * 另一个例子中，字符串 s = "001" 可以拆分成 ["0", "01"]、["00", "1"] 或 ["0", "0", "1"] 。然而，所有这些拆分方法都不可行，
 * 因为对应数值分别是 [0,1]、[0,1] 和 [0,0,1] ，都不满足按降序排列的要求。
 * 如果可以按要求拆分 s ，返回 true ；否则，返回 false 。
 *
 * 子字符串 是字符串中的一个连续字符序列。
 *
 * 输入：s = "10009998"
 * 输出：true
 * 解释：s 可以拆分为 ["100", "099", "98"] ，对应数值为 [100,99,98] 。
 * 满足按降序排列，且相邻值相差 1 。
 *
 */
public class flashBackOneHundredForty20220227 {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()){
            String s = scanner.next();
            boolean result = splitString(s);
            System.out.println(result);
        }
    }

    static  public boolean splitString(String s) {
        if (s.length() < 2)
            return false;
        return backtracking(s,0,-1);
    }
    static boolean backtracking(String s, int start,long preSum){
        long all = 0;
        for (int i =start;i < s.length();i++){
            all = all * 10 + s.charAt(i) - '0';
            if (preSum==-1){
                boolean flag = backtracking(s,i + 1,all);
                if (flag)
                    return true;
            }else{
                if (preSum - all == 1){
                    if (i == s.length() - 1)
                        return true;
                    boolean flag = backtracking(s,i + 1,all);
                    if (flag)
                        return true;
                }
            }
        }
        return false;
    }

}
