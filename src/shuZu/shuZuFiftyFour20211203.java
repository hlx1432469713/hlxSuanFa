package shuZu;

import java.util.*;
import java.util.stream.IntStream;

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
        int index = -1;
       while(k > 0){
            int min = nums[0];
            int flag = 0;
            for(int j = 1;j < nums.length;j++){
                if(min > nums[j]){
                    min = nums[j];
                    flag = j;
                }
            }
            //如果当前最小已经大于0，说明数组整体全为正数，这时候只要看k是否为奇数，若是就将最小的那个置负数即可
            if (nums[flag] > 0) {
                index = flag;
                break;
            }
            nums[flag] *= -1;
            k--;
        }
       if (k % 2 == 1 && index != -1 )
           nums[index] *= -1;
        for(int i = 0;i < nums.length;i++)
            sum += nums[i];
        return sum;
    }

    //排序比较耗时间
    static public int largestSumAfterKNegations2(int[] nums, int k){
      //将数组按照绝对值大小从大到小排序
        nums = IntStream.of(nums).boxed().sorted(((o1, o2) -> Math.abs(o2) - Math.abs(o1)))
                .mapToInt(Integer::intValue).toArray();
        for(int i = 0;i < nums.length;i++){
            if(nums[i] < 0 && k > 0){
                nums[i] *= -1;
                k--;
            }
        }
        if (k % 2 == 1)
            nums[nums.length - 1] *= -1;
        int sum = 0;
        for (int x : nums)
            sum += x;
        return sum;

    }
}
