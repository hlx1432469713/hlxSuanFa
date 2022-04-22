package Dynamic;

import java.util.Scanner;

/**
 *date：2022-04-21
 *
 * message :5. 最长回文子串
 *
 * work :给你一个字符串 s，找到 s 中最长的回文子串。
 *
 *
 */
public class DynamicTwoHundredSeventyFour20220421 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String s = scanner.next();
            String str = longestPalindrome(s);
            System.out.println(str);
        }
    }

    static   public String longestPalindrome(String s) {
        int n = s.length();
        if(n == 1)
            return s;
        String result= "";
        int max = 0;
        boolean[][] dp = new boolean[n][n];
        for(int i = n - 1;i >=0;i--){
            for(int j = i;j < n;j++){
                if(s.charAt(i) == s.charAt(j)){
                    if(j - i <= 2){
                        dp[i][j] = true;
                        if(j -i + 1 > max){
                            max = j - i + 1;
                            result = s.substring(i,j + 1);
                        }
                    }else if(dp[i + 1 ][j - 1]){
                        dp[i][j] = true;
                        if(j -i + 1 > max){
                            max = j - i + 1;
                            result = s.substring(i,j + 1);
                        }
                    }
                }
            }
        }
        return result;
    }
}
