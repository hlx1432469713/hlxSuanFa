import java.util.*;

/**
 *date：2022-02-11
 *
 * message :  组合总和II
 *
 * work : 给定一个候选人编号的集合candidates和一个目标数target，找出candidates中所有可以使数字和为target的组合。
 *
 * candidates中的每个数字在每个组合中只能使用一次。
 *
 * 注意：解集不能包含重复的组合。
 */
public class flashBackOneHundredSeven20220211 {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int n = scanner.nextInt();
            int[] candidates = new int[n];
            for (int i = 0;i < n;i++)
                candidates[i] = scanner.nextInt();
            int target = scanner.nextInt();
            List<List<Integer>> list = combinationSum2(candidates,target);
            for (List<Integer> i : list){
                System.out.print("[ ");
                for (Integer j : i){
                    System.out.print(j + ", ");
                }
                System.out.print(" ] ");
            }
        }
    }
    static List<List<Integer>> list = new ArrayList<>();
    static LinkedList<Integer> path = new LinkedList<>();

    //candidates---需要注意 该数组存在重复数字--需要对组合进行去重
    static public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtracking(candidates,target,0,0);
        return list;
    }
    static public void backtracking(int[] candidates, int target,int sum,int start) {
        if (sum == target) {
            list.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1])
                continue;
            if (sum + candidates[i] <= target) {
                path.add(candidates[i]);
                backtracking(candidates, target, sum + candidates[i], i + 1);
                path.removeLast();
            }
        }
    }
}
