package flashBack;

import java.util.*;

/**
 *date：2022-02-10
 *
 * message :  组合
 *
 * work : 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 * 你可以按 任何顺序 返回答案。
 */
public class flashBackOneHundredTwo20220210 {
    public static void main(String args[]){
      Scanner scanner = new Scanner(System.in);
      while(scanner.hasNext()){
          int n = scanner.nextInt();
          int k = scanner.nextInt();
          List<List<Integer>> list = combine(n,k);
          for (List<Integer> i : list){
              System.out.print("[ ");
              for (Integer x : i){
                  System.out.print(x + " ,");
              }
              System.out.print(" ]");
              System.out.println();
          }

      }

    }
    static List<List<Integer>> list = new ArrayList<>();
    static LinkedList<Integer> path = new LinkedList<>();
    static void backtracking(int n,int k,int start){
        if (path.size() == k){
            list.add(new ArrayList<>(path));
            return;
        }

        for (int i = start;i <= n;i++){
            path.add(i);
            backtracking(n,k,i+1);
            path.removeLast();
        }
    }
    //回溯法 --进行剪枝
    //如果for循环选择的起始位置之后的元素个数 已经不足 我们需要的元素个数了，那么就没有必要搜索了。
    static void backtracking2(int n,int k,int start){
        if (path.size() == k){
            list.add(new ArrayList<>(path));
            return;
        }

        for (int i = start;i <= (n - (k - path.size()) + 1);i++){
            path.add(i);
            backtracking2(n,k,i+1);
            path.removeLast();
        }
    }
    static public List<List<Integer>> combine(int n, int k) {
      backtracking(n , k ,1);
      return list;
    }


}
