package taxXin;

import java.util.Arrays;

/**
 *date：2022-03-14
 *
 * message ：738. 单调递增的数字
 * work :当且仅当每个相邻位数上的数字x和y满足x <= y时，我们称这个整数是单调递增的。
 *
 * 给定一个整数 n ，返回 小于或等于 n 的最大数字，且数字呈 单调递增 。
 */
public class tanXinOneHundredSixtyFour20220314 {
    public static void main(String[] args){}

    //暴力解法--超出时间限制
    static public int monotoneIncreasingDigits(int n) {
        if(n < 10)
            return n;
        while(true){
            boolean flag = true;
            int m = n % 10 ;
            int x;
            int num = n / 10;
            while(num > 0){
                x = num % 10;
                if(x > m){
                    flag = false;
                    break;
                }
                m = x;
                num = num / 10;
            }
            if(flag)
                return n;
            n = n -1;
        }
    }

    //贪心算法
    //例如：98，一旦出现strNum[i - 1] > strNum[i]的情况（非单调递增），
    // 首先想让strNum[i - 1]--，然后strNum[i]给为9，这样这个整数就是89，即小于98的最大的单调递增整数。
    // 采用一个flag 来标记从哪开始将后面的数字全部置为‘9’,若flag == -1，表明原数字已经是单调递增的数字 直接返回原数字即可
    static public int monotoneIncreasingDigits2(int n) {
        if(n < 10)
            return n;
        char[] str = String.valueOf(n).toCharArray();
        int flag = -1;
        for (int i = str.length - 1;i > 0;i--){
            if (str[i]  < str[i - 1] ){
                flag = i;
                str[i - 1]--;
            }
        }
        if (flag == -1)
            return n;
        for (int i = flag;i < str.length;i++){
            str[i] = '9';
        }
        return Integer.parseInt(String.valueOf(str));
    }
}
