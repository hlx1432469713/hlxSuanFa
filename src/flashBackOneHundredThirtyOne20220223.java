import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 *date：2022-02-23
 *
 * message : 306. 累加数
 *
 * work :累加数 是一个字符串，组成它的数字可以形成累加序列。
 *
 * 一个有效的 累加序列 必须 至少 包含 3 个数。除了最开始的两个数以外，序列中的每个后续数字必须是它之前两个数字之和。
 *
 * 给你一个只包含数字'0'-'9'的字符串，编写一个算法来判断给定输入是否是 累加数 。如果是，返回 true ；否则，返回 false 。
 *
 * 说明：累加序列里的数，除数字 0 之外，不会 以 0 开头，所以不会出现1, 2, 03 或者1, 02, 3的情况。
 */
public class flashBackOneHundredThirtyOne20220223 {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String num = scanner.next();
            boolean flag  = isAdditiveNumber(num);
            System.out.println(flag);
        }
    }
    static List<Long> list = new ArrayList<>();
    static  public boolean isAdditiveNumber(String num) {
        if (num.length() < 3)
            return false;
        return backtracking(num,0);
    }
    static public boolean backtracking(String nums,int start){
        //当list中数组达到3个及其以上，根据其list当前长度，计算是否 倒数第一 = 倒数第二 + 倒数第三
        if (list.size() >= 3){
            int x = list.size() - 1;
            if (list.get(x) != list.get(x - 2)  + list.get(x - 1))
                return false;
            if (start >= nums.length())
                return true;
        }
        long current = 0;
        for (int i = start;i < nums.length();i++){
            //对于前导0进行 剪枝
            if (i > start && nums.charAt(start ) == '0')
                break;
            //使用这样 能保证大数  能够存储在list中
            current = current * 10 + nums.charAt(i) - '0';

            list.add(current);
            boolean flag = backtracking(nums,i + 1);
            //如果是true  说明已经遍历到最后 同时最后的累加结果正确
            if (flag == true)
                return true;
            list.remove(list.size() - 1);
        }
        return false;


    }


}
