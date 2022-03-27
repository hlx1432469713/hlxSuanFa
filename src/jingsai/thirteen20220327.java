package jingsai;

import java.util.*;

/**
 *date：2022-03-27
 *
 * message 5236. 美化数组的最少删除数（中等）
 *
 * work : 给你一个下标从 0 开始的整数数组 nums ，如果满足下述条件，则认为数组 nums 是一个 美丽数组 ：
 *
 * nums.length 为偶数
 * 对所有满足 i % 2 == 0 的下标 i ，nums[i] != nums[i + 1] 均成立
 * 注意，空数组同样认为是美丽数组。
 *
 * 你可以从 nums 中删除任意数量的元素。当你删除一个元素时，
 * 被删除元素右侧的所有元素将会向左移动一个单位以填补空缺，而左侧的元素将会保持 不变 。
 *
 * 返回使 nums 变为美丽数组所需删除的 最少 元素数目。
 *

 *
 */
public class thirteen20220327 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] nums = new int[n];
            for (int i = 0;i < n;i++)
                nums[i] = scanner.nextInt();
            int result = minDeletion(nums);
            System.out.println(result);
        }
    }

    static public int minDeletion(int[] nums) {
        if(nums.length == 1)
            return 1;
        int[] result = new int[nums.length];
        result[0] = nums[0];
        int left = 0;
        for(int i = 1;i < nums.length;i++){
            if(left % 2 == 0 && result[left] == nums[i]){
                continue;
            }
            else{
                left += 1;
                result[left] = nums[i];
            }
        }
        if(left % 2 == 0)
            return nums.length - left;
        else
            return nums.length - left - 1;
    }
}
