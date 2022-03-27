package flashBack;

import java.util.*;

/**
 *date：2022-02-12
 *
 * message :  复原 IP 地址
 *
 * work :  有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 *
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，
 * 但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
 * 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，
 * 这些地址可以通过在 s 中插入'.' 来形成。你不能重新排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。
 */
public class flashBackOneHundredEleven20220212 {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
           String s = scanner.next();
            List<String> list = restoreIpAddresses(s);
            for (String s1 : list){
                System.out.print(s1 +"    ");
            }
        }
    }

    static List<String> list = new ArrayList<>();
    static StringBuilder stringBuilder = new StringBuilder();
    static public List<String> restoreIpAddresses(String s) {
        if (s.length() < 4 || s.length() > 12){
            return list;
        }
        backtracking(s,0,0);
        return list;
    }
    static void backtracking(String s,int start,int num){
        //当分割成三段之后，直接判断后面全部数字
        if ( num == 3){
            if (isNum(s,start,s.length())) {
                stringBuilder.append(s.substring(start));
                list.add(String.valueOf(stringBuilder));
                //注意回溯算法有增加就要有减少--要相对应
                stringBuilder.delete(stringBuilder.length()-(s.length() - start),stringBuilder.length());
            }
            return;
        }
        for (int i = start;i < s.length()&&i <start+3;i++){
            if (isNum(s,start,i + 1)){
                stringBuilder.append(s.substring(start,i+1)+".");
                backtracking(s,i + 1,num+1);
                stringBuilder.delete(stringBuilder.length() - (i + 1 - start + 1),stringBuilder.length());
            }
        }
    }
    static  private boolean isNum(String s,int start,int end){
        //判断边界情况
        if (start >= end)
            return false;
        //判断前导0情况
        if (s.charAt(start) - '0' == 0 && (end - start) >1){
           return false;
        }
        //判断数字是否大于255
        String s1 = s.substring(start, end);
        Integer x = Integer.valueOf(s1);
        if (x > 255)
          return false;
        return true ;
    }
}
