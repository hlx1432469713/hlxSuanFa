import java.util.Scanner;

/**
 *date：2021-12-01
 *
 * message ：连续字符
 *
 * work:给你一个字符串 s ，字符串的「能量」定义为：只包含一种字符的最长非空子字符串的长度。

 * 请你返回字符串的能量。
 */
public class charFifty20211201 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String s = scanner.next();
            int result = maxPower(s);
            System.out.println(result);
        }


    }

    static  public int maxPower(String s) {
        int left = 0,right = 0;
        int max = 0;
        int sum = 0;
        while(right < s.length()){
            if(s.charAt(left) == s.charAt(right)){
                right++;
                sum++;
                if(sum > max)
                    max = sum;
            }else{
                sum = 0;
                left = right;
            }
        }
        return max;
    }

}
