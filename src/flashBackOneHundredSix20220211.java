import java.util.*;

/**
 *date：2022-02-11
 *
 * message :  组合总和
 *
 * work : 给你一个 无重复元素 的整数数组candidates 和一个目标整数target，
 * 找出candidates中可以使数字和为目标数target 的 所有不同组合 ，并以列表形式返回。
 * 你可以按 任意顺序 返回这些组合。
 *
 * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
 *
 * 对于给定的输入，保证和为target 的不同组合数少于 150 个。
 */
public class flashBackOneHundredSix20220211 {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int n = scanner.nextInt();
            int[] candidates = new int[n];
            for (int i = 0;i < n;i++)
                candidates[i] = scanner.nextInt();
            int target = scanner.nextInt();
            List<List<Integer>> list = combinationSum(candidates,target);
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

    //candidates---需要注意 该数组 无重复数字
    static public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates.length == 0)
            return list;
        Arrays.sort(candidates);
//        for (int i = 1;i <= (target / candidates[0]);i++){
//            backtracking(candidates,target,i,0,0);
//        }
        backtracking2(candidates,target,0,0);
        return list;
    }
    //k     代表组合里面的元素总个数
    //sum   代表组合里面已有元素的总和
    //start 代表从哪个位置开始遍历
    static public void backtracking(int[] candidates,int target,int k,int sum,int start){
        if (path.size() == k){
            if (sum == target)
                list.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < candidates.length;i++){
            path.add(candidates[i]);
            backtracking(candidates,target,k,sum + candidates[i],i);
            path.removeLast();
        }
    }

    //优化回溯法--剪枝
    static public void backtracking2(int[] candidates,int target,int sum,int start){
        if (sum == target) {
            list.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < candidates.length ;i++){
            if(sum + candidates[i] <= target) {
                path.add(candidates[i]);
                backtracking2(candidates, target, sum + candidates[i], i);
                path.removeLast();
            }
        }
    }

}
