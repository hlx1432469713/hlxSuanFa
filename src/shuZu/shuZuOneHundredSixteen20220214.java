package shuZu;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 *date：2022-02-14
 *
 * message :  有序数组中的单一元素
 *
 * work : 给你一个仅由整数组成的有序数组，其中每个元素都会出现两次，唯有一个数只会出现一次。
 *
 * 请你找出并返回只出现一次的那个数。
 *
 * 你设计的解决方案必须满足 O(log n) 时间复杂度和 O(1) 空间复杂度。
 *
 */
public class shuZuOneHundredSixteen20220214 {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            int[] nums = new int[n];
            for (int i = 0;i < n;i++)
                nums[i] = scanner.nextInt();
            int result = singleNonDuplicate2(nums);
            System.out.println(result);
        }

    }
    //o(n)的时间复杂度  for循环 ^  异或操作：相同的数字异或操作为0，最后就剩下一个需要的数字
    static public int singleNonDuplicate(int[] nums) {
        int max = nums[0];
        for(int i = 1;i < nums.length;i++)
            max = max ^ nums[i];
        return max;

    }
    //二分查找--只查找偶数下标 mid = mid + 2
    //当 mid 是偶数时，mmid & 1=0；
    //当 mid 是奇数时，mid & 1=1。
    static public int singleNonDuplicate2(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        //左闭右开 -- left != right     [left,right)
        while(left < right){
            int mid = (right - left) / 2 + left;
            //当mid是奇数时 ，mid = mid - 1;
            mid -= mid & 1;
            if (nums[mid] == nums[mid + 1]){
                left = mid + 2;
            }else{
                right = mid;
            }
        }
        return nums[left];
    }
}
