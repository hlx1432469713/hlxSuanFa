package shuZu;

import java.util.Arrays;
import java.util.Scanner;

/**
 *date：2022-03-28
 *
 * message :16. 最接近的三数之和
 *
 * work : 给你一个长度为 n 的整数数组nums和 一个目标值target。请你从 nums 中选出三个整数，使它们的和与target最接近。
 *
 * 返回这三个数的和。
 *
 * 假定每组输入只存在恰好一个解。
 *
 *
 */
public class shuZuOneHundredNintySeven20220328 {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n =scanner.nextInt();
            int[] nums = new int[n];
            for(int i = 0;i < nums.length;i++)
                nums[i] = scanner.nextInt();
            int target = scanner.nextInt();
            int result = threeSumClosest(nums,target);
            System.out.println(result);
        }
    }

    /**
     * 双指针
     * @param nums
     * @param target
     * @return
     */
    static public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        int flag = 0;
        int index = Integer.MAX_VALUE;
        int sum = 0;
        for(int i = 0; i< nums.length - 1;i++){
            left = i + 1;
            right = nums.length - 1;
            while(left < right){
                flag = nums[i] + nums[left] + nums[right];
                if(flag == target)
                    return flag;
                else if(flag < target){
                    left++;
                }else{
                    right--;
                }
                if(Math.abs(flag - target) < Math.abs(index)){
                    sum = flag;
                    index = flag - target;
                }
            }
        }
        return sum;
    }
}
