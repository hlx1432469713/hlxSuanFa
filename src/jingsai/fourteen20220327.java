package jingsai;

import java.util.Scanner;

/**
 *date：2022-03-27
 *
 * message 5253. 找到指定长度的回文数
 *
 * work : 给你一个整数数组queries和一个 正整数intLength，请你返回一个数组answer，
 * 其中answer[i] 是长度为intLength的正回文数 中第queries[i]小的数字，如果不存在这样的回文数，则为 -1。
 *
 * 回文数 指的是从前往后和从后往前读一模一样的数字。回文数不能有前导 0 。
 *

 */
public class fourteen20220327 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] nums = new int[n];
            for (int i = 0;i < n;i++)
                nums[i] = scanner.nextInt();
            int inLength = scanner.nextInt();
            long[] result = kthPalindrome(nums,inLength);
            for (int i = 0; i < result.length; i++) {
                System.out.print(result[i] + " ");
            }
        }
    }

    /**
     * 取一半的字符串，后面反转即可形成回文串
     *
     * @param queries
     * @param intLength
     * @return
     */
    static  public long[] kthPalindrome(int[] queries, int intLength) {
        long[] result = new long[queries.length];

        //左半部分最小值
        int min = (int) Math.pow(10, Math.floor((intLength - 1) / 2));//向下取整
        //左半部分最大值
        int max = (int) Math.pow(10, Math.floor((intLength - 1) / 2) + 1) - 1;

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < queries.length; i++) {
            //max - min + 1:代表长度为intLength 的回文数的总数
            if(queries[i] > (max - min + 1)){
                result[i] = -1;
                continue;
            }
            //回文串左半部分计算公式
            stringBuilder.append(min + queries[i] - 1);
            //偶数长度直接反转拼接
            if (intLength % 2 == 0) {
                stringBuilder.append(new StringBuilder(stringBuilder).reverse());
            } else {
                //奇数长度，先反转 然后去掉第一个字符，再进行拼接
                stringBuilder.append(new StringBuilder(stringBuilder).reverse().substring(1));
            }
            Long x = Long.parseLong(stringBuilder.toString());
            result[i] = x;
            //恢复空字符串
            stringBuilder.delete(0, stringBuilder.length());

        }
        return result;
    }
}
