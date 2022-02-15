import java.util.*;

/**
 *date：2022-02-13
 *
 * message :  递增子序列
 *
 * work : 给你一个整数数组 nums ，找出并返回所有该数组中不同的递增子序列，递增子序列中 至少有两个元素 。
 * 你可以按 任意顺序 返回答案。
 *
 * 数组中可能含有重复元素，如出现两个整数相等，也可以视作递增序列的一种特殊情况。
 */
public class flashBackOneHundredThirteen20220213 {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            int[] nums = new int[n];
            for (int i = 0;i < n;i++)
                nums[i] = scanner.nextInt();
            List<List<Integer>> list = findSubsequences(nums);
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
    static  public List<List<Integer>> findSubsequences(int[] nums) {
        if (nums.length < 2 )
            return list;
        backtracking(nums,0);
        return list;
    }
    //使用set进行去重---效率偏低
    static public void backtracking(int[] nums,int start){
        if (path.size() >=2){
            list.add(new ArrayList<>(path));
        }
        //该层  进行set去重---放在回溯里面进行初始化
        Set<Integer> set = new HashSet<>();
        for (int i = start;i <nums.length;i++){
            if (set.contains(nums[i]))
                continue;
            if (path.size() != 0){
                if (nums[i] >= path.getLast())
                    path.add(nums[i]);
                else
                    continue;
            }else {
                path.add(nums[i]);
            }
            set.add(nums[i]);
            backtracking(nums, i + 1);
            path.removeLast();
        }

    }
    static public void backtracking2(int[] nums,int start){
        if (path.size() >=2){
            list.add(new ArrayList<>(path));
        }
        //该层  进行数组去重---放在回溯里面进行初始化
        int[] flag = new int[201];
        for (int i = start;i <nums.length;i++){
            if (flag[nums[i] + 100] != 0)
                continue;
            if (path.size() != 0){
                if (nums[i] >= path.getLast())
                    path.add(nums[i]);
                else
                    continue;
            }else {
                path.add(nums[i]);
            }
            flag[nums[i]+ 100] = 1;
            backtracking(nums, i + 1);
            path.removeLast();
        }

    }
}
