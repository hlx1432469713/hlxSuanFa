import java.util.Scanner;

/**
 *date：2021-10-25
 *
 * message ：二分查找（有序数组---无重复元素）
 *
 * work:给定一个 正整数 num ，编写一个函数，如果 num 是一个完全平方数，则返回 true ，否则返回 false 。
 *
 *
 */
public class shuZuFive20211025 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int num  = scanner.nextInt();
        boolean result = idPerfectSquare(num);
        System.out.println(result);
    }
    //二分查找法
    static public boolean idPerfectSquare(int num){
        int left = 0,right = num/2+1;
        if(num == 1)
            return true;
        while(left<right){
            int mid = left + ((right - left)>>1);
            if((long)mid*mid == num)
                return true;
            else if((long)mid*mid < num){
                left = mid + 1;
            }else
                right = mid;
        }
        return false;
    }
}
