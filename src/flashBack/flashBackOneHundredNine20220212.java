package flashBack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 *date：2022-02-12
 *
 * message :  子集
 *
 * work : 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 */
public class flashBackOneHundredNine20220212 {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            int[] nums = new int[n];
            for (int i = 0;i < n;i++)
                nums[i] = scanner.nextInt();
            List<List<Integer>> list = subsets(nums);
            for (List<Integer> i : list) {
                System.out.print("[ ");
                for (Integer j : i) {
                    System.out.print(j + ",");
                }
                System.out.print(" ]  ");
            }
        }
    }

    static List<List<Integer>> list = new ArrayList<>();
    static LinkedList<Integer> path = new LinkedList<>();
    static public List<List<Integer>> subsets(int[] nums) {
        backtracking(nums,0);
        return list;
    }
    static void backtracking(int[] nums,int start){
        list.add(new ArrayList<>(path));
        if (start >= nums.length)
            return;
        for (int i = start;i < nums.length;i++){
            path.add(nums[i]);
            backtracking(nums,i + 1);
            path.removeLast();
        }
    }
}
