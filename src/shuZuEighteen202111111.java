import java.util.Arrays;
import java.util.Scanner;

/**
 *date：2021-11-11
 *
 * message ：长度最小的子数组
 *
 * work:给定一个含有n个正整数的数组和一个正整数 target 。
 *      找出该数组中满足其和 ≥ target 的   长度最小   的 连续子数组[numsl, numsl+1, ..., numsr-1, numsr] ，
 *      并返回其 长度  。如果不存在符合条件的子数组，返回 0 。
 *
 *
 */
public class shuZuEighteen202111111 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int target = scanner.nextInt();
        int num = scanner.nextInt();
        int nums[] = new int[num];
        for(int i = 0;i<num;i++)
            nums[i] = scanner.nextInt();
        int result = minSubArrayLen2(target,nums);
        System.out.println(result);


    }

    //for循环暴力求解
    static  public int minSubArrayLen(int target, int[] nums) {
        int len = 0;
        int sum ;
        for(int i = 0;i < nums.length;i++){
            sum = 0;
            for(int j = i;j < nums.length;j++){
                sum += nums[j];
                if(sum >= target){
                    if (len == 0)
                        len = j - i + 1;
                    else if((j - i + 1) < len)
                        len = j - i + 1;
                }
            }
        }
        return len;

    }

    //滑动窗口求解
    static  public int minSubArrayLen2(int target, int[] nums) {
        int start = 0,end = 0;
        int len = 0,sumAll = 0;
        while(start < nums.length && end < nums.length){
            sumAll += nums[end];
            while(sumAll >= target){
                if(len == 0 || (end - start + 1) <len)
                    len = end - start + 1;
                sumAll -= nums[start];
                start++;
            }
            end ++;
        }
        return len;

    }


}
