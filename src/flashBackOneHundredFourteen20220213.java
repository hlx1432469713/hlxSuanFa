import java.util.*;

/**
 *date：2022-02-13
 *
 * message :  全排列
 *
 * work : 给定一个“不含重复数字”的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 */
public class flashBackOneHundredFourteen20220213 {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            int[] nums = new int[n];
            for (int i = 0;i < n;i++)
                nums[i] = scanner.nextInt();
            List<List<Integer>> list = permute(nums);
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
    static  public List<List<Integer>> permute(int[] nums) {
        backtracking(nums,new boolean[nums.length]);
        return list;
    }

    static public void backtracking(int[] nums,boolean[] flag){
        if (path.size() == nums.length) {
            list.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0;i <nums.length;i++){
            if (flag[i] == true)
                continue;
            flag[i] = true;
            path.add(nums[i]);
            backtracking(nums,flag);
            path.removeLast();
            flag[i] = false;
        }


    }

}
