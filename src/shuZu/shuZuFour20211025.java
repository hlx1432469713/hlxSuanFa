package shuZu;

import java.util.Scanner;

/**
 *date：2021-10-25
 *
 * message ：二分查找（有序数组---无重复元素）
 *
 * work:给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
 *
 * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去

 *
 *
 */
public class shuZuFour20211025 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int result = mySqrtErFenChaZhao(x);
        System.out.println(result);

    }
    //自己方法暴力解决
    static int mySqrt(int x){
        if(x ==0)
            return 0;
        for(int i = 1;i <= x/2;i++ ){
            if(((long)i*i<=x)&&((long)(i+1)*(i+1)>x))
                return i;
        }
        return 1;
    }
    //二分查找算法解决
    static int mySqrtErFenChaZhao(int x){
       int left = 0,right = x ,result = -1;
       while(left<=right){
           int mid = (left + right)/2;
           if(mid * mid == x)
               return mid;
           else if((long)mid * mid > x){
                right = mid - 1;
                result = right;
           }else{
               left = mid + 1;
               result = left -1;
           }
       }
       return result;
    }
}
