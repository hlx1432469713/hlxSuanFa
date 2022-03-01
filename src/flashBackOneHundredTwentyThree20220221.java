import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *date：2022-02-21
 *
 * message :  面试题 08.04. 幂集
 *
 * work : 幂集。编写一种方法，返回某集合的所有子集。集合中不包含重复的元素。
 *
 * 说明：解集不能包含重复的子集。
 *

 */
public class flashBackOneHundredTwentyThree20220221 {
    public static void main(String args[]) {

    }

    static LinkedList<Integer> path = new LinkedList<>();
    static List<List<Integer>> list = new ArrayList<>();
   static  public List<List<Integer>> subsets(int[] nums) {
       if (nums.length == 0)
           return list;
       backtracking(nums,0);
       return list;
   }
   static public void backtracking(int[] nums,int start){
       list.add(new ArrayList<>(path));
       if (start >= nums.length)
           return;
       for (int i = start;i < nums.length;i++){
           path.add(nums[i]);
           backtracking(nums, i + 1);
           path.removeLast();
       }
   }


}
