package chars;

import java.util.Arrays;
import java.util.Scanner;

/**
 *date：2022-04-21
 *
 * message :468. 验证IP地址
 *
 * work :给定一个字符串queryIP。如果是有效的 IPv4 地址，返回 "IPv4" ；如果是有效的 IPv6 地址，返回 "IPv6" ；
 * 如果不是上述类型的 IP 地址，返回 "Neither" 。
 *
 * 有效的IPv4地址 是 “x1.x2.x3.x4” 形式的IP地址。 其中0 <= xi<= 255且xi不能包含 前导零。
 * 例如:“192.168.1.1”、 “192.168.1.0” 为有效IPv4地址， “192.168.01.1” 为无效IPv4地址;
 * “192.168.1.00” 、 “192.168@1.1” 为无效IPv4地址。
 *
 * 一个有效的IPv6地址是一个格式为“x1:x2:x3:x4:x5:x6:x7:x8” 的IP地址，其中:
 *
 * 1 <= xi.length <= 4
 * xi是一个 十六进制字符串 ，可以包含数字、小写英文字母( 'a' 到 'f' )和大写英文字母( 'A' 到 'F' )。
 * 在xi中允许前导零。
 * 例如 "2001:0db8:85a3:0000:0000:8a2e:0370:7334" 和 "2001:db8:85a3:0:0:8A2E:0370:7334" 是有效的 IPv6 地址，
 * 而 "2001:0db8:85a3::8A2E:037j:7334" 和 "02001:0db8:85a3:0000:0000:8a2e:0370:7334" 是无效的 IPv6 地址。
 *
 *
 */
public class charTwoHundredSeventyOne20220421 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String s = scanner.next();
            String str = validIPAddress(s);
            System.out.println(str);
        }
    }

    static public String validIPAddress(String queryIP) {
        String b = ":.";
        String a = "0123456789abcdefABCDEF";
        int n = queryIP.length();
        if(n == 0 || (b.contains(queryIP.charAt(0) + "") ||  b.contains(queryIP.charAt(n - 1) + "")))
            return "Neither";
        else if(queryIP.contains("." ) && !queryIP.contains(":")){
            String[] list = queryIP.split("\\.");
            if(list.length != 4 ) return "Neither";
            for(String s : list){
                if(s == "" ||s.length() > 3||!isNumeric(s) || (s.charAt(0) == '0' && s.length() > 1))
                    return "Neither";
                int x = Integer.valueOf(s);
                if(x < 0 || x > 255) return "Neither";
            }
            return "IPv4";
        }else if(queryIP.contains(":" ) && !queryIP.contains("." ) ){
            String[] list = queryIP.split("\\:");
            if(list.length != 8) return "Neither";
            for(String s : list){
                if( s.length() > 4 || s == "") return "Neither";
                for(int i = 0;i < s.length();i++){
                    if(!a.contains(s.charAt(i) + ""))
                        return "Neither";
                }
            }
            return "IPv6";
        }
        return "Neither";
    }
    static public boolean isNumeric(String str){
        for(int i = 0;i < str.length();i++){
            if(!Character.isDigit(str.charAt(i))){
                return false;
            }
        }
        return true;
    }
}
