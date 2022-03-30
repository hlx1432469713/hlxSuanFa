package shuZu;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 *date：2022-03-30
 *
 * message :  217. 存在重复元素
 *
 * work :给你一个整数数组 nums 。如果任一值在数组中出现 至少两次 ，返回 true ；如果数组中每个元素互不相同，返回 false 。
 *
 *
 */
public class shuZuTwoHundredFive20220330 {
    public static void main(String args[]){}

    static  public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0;i < nums.length;i++){
            if (set.contains(nums[i]))
                return true;
            set.add(nums[i]);
        }
        return false;
    }
}
