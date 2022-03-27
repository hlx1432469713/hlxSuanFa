package flashBack;

import java.util.*;

/**
 *date：2022-02-12
 *
 * message :  子集II
 *
 * work :  给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 */
public class flashBackOneHundredTen20220212 {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            int[] nums = new int[n];
            for (int i = 0;i < n;i++)
                nums[i] = scanner.nextInt();
            List<List<Integer>> list = subsetsWithDup(nums);
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
    static public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtracking(nums,0);
        return list;
    }
    static void backtracking(int[] nums,int start){
        list.add(new ArrayList<>(path));
        if (start >= nums.length)
            return;
        for (int i = start;i < nums.length;i++){
            if (i > start && nums[i] == nums[i - 1])
                continue;
            path.add(nums[i]);
            backtracking(nums,i + 1);
            path.removeLast();
        }
    }
}
