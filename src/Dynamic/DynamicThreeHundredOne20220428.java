package Dynamic;

/**
 *date：2022-04-28
 *
 * message :剑指 Offer 46. 把数字翻译成字符串
 *
 * work :给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。
 * 一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。

 */
public class DynamicThreeHundredOne20220428 {
    public static void main(String[] args){}

    public int translateNum(int num) {
        String s = num + "";
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2;i <= n;i++){
            int x = Integer.valueOf(s.substring(i - 2,i));
            dp[i] = dp[i - 1];
            if(x <= 25 && s.charAt(i - 2)!='0')
                dp[i] += dp[i -2];
        }
        return dp[n];
    }
}
