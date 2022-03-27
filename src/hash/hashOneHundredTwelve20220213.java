package hash;

import java.util.Scanner;

/**
 *date：2022-02-13
 *
 * message :  “气球” 的最大数量
 *
 * work :  给你一个字符串text，你需要使用 text 中的字母来拼凑尽可能多的单词"balloon"（气球）。
 *
 * 字符串text 中的每个字母最多只能被使用一次。请你返回最多可以拼凑出多少个单词"balloon"。
 */
public class hashOneHundredTwelve20220213 {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String text = scanner.next();
            int result = maxNumberOfBalloons(text);
            System.out.print(result);
        }

    }
    static public int maxNumberOfBalloons(String text) {
        char[] str = text.toCharArray();
        int[] flag = new int[5];
        for (char c : str){
            switch (c){
                case 'a':
                    flag[0] = flag[0] + 2;
                    break;
                case 'b':
                    flag[1] = flag[1] + 2;
                    break;
                case 'n':
                    flag[2] = flag[2] + 2;
                    break;
                case 'l':
                    flag[3] = flag[3] + 1;
                    break;
                case 'o':
                    flag[4] = flag[4] + 1;
                    break;
            }
        }
        int maxNum =flag[0]/2;
        for (int i = 0;i < 5;i++){
            maxNum = Math.min(maxNum,flag[i]/2);
        }
        return maxNum;

    }

}
