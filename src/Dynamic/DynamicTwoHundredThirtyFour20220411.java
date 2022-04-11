package Dynamic;

import java.util.HashSet;
import java.util.Set;

/**
 *date：2022-04-11
 *
 * message :357. 统计各位数字都不同的数字个数
 *
 * work :给你一个整数 n ，统计并返回各位数字都不同的数字 x 的个数，其中 0 <= x < 10n 。
 */
public class DynamicTwoHundredThirtyFour20220411 {
    public static void main(String[] args){}
    static public int countNumbersWithUniqueDigits(int n) {
        if(n == 0)
            return 1;
        if(n == 1)
            return 10;
        int sum = 10;
        int ans = 9;
        for(int i = 2;i <=n;i++){
            ans = ans * (11 - i);
            sum += ans;
        }
        return sum;
    }
}
