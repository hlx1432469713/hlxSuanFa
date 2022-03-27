package shuZu;

import java.util.Scanner;

/**
 *date：2021-10-26
 *
 * message ：双指针法（移除元素）
 *
 * work:给你一个数组 nums和一个值 val，你需要 原地 移除所有数值等于val的元素，并返回移除后数组的新长度。
 *不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 *

 *
 *
 */
public class shuZuSix20211026 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int num[] = new int[x];
        for(int i = 0;i < x;i++)
            num[i] = scanner.nextInt();
        int val = scanner.nextInt();
        int result = removeElement(num,val);
        System.out.println(result);
    }

    static public int  removeElement(int[] nums, int val){
        int index = 0,flag =nums.length;
        for(int i = 0;i < nums.length;i++){
            if(nums[i] == val){
                flag--;
            }else{
                nums[index] = nums[i];
                index++;
            }
        }
        return flag;
    }
}
