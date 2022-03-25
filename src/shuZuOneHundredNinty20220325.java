import java.util.Scanner;

/**
 *date：2022-03-24
 *
 * message :  172. 阶乘后的零
 *
 * work :
 * 给定一个整数 n ，返回 n! 结果中尾随零的数量。
 *
 * 提示 n! = n * (n - 1) * (n - 2) * ... * 3 * 2 * 1
 *
 *
 */
public class shuZuOneHundredNinty20220325 {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()){
            int n = scanner.nextInt();
            int result = trailingZeroes(n);
            System.out.println(result);
        }
    }

    static  public int trailingZeroes(int n) {
        int sum = 0;
        while(n > 0){
            sum += n / 5;
            n = n / 5;
        }
        return sum;

    }
}
