package jingsai;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 *date：2022-03-06
 *
 * message : 6017. 向数组中追加 K 个整数
 *
 * work : 给你一个整数数组 nums 和一个整数 k 。请你向 nums 中追加 k 个 未 出现在 nums 中的、互不相同 的 正 整数，
 * 并使结果数组的元素和 最小 。
 *
 * 返回追加到 nums 中的 k 个整数之和。
 */
public class two20220306 {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int n = scanner.nextInt();
            int[] nums = new int[n];
            for (int i = 0;i < n;i++)
                nums[i] = scanner.nextInt();
            int k = scanner.nextInt();
            long x = minimalKSum(nums,k);
            System.out.println(x);
        }

    }
    //超出时间限制
    static  public long minimalKSum(int[] nums, int k) {
        Arrays.sort(nums);
        int index = 1;
        long sum = 0;
        int flag = 0;
        for(int i = 1;i <= nums[nums.length - 1] && k > 0;i++){
            index = i;
            if(nums[flag] <= i){
                while(flag < nums.length &&nums[flag] <= i){
                    flag++;
                }
                continue;
            }
            if(nums[flag] > i){
                sum += i;
                k--;
            }
        }
        while(k > 0){
            index++;
            sum += index ;
            k--;
        }
        return sum;
    }

    //主要优化不存在数的累加，不能采用for循环  需要采用高斯求和公式：=(首项 + 末项）x项数/2
    //首项：start    末项 start + cnt - 1      项数cnt
    static  public long minimalKSum2(int[] nums, int k) {
        Arrays.sort(nums);
       long sum = 0;
       int start = 1;
       for (int i = 0;i < nums.length;i++){
           if(start < nums[i]){
               int cnt = (int) (nums[i] - start) > k ? k : (int) (nums[i] - start);
               // 不存在的数据累计--高斯求和公式
               sum += (2L * start + cnt - 1) * cnt / 2;
               k -= cnt;
           }
           start = nums[i] + 1;
           if (k == 0)
               return sum;
       }
       if(k > 0){
           sum += (2L * start + k - 1) * k / 2;
       }
       return sum;
    }
}
