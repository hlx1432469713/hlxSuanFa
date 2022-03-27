package hash;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *date：2022-02-03
 *
 * message :  两数之和
 *
 * work : 给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出 和为目标值 target的那两个整数，
 * 并返回它们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 *
 * 你可以按任意顺序返回答案。
 *
 */
public class hashNinetyFour20220203 {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int n = scanner.nextInt();
            int[] nums = new int[n];
            for(int i = 0;i < n;i++)
                nums[i] = scanner.nextInt();
            int target = scanner.nextInt();
            int[] result = twoSum(nums,target);
            for (int i : result)
                System.out.print(i + " ");
        }
    }

    static public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        int[] newNums = new int[2];
        for (int i = 0;i < nums.length;i++){
            int num = target - nums[i];
            if (map.containsKey(num)){
                newNums[0] = i;
                newNums[1] = map.get(num);
            }
            map.put(nums[i],i);
        }
        return newNums;
    }
}
