package flashBack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 *date：2022-02-13
 *
 * message :  全排列II
 *
 * work : 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 */
public class flashBackOneHundredFifteen20220213 {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            int[] nums = new int[n];
            for (int i = 0;i < n;i++)
                nums[i] = scanner.nextInt();
            List<List<Integer>> list = permuteUnique(nums);
            for (List<Integer> i : list){
                System.out.print("[ ");
                for (Integer j : i){
                    System.out.print(j + ",");
                }
                System.out.print(" ]");
            }
        }
    }
    static List<List<Integer>> list = new ArrayList<>();
    static LinkedList<Integer> path = new LinkedList<>();
    static  public List<List<Integer>> permuteUnique(int[] nums) {
        backtracking(nums,new boolean[nums.length]);
        return list;
    }

    static public void backtracking(int[] nums,boolean[] flag){
        if (path.size() == nums.length){
            list.add(new ArrayList<>(path));
            return;
        }
        int[] index = new int[21];
        for (int i = 0;i < nums.length;i++){
            //防止重复使用同一位置的数字      //进行结果去重处理
            if (flag[i] == true || index[nums[i] + 10] !=0)
                continue;
            flag[i] = true;
            index[nums[i] + 10] = 1;
            path.add(nums[i]);
            backtracking(nums,flag);
            path.removeLast();
            flag[i] = false;
        }

    }

}
