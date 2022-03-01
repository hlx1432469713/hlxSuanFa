import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 *date：2022-02-23
 *
 * message : 剑指 Offer II 080. 含有 k 个元素的组合
 *
 * work :给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 */
public class flashBackOneHundredThirty20220223 {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

    }

    static LinkedList<Integer> path = new LinkedList<>();
    static List<List<Integer>> list = new ArrayList<>();
    static public List<List<Integer>> combine(int n, int k) {
        backtracking(n,k,1,0);
        return list;
    }
    static public void backtracking(int n,int k,int start,int sum){
        if (sum == k){
            list.add(new ArrayList<>(path));
            return;
        }
        //进行剪枝---根据需要  k个元素 和 已经有sum个元素 计算最多可以到哪个数字  n - (k - sum) + 1
        for (int i = start;i <= (n - (k - sum) + 1);i++){
            path.add(i);
            backtracking(n,k,i + 1,sum + 1);
            path.removeLast();
        }
    }


}
