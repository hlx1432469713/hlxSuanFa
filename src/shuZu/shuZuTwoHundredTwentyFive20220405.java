package shuZu;


import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.TreeSet;

/**
 *date：2022-04-05
 *
 * message : 739. 每日温度
 *
 * work :给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，其中 answer[i] 是指在第 i 天之后，
 * 才会有更高的温度。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 *
 */
public class shuZuTwoHundredTwentyFive20220405 {
    public static void main(String args[]){}
    //单调栈
    static  public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0;i < temperatures.length ;i++){
            while (!stack .isEmpty() && temperatures[i] >temperatures[stack.peek()]){
                result[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.push(i);
        }
        return result;
    }

    //时间复杂度过高 o(n ^ 2)
    static  public int[] dailyTemperatures2(int[] temperatures) {
        int[] result = new int[temperatures.length];
       for (int i = 0;i < temperatures.length;i++)
           for (int j = i + 1;j < temperatures.length;j++){
               if (temperatures[j] > temperatures[i]){
                   result[i] = j - i;
                   break;
               }
           }
        return result;
    }

}
