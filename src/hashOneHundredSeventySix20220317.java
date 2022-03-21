import java.util.*;

/**
 *date：2022-03-17
 *
 * message :  523. 连续的子数组和
 *
 * work :  给你一个整数数组 nums 和一个整数k ，编写一个函数来判断该数组是否含有同时满足下述条件的连续子数组：
 *
 * 子数组大小 至少为 2 ，且
 * 子数组元素总和为 k 的倍数。
 * 如果存在，返回 true ；否则，返回 false 。
 *
 * 如果存在一个整数 n ，令整数 x 符合 x = n * k ，则称 x 是 k 的一个倍数。0 始终视为 k 的一个倍数。
 *
 *
 */
public class hashOneHundredSeventySix20220317 {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){

        }
    }
    // 在前缀和数组sum中，求[i,j]区间的元素总和计算公式为 result = sum[j] - sum[i - 1] = n * k
    // 因此sum[j] % k ==  sum[i - 1] % k;
    static  public boolean checkSubarraySum(int[] nums, int k) {
        if (nums.length < 2)
            return false;
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        Map<Integer,Integer> map =  new HashMap();
        map.put(0,-1);
        for (int i = 1; i < nums.length; i++) {
            sum[i] = nums[i] + sum[i - 1];
        }
        for (int i = 0; i < sum.length; i++) {
            if (map.containsKey(sum[i] % k)){
                if (i - map.get(sum[i] % k) >= 2)
                    return true;
            }
            else
                map.put(sum[i] % k ,i);
        }
        return false;
        
    }

}
