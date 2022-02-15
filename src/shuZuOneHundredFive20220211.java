import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 *date：2022-02-11
 *
 * message :  学生分数的最小差值
 *
 * work : 给你一个 下标从 0 开始 的整数数组 nums ，其中 nums[i] 表示第 i 名学生的分数。另给你一个整数 k 。
 *
 * 从数组中选出任意 k 名学生的分数，使这 k 个分数间 最高分 和 最低分 的 差值 达到 最小化 。
 *
 * 返回可能的 最小差值
 */
public class shuZuOneHundredFive20220211 {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            int[] nums = new int[n];
            for (int i = 0;i < n;i++)
                nums[i] = scanner.nextInt();
            int k = scanner.nextInt();
            int result = minimumDifference(nums,k);
            System.out.println(result);
        }
    }
    //先进行排序，然后使用一个长度为k的滑动窗口，最小值和最大值就是滑动窗口的左右边界，这样进行循环
    //即可得到最小差值
    static public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0;
        int right = k + left - 1;
        int min = Integer.MAX_VALUE;
        while (right < nums.length){
            int index = nums[right] - nums[left];
            if (index < min)
                min = index;
            left++;
            right++;
        }
        return min;

    }
}
