package flashBack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 *date：2022-02-14
 *
 * message :  找出所有子集的异或总和再求和
 *
 * work : 一个数组的 异或总和 定义为数组中所有元素按位 XOR 的结果；如果数组为 空 ，则异或总和为 0 。
 *
 * 例如，数组[2,5,6] 的 异或总和 为 2 XOR 5 XOR 6 = 1 。
 * 给你一个数组 nums ，请你求出 nums 中每个 子集 的 异或总和 ，计算并返回这些值相加之 和 。
 *
 * 注意：在本题中，元素 相同 的不同子集应 多次 计数。
 *
 * 数组 a 是数组 b 的一个 子集 的前提条件是：从 b 删除几个（也可能不删除）元素能够得到 a 。
 */
public class flashBackOneHundredSeventeen20220214 {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            int[] nums = new int[n];
            for (int i = 0;i < n;i++)
                nums[i] = scanner.nextInt();
            int result = subsetXORSum(nums);
            System.out.print(result);
        }
    }

    static LinkedList<Integer> path = new LinkedList<>();
    static int sum = 0;
    static public int subsetXORSum(int[] nums) {
        if (nums.length <= 0)
            return sum;
       // backtracking(nums,0);
        backtracking2(nums,0,0);
        return sum;
    }

    //回溯
    static public void backtracking(int[] nums,int start){
        int flag = 0;
        for (int i = 0;i < path.size();i++)
           flag = flag ^ path.get(i);
        sum += flag;
        for (int i = start;i < nums.length;i++){
            path.add(nums[i]);
            backtracking(nums,i + 1);
            path.removeLast();
        }
    }

    //优化回溯
    static public void backtracking2(int[] nums,int start,int flag){
        sum += flag;
        for (int i = start;i < nums.length;i++){
            backtracking2(nums,i + 1,flag ^ nums[i]);
        }
    }

}
