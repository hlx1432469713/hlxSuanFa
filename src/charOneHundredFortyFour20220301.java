import java.util.Scanner;

/**
 *date：2022-03-01
 *
 * message ： Z 字形变换
 *
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "PAYPALISHIRING"行数为 3 时，排列如下：
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 *
 * 请你实现这个将字符串进行指定行数变换的函数：
 *
 * string convert(string s, int numRows);
 *
 *
 */
public class charOneHundredFortyFour20220301 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()){
            String s = scanner.next();
            int numRows = scanner.nextInt();
            String result = convert2(s,numRows);
            System.out.println(result);
        }
    }
    static public String convert(String s, int numRows) {
        if (numRows == 1)
            return s;
        int x = 2 * numRows - 2;
        int length = s.length();
        int index = length / x;
        int next = length % x;
        int n = index * (numRows - 1);
        if(next > numRows)
            n+=(next - numRows + 1);
        else if(next > 0)
            n+=1;
        char[][] list = new char[numRows][n];
        int left = 0;
        int right = 0;
        int flag = 0;
        for(int i = 0;i < s.length();i++){
            list[left][right] = s.charAt(i);
            flag++;
            if (flag >= numRows && flag <= x ){
                right++;
                left--;
            }else if (flag > x){
                flag = 1;
                left++;
            }else{
                left++;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (char[] chars : list){
            for (char c : chars){
                if (c != '\0')
                    stringBuilder.append(c);
            }
        }

        return stringBuilder.toString();

    }

    //优化--二维数组转一维数组
    static public String convert2(String s, int numRows) {
        if (numRows == 1)
            return s;
        //根据行数，确定每一组的个数
        int x = 2 * numRows - 2;
        int flag = 0;
        StringBuilder[] mat = new StringBuilder[numRows];
        for (int i = 0;i <mat.length;i++)
            mat[i] = new StringBuilder();
        for (int i = 0;i < s.length();i++){
            mat[flag].append(s.charAt(i));
            if (i % x  < numRows - 1){
                flag++;
            }else
                flag--;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (StringBuilder builder : mat) {
            stringBuilder.append(builder);
        }
        return stringBuilder.toString();
    }
}
