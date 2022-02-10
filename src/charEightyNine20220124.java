 import java.util.Scanner;

/**
 *date：2022-01-24
 *
 * message ：二进制求和
 *
 * work:给你两个二进制字符串，返回它们的和（用二进制表示）。
 *
 * 输入为 非空 字符串且只包含数字 1 和 0。

 */
public class charEightyNine20220124 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
           String a = scanner.next();
           String b = scanner.next();
           String str = addBinary(a,b);
           System.out.println(str);
        }

    }
    static public String addBinary(String a, String b) {
        int aLength = a.length();
        int bLength = b.length();
        String str = "";
        int flag = 0;
        while(aLength > 0 || bLength>0){
            int index = 0;
            if (aLength > 0){
                int num = a.charAt(aLength - 1) - '0';
                flag = num + flag;
                aLength--;

            }
            if (bLength > 0){
                int num = b.charAt(bLength - 1) - '0';
                flag = num + flag;
                bLength--;
            }
            index = flag %2;
            if (flag > 1)
                flag = 1;
            else
                flag = 0;
            str = index + str;
        }
        if (flag == 1)
            str = "1" + str;
        return str;

    }
    static public String addBinary2(String a, String b) {
        int aLength = a.length();
        int bLength = b.length();
        StringBuffer ans = new StringBuffer();
        int flag = 0;
        while(aLength > 0 || bLength>0){
            int index = 0;
            if (aLength > 0){
                int num = a.charAt(aLength - 1) - '0';
                flag = num + flag;
                aLength--;

            }
            if (bLength > 0){
                int num = b.charAt(bLength - 1) - '0';
                flag = num + flag;
                bLength--;
            }
            index = flag %2;
            if (flag > 1)
                flag = 1;
            else
                flag = 0;
           ans.append(index+"");
        }
        if (flag == 1)
            ans.append('1');
        ans.reverse();
        return ans.toString();

    }



}
