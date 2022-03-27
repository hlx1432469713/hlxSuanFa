package flashBack;

import java.util.*;

/**
 *date：2022-02-27
 *
 * message : 698. 划分为k个相等的子集
 *
 * work : 给定一个整数数组  nums 和一个正整数 k，找出是否有可能把这个数组分成 k 个非空子集，其总和都相等。
 *
 * 字符串 s 拆分后可以得到若干 非空子字符串 ，这些子字符串连接后应当能够还原为原字符串。但是拆分出来的每个子字符串都必须是 唯一的 。
 *
 * 示例 1：
 *
 * 输入： nums = [4, 3, 2, 3, 5, 2, 1], k = 4
 * 输出： True
 * 说明： 有可能将其分成 4 个子集（5），（1,4），（2,3），（2,3）等于总和。
 * 示例 2:
 *
 * 输入: nums = [1,2,3,4], k = 3
 * 输出: false
 *
 */
public class flashBackOneHundredThirtyNine20220227 {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int n = scanner.nextInt();
            int[] nums = new int[n];
            for (int i = 0;i < n;i++)
                nums[i] = scanner.nextInt();
            int k = scanner.nextInt();
            boolean result = canPartitionKSubsets(nums,k);
            System.out.println(result);
        }

    }


    static  public boolean canPartitionKSubsets(int[] nums, int k) {
return true;
    }
    static boolean backtracking(int[] nums,int sum,int k,boolean[] used,int index,int start) {
        return true;
    }


}
