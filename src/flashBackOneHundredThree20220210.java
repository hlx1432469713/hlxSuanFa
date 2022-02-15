import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 *date：2022-02-10
 *
 * message :  组合总和 III
 *
 * work : 找出所有相加之和为n 的k个数的组合。组合中只允许含有 1 -9 的正整数，并且每种组合中不存在重复的数字。
 *
 * 说明：
 *
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。
 */
public class flashBackOneHundredThree20220210 {
    public static void main(String args[]){
      Scanner scanner = new Scanner(System.in);
      while(scanner.hasNext()){
          int n = scanner.nextInt();
          int k = scanner.nextInt();
          List<List<Integer>> list = combinationSum3(k,n);
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
    //别忘了处理过程 和 回溯过程是一一对应的，处理有加，回溯就要有减！
    static void backtracking(int n,int k,int start,int all){
        if (path.size() == k ){
            if (all == n)
                list.add(new ArrayList<>(path));
            return;
        }
        for (int i = start;i <= 9;i++){
            if (i + all > n)
                break;
            path.add(i);
            backtracking(n,k,i + 1,i +all);
            path.removeLast();
        }
    }

    static public List<List<Integer>> combinationSum3(int k, int n) {
        if ( n > 9 * k)
            return list;
        backtracking(n , k ,1,0);
        return list;
    }


}
