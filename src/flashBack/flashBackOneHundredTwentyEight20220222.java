package flashBack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *date：2022-02-22
 *
 * message : 计算各个位数不同的数字个数
 *
 * work :给定一个非负整数 n，计算各位数字都不同的数字 x 的个数，其中 0 ≤ x < 10n 。
 */
public class flashBackOneHundredTwentyEight20220222 {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int s = scanner.nextInt();
            int result = countNumbersWithUniqueDigits(s);
            System.out.println(result + " ");
        }
    }

    static StringBuilder stringBuilder = new StringBuilder();
    static int index = 1;
    static public int countNumbersWithUniqueDigits(int n) {
        backtracking(n,new boolean[10]);
        return index;
    }

    static public void backtracking(int n,boolean[] flag){
        if (stringBuilder.length() == n){
            return;
        }
        for (int i = 0;i < 10;i++){
            if (flag[i] == true || (stringBuilder.length() == 0 && i == 0))
                continue;
            flag[i] = true;
            index++;
            stringBuilder.append(i);
            backtracking(n,flag);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            flag[i] = false;
        }

    }


}
