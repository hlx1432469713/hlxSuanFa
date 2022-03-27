package chars;

import java.util.Scanner;

/**
 *date：2022-03-03
 *
 * message ：2055. 蜡烛之间的盘子
 *
 * work：给你一个长桌子，桌子上盘子和蜡烛排成一列。给你一个下标从 0开始的字符串s，它只包含字符'*' 和'|'，
 * 其中'*'表示一个 盘子，'|'表示一支蜡烛。
 *
 * 同时给你一个下标从 0开始的二维整数数组queries，其中queries[i] = [lefti, righti]表示 子字符串s[lefti...righti]
 * 包含左右端点的字符）。对于每个查询，你需要找到 子字符串中在 两支蜡烛之间的盘子的 数目。
 * 如果一个盘子在 子字符串中左边和右边 都至少有一支蜡烛，那么这个盘子满足在 两支蜡烛之间。
 *
 * 比方说，s = "||**||**|*"，查询[3, 8]，
 * 表示的是子字符串"*||**|"。子字符串中在两支蜡烛之间的盘子数目为2，子字符串中右边两个盘子在它们左边和右边 都 至少有一支蜡烛。
 * 请你返回一个整数数组answer，其中answer[i]是第i个查询的答案。
 *
。
 *
 */
public class charOneHundredFiftyTwo20220308 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()){

        }
    }

    //时间复杂度过高
    static  public int[] platesBetweenCandles(String s, int[][] queries) {
        int n = queries.length;

        int[] result = new int[n];
        char[] chars = s.toCharArray();
        int flag = 0;
        for (int[] query : queries) {
           int left = query[0];
           int right = query[1];
           int sum = 0;
           while(left < right) {
               if (chars[left] !='|')
                   left++;
               else if(chars[right] != '|'){
                   right--;
               }else{
                   break;
               }
           }
           if (left >= right){
               flag++;
               continue;
           }
           for (int i =left;i <= right;i++){
               if (chars[i] == '*')
                   sum++;
           }
           result[flag] = sum;
           flag++;
        }

        return result;

    }

    static  public int[] platesBetweenCandles2(String s, int[][] queries){
        int n = s.length();
        //前缀和数组
        int[] preSum = new int[n];
        int[] result = new int[queries.length];
        //计算所属该位置元素 的左右蜡烛的位置
        int[] left = new int[n];
        int[] right = new int[n];

        char[] chars = s.toCharArray();
        int sum = 0;
        //求盘子数量的前缀和
        for (int i = 0;i < chars.length;i++){
            if (chars[i] == '*')
                sum++;
            preSum[i] = sum;
        }
        //求该位置，往左 距离最近的蜡烛的位置
        for(int i = 0,l = -1;i < n;i++){
            if (chars[i] == '|'){
                l = i;
            }
            left[i] = l;
        }
        //求该位置，往右 距离最近的蜡烛的位置
        for (int i = n - 1,r = -1;i >=0;i--){
            if (chars[i] == '|'){
                r = i;
            }
            right[i] = r;
        }
        //要计算区间蜡烛数量，首先要确定左边界 元素所对应的往右 距离最近的蜡烛的位置（right）
        //                        右边界，元素所对应的往左的 距离最近的蜡烛的位置
        for (int i = 0;i < queries.length;i++){
            int leftNew = right[queries[i][0]];
            int rigthNew = left[queries[i][1]];
            if (leftNew >= rigthNew || leftNew == -1 || rigthNew == -1){
                result[i] = 0;
            }else{
                result[i] = preSum[rigthNew] - preSum[leftNew];
            }
        }
        return result;
    }
}
