import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *date：2021-12-03
 *
 * message ：K 次取反后最大化的数组和
 *
 * work:给你一个整数数组 nums 和一个整数 k ，按以下方法修改该数组：
 *
 * 选择某个下标 i 并将 nums[i] 替换为 -nums[i] 。
 * 重复这个过程恰好 k 次。可以多次选择同一个下标 i 。
 *
 * 以这种方式修改数组后，返回数组 可能的最大和 。
 *
 *
 *
 *
 */
public class shuZuFiftyFour20211203 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int num = scanner.nextInt();
            int[] nums = new int[num];
            for (int i = 0;i < num;i++)
                nums[i] = scanner.nextInt();
            int k = scanner.nextInt();
            int result = largestSumAfterKNegations(nums,k);
            System.out.println(result);
        }


    }
    //for循环
    static public int largestSumAfterKNegations(int[] nums, int k) {
        int sum = 0;
       while(k > 0){
            int min = nums[0];
            int flag = 0;
            for(int j = 1;j < nums.length;j++){
                if(min > nums[j]){
                    min = nums[j];
                    flag = j;
                }
            }
            nums[flag] = -nums[flag];
            k--;
        }
        for(int i = 0;i < nums.length;i++)
            sum += nums[i];
        return sum;
    }

    //优化方法
    //先把数组排好序，再从头开始遍历，遇到负数就反转，遇到 0 就跳出循环，遇到正数再分情况讨论。
    //https://leetcode-cn.com/problems/maximize-sum-of-array-after-k-negations/solution/tong-ge-lai-shua-ti-la-yi-ti-liu-jie-bao-ltzg/
}
