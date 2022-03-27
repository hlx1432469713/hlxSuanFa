package shuZu;

import java.util.Scanner;

/**
 *date：2021-10-26
 *
 * message ：双指针法（移除元素）
 *
 * work:给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *

 *
 *
 */
public class shuZuSeven20211026 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int nums[] = new int[n];
        for(int i = 0;i<n;i++)
            nums[i] = scanner.nextInt();
        moveZeroes(nums);
        for(int num :nums)
            System.out.print(num);
    }

    static public void moveZeroes(int[] nums){
        int first = 0;
        for(int i = 0;i<nums.length;i++){
            if(nums[i] != 0){
                nums[first] = nums[i];
                if(first!=i)
                    nums[i] = 0;
                first++;
            }
        }
    }
}
