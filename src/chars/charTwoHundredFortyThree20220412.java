package chars;

/**
 *date：2022-04-12
 *
 * message :263. 丑数
 *
 * work :丑数 就是只包含质因数 2、3 和 5 的正整数。
 *
 * 给你一个整数 n ，请你判断 n 是否为 丑数 。如果是，返回 true ；否则，返回 false 。
 */
public class charTwoHundredFortyThree20220412 {
    public static void main(String[] args){}
    static public boolean isUgly(int n) {
        if(n <= 0)
            return false;
        if(n == 1)
            return true;
        while(n % 2 == 0) n = n /2;
        while(n % 3 == 0) n = n /3;
        while(n % 5 == 0) n = n /5;
        return n == 1;
    }
}
