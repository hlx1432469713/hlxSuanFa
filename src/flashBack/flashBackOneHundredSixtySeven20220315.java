package flashBack;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *date：2022-03-14
 *
 * message ：剑指 Offer II 011. 0 和 1 个数相同的子数组
 *
 * work :给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。
 */
public class flashBackOneHundredSixtySeven20220315 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()){
            int n = scanner.nextInt();
            int[] nums = new int[n];
            for(int i = 0;i < n;i++)
                nums[i] = scanner.nextInt();
            int result = findMaxLength2(nums);
            System.out.println(result);
        }
    }


    static public int findMaxLength(int[] nums) {
        //将数字0当作-1 这样题目就转换成  求和为0的最长连续子数组的长度
        //首先计算 该数组对应的前缀和数组
        if (nums.length == 1)
            return 0;
        int[] sum = new int[nums.length];
        Map<Integer,Integer> map = new HashMap<>();
        sum[0] = nums[0] == 0 ? -1 : 1;
        for (int i =1;i < nums.length;i++){
            sum[i] = sum[i - 1] +(nums[i] == 0 ? -1 : 1);
        }
        int result = 0;
        for (int i = 0;i < sum.length;i++){
            if(!map.containsKey(sum[i]))
                map.put(sum[i],i);
            else{
                result = Math.max(result , i - map.get(sum[i]));
            }
        }
        return result;

    }

    static public int findMaxLength2(int[] nums) {
        //将数字0当作-1 这样题目就转换成  求和为0的最长连续子数组的长度
        //首先计算 该数组对应的前缀和数组
        if (nums.length == 1)
            return 0;
        int[] sum = new int[nums.length];
        int[] result = new int[nums.length * 2 + 1];
        for (int i = 0;i < result.length;i++)
            result[i] = -2;
        result[0 + nums.length] = -1;
        sum[0] = nums[0] == 0 ? -1 : 1;
        for (int i =1;i < nums.length;i++){
            sum[i] = sum[i - 1] +(nums[i] == 0 ? -1 : 1);
        }
        result[sum[0] + nums.length] = 0;
        int max = 0;
        for (int i = 1;i < sum.length;i++){
            if (result[sum[i] + nums.length] != -2)
                max = Math.max(max,i - result[sum[i] + nums.length]);
            else
                result[sum[i] + nums.length] = i;
        }
        return max;
    }

}
