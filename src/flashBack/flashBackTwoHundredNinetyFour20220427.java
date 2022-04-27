package flashBack;

import java.util.Scanner;

/**
 *date：2022-04-27
 *
 * message :剑指 Offer 17. 打印从1到最大的n位数
 *
 * work :输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，
 * 则打印出 1、2、3 一直到最大的 3 位数 999。
 *
 */
public class flashBackTwoHundredNinetyFour20220427 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            int n = scanner.nextInt();
            String s = printNumbers(n);
            System.out.println(s);
        }
    }

    static StringBuilder result = new StringBuilder();
    static int count = 0;
    static public String printNumbers(int n) {
        for(int i = 1; i <= n;i++){
            char[] list = new char[i];
            for(char j = '1';j <= '9';j++){
                list[0] = j;
                backIng(1,list,i);
            }
        }
        result.deleteCharAt(result.length() - 1);
        return result.toString();
    }
    static public void backIng(int index,char[] num,int sum){
        if(index == sum){
            result.append(Integer.valueOf(String.valueOf(num)) + ",");
            return;
        }
        for(char i = '0'; i <= '9';i++){
            num[index] = i;
            backIng(index + 1,num,sum);
        }
    }

}
