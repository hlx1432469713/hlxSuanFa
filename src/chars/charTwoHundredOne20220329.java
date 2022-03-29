package chars;

import java.util.Scanner;

/**
 *date：2022-03-29
 *
 * message :1004. 最大连续1的个数 III
 *
 * work : 给定一个二进制数组 nums 和一个整数 k，如果可以翻转最多 k 个 0 ，则返回 数组中连续 1 的最大个数 。
 *
 *
 */
public class charTwoHundredOne20220329 {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            int[] nums = new int[n];
            for (int i = 0;i < n;i++)
                nums[i] = scanner.nextInt();
            int k = scanner.nextInt();
            int result = longestOnes(nums,k);
            System.out.println(result);
        }
    }

    /**
     * 滑动窗口
     * @param
     * @return
     */
    static  public int longestOnes(int[] nums, int k) {
        int sum = 0;
        int left = 0;
        int right = 0;
        int max = 0;
        while(left <= right && right <nums.length){
            if (nums[right] == 0){
                sum++;
            }
            while(sum > k){
                if (nums[left] == 0){
                    sum--;
                }
                left++;
            }
            max = Math.max(max,right - left + 1);
            right++;
        }
        return max;
    }
}
