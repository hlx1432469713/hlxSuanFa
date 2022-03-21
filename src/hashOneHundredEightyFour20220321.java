import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *date：2022-03-21
 *
 * message :  560. 和为 K 的子数组
 *
 * work :  给你一个整数数组 nums 和一个整数 k ，请你统计并返回该数组中和为 k 的连续子数组的个数。
 *
 */
public class hashOneHundredEightyFour20220321 {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int n = scanner.nextInt();
            int[] words = new int[n];
            for (int i = 0;i < n;i++)
                words[i] = scanner.nextInt();
            int k = scanner.nextInt();
            int word = subarraySum(words,k);
            System.out.println(word);
        }
    }
    //前缀和 + 哈希表
    static  public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        if(nums.length == 1 ){
            if(nums[0] == k)
                return 1;
            else
                return 0;
        }
        int[] result = new int[nums.length];
        result[0] = nums[0];
        for(int i = 1;i <nums.length;i++)
            result[i] = result[i - 1] + nums[i];
        map.put(0, 1);
        int sum = 0;
        for(int i = 0;i <result.length;i++){
            if(map.containsKey(result[i] - k)){
                sum += map.get(result[i] - k);
            }
            map.put(result[i] ,map.getOrDefault(result[i],0)+ 1);
        }
        return sum;
    }

}
