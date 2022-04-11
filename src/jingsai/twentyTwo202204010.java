package jingsai;

import java.util.Arrays;

/**
 *date：2022-04-10
 *
 * message ：2232. 向表达式添加括号后的最小结果
 *
 * work : 给你一个下标从 0 开始的字符串 expression ，格式为 "<num1>+<num2>" ，其中 <num1> 和 <num2> 表示正整数。
 *
 * 请你向 expression 中添加一对括号，使得在添加之后， expression 仍然是一个有效的数学表达式，
 * 并且计算后可以得到 最小 可能值。左括号 必须 添加在 '+' 的左侧，而右括号必须添加在 '+' 的右侧。
 *
 * 返回添加一对括号后形成的表达式expression ，且满足 expression 计算得到 最小 可能值。如果存在多个答案都能产生相同结果，返回任意一个答案。
 *
 * 生成的输入满足：expression 的原始值和添加满足要求的任一对括号之后 expression 的值，都符合 32-bit 带符号整数范围。
 */
public class twentyTwo202204010 {
    public static void main(String[] args) {}

    static public String minimizeResult(String expression) {
        String[] s1 = expression.split("\\+");
        int n = expression.length();
        int left = s1[0].length();
        int right = left + 1;
        int max = Integer.MAX_VALUE;
        int c = 0,d = 0;
        for(int i = 0;i < left;i++){
            for(int j = right + 1;j<=n;j++){
                int x = Integer.valueOf(expression.substring(i,left));
                int y =  Integer.valueOf(expression.substring(right,j));
                String z = expression.substring(0,i);
                if(i == 0)
                    z = "1";
                String m = expression.substring(j,n);
                if(j == n)
                    m ="1";
                int h = Integer.valueOf(z) * Integer.valueOf(m) *(x + y);
                if(max > h){
                    max =h;
                    c = i;
                    d = j;
                }
            }
        }
        StringBuilder ss = new StringBuilder();
        for(int i = 0;i < expression.length();i++){
            if(i == c){
                ss.append('(');
                ss.append(expression.charAt(i));
            }else if(i  + 1== d){
                ss.append(expression.charAt(i));
                ss.append(')');
            }else{
                ss.append(expression.charAt(i));
            }
        }
        return ss.toString();
    }
}